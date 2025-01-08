package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.FicheDeSoin;
import emi.spring.dossiermedical.repositories.FicheDeSoinRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FicheDeSoinService {

    private FicheDeSoinRepository ficheDeSoinRepository;

    public FicheDeSoinService(FicheDeSoinRepository ficheDeSoinRepository) {
        this.ficheDeSoinRepository = ficheDeSoinRepository;
    }

    public FicheDeSoin create(FicheDeSoin ficheDeSoin) {
        Optional<FicheDeSoin> ficheDeSoinOptional = ficheDeSoinRepository.findById(ficheDeSoin.getNumeroFiche());
        if(ficheDeSoinOptional.isPresent()) {
            return ficheDeSoin;
        }
        return ficheDeSoinRepository.save(ficheDeSoin);
    }

    public FicheDeSoin getFicheDeSoinById(int id) {
        Optional<FicheDeSoin> ficheDeSoin = ficheDeSoinRepository.findById(id);
        return ficheDeSoin.orElse(null);
    }

    public List<FicheDeSoin> getAllFicheDeSoins() {
        return ficheDeSoinRepository.findAll();
    }

    public FicheDeSoin update(FicheDeSoin ficheDeSoin, int id) {
        Optional<FicheDeSoin> ficheDeSoinOptional = ficheDeSoinRepository.findById(id);
        if (ficheDeSoinOptional.isPresent()) {
            ficheDeSoinOptional.get().setAddresseCreateur(ficheDeSoin.getAddresseCreateur());
            ficheDeSoinOptional.get().setAgentCreateur(ficheDeSoin.getAgentCreateur());
            ficheDeSoinOptional.get().setDateCreation(ficheDeSoin.getDateCreation());
            ficheDeSoinOptional.get().setDossierMedical(ficheDeSoin.getDossierMedical());
            return ficheDeSoinRepository.save(ficheDeSoinOptional.get());
        }
        return ficheDeSoinRepository.save(ficheDeSoin);
    }

    public void delete(int id) {
        ficheDeSoinRepository.deleteById(id);
    }


}
