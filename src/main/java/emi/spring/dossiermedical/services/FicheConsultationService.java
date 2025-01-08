package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.FicheConsultation;
import emi.spring.dossiermedical.entities.FicheConsultation;
import emi.spring.dossiermedical.entities.OperationAnalyse;
import emi.spring.dossiermedical.entities.Prescription;
import emi.spring.dossiermedical.repositories.FicheConsultationRepository;
import emi.spring.dossiermedical.repositories.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FicheConsultationService {

    private FicheConsultationRepository ficheConsultationRepository;
    private PrescriptionService prescriptionService;
    private OperationAnalyseService operationAnalyseService;

    public FicheConsultationService(FicheConsultationRepository ficheConsultationRepository,PrescriptionService prescriptionService,OperationAnalyseService operationAnalyseService) {
        this.ficheConsultationRepository = ficheConsultationRepository;
        this.prescriptionService = prescriptionService;
        this.operationAnalyseService = operationAnalyseService;
    }

    public FicheConsultation create(FicheConsultation ficheConsultation) {
        Optional<FicheConsultation> ficheConsultationOptional = ficheConsultationRepository.findById(ficheConsultation.getNumeroFiche());
        if(ficheConsultationOptional.isPresent()) {
            return ficheConsultation;
        }
        return ficheConsultationRepository.save(ficheConsultation);
    }

    public FicheConsultation getFicheConsultationById(int id) {
        Optional<FicheConsultation> ficheConsultation = ficheConsultationRepository.findById(id);
        return ficheConsultation.orElse(null);
    }

    public List<FicheConsultation> getAllFicheConsultations() {
        return ficheConsultationRepository.findAll();
    }

    public FicheConsultation update(FicheConsultation ficheConsultation, int id) {
        Optional<FicheConsultation> ficheConsultationOptional = ficheConsultationRepository.findById(id);
        if (ficheConsultationOptional.isPresent()) {
            ficheConsultationOptional.get().setAddresseCreateur(ficheConsultation.getAddresseCreateur());
            ficheConsultationOptional.get().setAgentCreateur(ficheConsultation.getAgentCreateur());
            ficheConsultationOptional.get().setDateCreation(ficheConsultation.getDateCreation());
            ficheConsultationOptional.get().setDossierMedical(ficheConsultation.getDossierMedical());
            ficheConsultationOptional.get().setCompteRendu(ficheConsultation.getCompteRendu());
            return ficheConsultationRepository.save(ficheConsultationOptional.get());
        }
        return ficheConsultationRepository.save(ficheConsultation);
    }

    public void delete(int id) {
        ficheConsultationRepository.deleteById(id);
    }


    public ResponseEntity<String> addPrescriptionAuDossier(Prescription prescription, int id) {
        if(this.getFicheConsultationById(id) != null) {
            Prescription fiche = prescriptionService.create(prescription);
            FicheConsultation ficheConsultation = this.getFicheConsultationById(id);
            ficheConsultation.getPrescriptions().add(prescription);
            return ResponseEntity.status(200).body("ajout effectué avec succes!");
        }
        else {
            return ResponseEntity.status(404).body("Fiche Consultation avec l'ID " + id + " introuvable.");
        }
    }

    public ResponseEntity<String> removeOperationAnalyseDuDossier(Long id_operationAnalyse, int id) {
        if(this.getFicheConsultationById(id) != null) {
            FicheConsultation ficheConsultation = this.getFicheConsultationById(id);
            if(ficheConsultation.getOperationAnalyses().contains(operationAnalyseService.getOperationAnalyseById(id_operationAnalyse))) {
                ficheConsultation.getOperationAnalyses().remove(operationAnalyseService.getOperationAnalyseById(id_operationAnalyse));
                return ResponseEntity.status(200).body("suppression effectué avec succes!");
            }
            else{
                return ResponseEntity.status(404).body("fiche avec l'ID " + id_operationAnalyse + " introuvable.");

            }
        }
        else {
            return ResponseEntity.status(404).body("Fiche Consultation avec l'ID " + id + " introuvable.");
        }

    }


    public ResponseEntity<String> addOperationAnalyseAuDossier(OperationAnalyse operationAnalyse, int id) {
        if(this.getFicheConsultationById(id) != null) {
            OperationAnalyse fiche = operationAnalyseService.create(operationAnalyse);
            FicheConsultation ficheConsultation = this.getFicheConsultationById(id);
            ficheConsultation.getOperationAnalyses().add(operationAnalyse);
            return ResponseEntity.status(200).body("ajout effectué avec succes!");
        }
        else {
            return ResponseEntity.status(404).body("Fiche Consultation avec l'ID " + id + " introuvable.");
        }
    }

    public ResponseEntity<String> removePrescriptionDuDossier(Long id_prescription, int id) {
        if(this.getFicheConsultationById(id) != null) {
            FicheConsultation ficheConsultation = this.getFicheConsultationById(id);
            if(ficheConsultation.getPrescriptions().contains(prescriptionService.getPrescriptionById(id_prescription))) {
                ficheConsultation.getPrescriptions().remove(prescriptionService.getPrescriptionById(id_prescription));
                return ResponseEntity.status(200).body("suppression effectué avec succes!");
            }
            else{
                return ResponseEntity.status(404).body("fiche avec l'ID " + id_prescription + " introuvable.");

            }
        }
        else {
            return ResponseEntity.status(404).body("Fiche Consultation avec l'ID " + id + " introuvable.");
        }

    }





}
