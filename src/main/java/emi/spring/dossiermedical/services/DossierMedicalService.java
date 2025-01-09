package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.DossierMedical;

import emi.spring.dossiermedical.entities.FicheDeSoin;
import emi.spring.dossiermedical.repositories.DossierMedicalRepository;


import jakarta.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DossierMedicalService {

    private DossierMedicalRepository dossierMedicalRepository;
    private FicheDeSoinService ficheDeSoinService;



    public DossierMedicalService(DossierMedicalRepository dossierMedicalRepository, FicheDeSoinService ficheDeSoinService) {
        this.dossierMedicalRepository = dossierMedicalRepository;
        this.ficheDeSoinService = ficheDeSoinService;

    }

    public DossierMedical create(DossierMedical dossierMedical) {

        return dossierMedicalRepository.save(dossierMedical);
    }

    public DossierMedical getDossierMedicalById(int id) {
        Optional<DossierMedical> dossierMedical = dossierMedicalRepository.findById(id);
        return dossierMedical.orElse(null);
    }

    public ResponseEntity<String> addFicheDeSoinAuDossier(FicheDeSoin ficheDeSoin, int id) {
        if(this.getDossierMedicalById(id) != null) {
            FicheDeSoin fiche = ficheDeSoinService.create(ficheDeSoin);
            DossierMedical dossierMedical = this.getDossierMedicalById(id);
            fiche.setDossierMedical(dossierMedical);
            dossierMedical.getFichesDeSoins().add(fiche);
            return ResponseEntity.status(200).body("ajout effectué avec succes!");
        }
        else {
            return ResponseEntity.status(404).body("Dossier médical avec l'ID " + id + " introuvable.");
        }
    }

    public ResponseEntity<String> removeFicheDeSoinDuDossier(int id_fichier, int id) {
        if(this.getDossierMedicalById(id) != null) {
            DossierMedical dossierMedical = this.getDossierMedicalById(id);
            if(dossierMedical.getFichesDeSoins().contains(ficheDeSoinService.getFicheDeSoinById(id_fichier))) {
                dossierMedical.getFichesDeSoins().remove(ficheDeSoinService.getFicheDeSoinById(id_fichier));
                return ResponseEntity.status(200).body("suppression effectué avec succes!");
            }
            else{
                return ResponseEntity.status(404).body("fiche avec l'ID " + id_fichier + " introuvable.");

            }
        }
        else {
            return ResponseEntity.status(404).body("Dossier médical avec l'ID " + id + " introuvable.");
        }

    }


    public List<DossierMedical> getAllDossierMedicals() {
        return dossierMedicalRepository.findAll();
    }

    public DossierMedical update(DossierMedical dossierMedical, int id) {
        Optional<DossierMedical> dossierMedicalOptional = dossierMedicalRepository.findById(id);
        if (dossierMedicalOptional.isPresent()) {
            dossierMedicalOptional.get().setDateCreation(dossierMedical.getDateCreation());
            dossierMedicalOptional.get().setFichesDeSoins(dossierMedical.getFichesDeSoins());
            return dossierMedicalRepository.save(dossierMedicalOptional.get());
        }
        return dossierMedicalRepository.save(dossierMedical);
    }

    public void delete(int id) {
        Optional<DossierMedical> dossierMedicalOptional = dossierMedicalRepository.findById(id);
        if (dossierMedicalOptional.isPresent()) {
            DossierMedical dossierMedical = dossierMedicalOptional.get();
            dossierMedical.getFichesDeSoins().forEach(fiche -> fiche.setDossierMedical(null));
        }
        dossierMedicalRepository.deleteById(id);

    }


}
