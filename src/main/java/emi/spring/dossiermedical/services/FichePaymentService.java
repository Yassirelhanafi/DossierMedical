package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.DossierMedical;
import emi.spring.dossiermedical.entities.FicheDeSoin;
import emi.spring.dossiermedical.entities.FichePayment;
import emi.spring.dossiermedical.repositories.FichePaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FichePaymentService {

    private FichePaymentRepository fichePaymentRepository;

    public FichePaymentService(FichePaymentRepository fichePaymentRepository) {
        this.fichePaymentRepository = fichePaymentRepository;
    }

    public FichePayment create(FichePayment fichePayment) {
        if(fichePayment.getDossierMedical() != null) {
            FichePayment fichePaymentcree = fichePaymentRepository.save(fichePayment);
            new ResponseEntity<>("fichePayment created", HttpStatus.CREATED);
            return fichePaymentcree;
        }
        else{
            new ResponseEntity<>("fichePayment n'est pas crée", HttpStatus.BAD_REQUEST);
            return null;
        }
    }

    public FichePayment getFichePaymentById(int id) {
        Optional<FichePayment> fichePayment = fichePaymentRepository.findById(id);
        return fichePayment.orElse(null);
    }

    public List<FichePayment> getAllFichePayments() {
        return fichePaymentRepository.findAll();
    }

    public FichePayment update(FichePayment fichePayment, int id) {
        Optional<FichePayment> fichePaymentOptional = fichePaymentRepository.findById(id);
        if (fichePaymentOptional.isPresent()) {
            fichePaymentOptional.get().setAddresseCreateur(fichePayment.getAddresseCreateur());
            fichePaymentOptional.get().setAgentCreateur(fichePayment.getAgentCreateur());
            fichePaymentOptional.get().setDateCreation(fichePayment.getDateCreation());
            fichePaymentOptional.get().setDossierMedical(fichePayment.getDossierMedical());
            fichePaymentOptional.get().setDateExigibilité(fichePayment.getDateExigibilité());
            fichePaymentOptional.get().setDatePayement(fichePayment.getDatePayement());
            fichePaymentOptional.get().setMontantPaye(fichePayment.getMontantPaye());
            fichePaymentOptional.get().setIndicateurPayement(fichePayment.getIndicateurPayement());
            return fichePaymentRepository.save(fichePaymentOptional.get());
        }
        return fichePaymentRepository.save(fichePayment);
    }

    public void delete(int id) {
        fichePaymentRepository.deleteById(id);
    }





}
