package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.*;
import emi.spring.dossiermedical.entities.FicheConsultation;
import emi.spring.dossiermedical.repositories.FicheConsultationRepository;
import emi.spring.dossiermedical.repositories.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
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
    private ConsultationService consultationService;

    public FicheConsultationService(FicheConsultationRepository ficheConsultationRepository,PrescriptionService prescriptionService,OperationAnalyseService operationAnalyseService, ConsultationService consultationService) {
        this.ficheConsultationRepository = ficheConsultationRepository;
        this.prescriptionService = prescriptionService;
        this.operationAnalyseService = operationAnalyseService;
        this.consultationService = consultationService;
    }

    public FicheConsultation create(FicheConsultation ficheConsultation) {
        if(ficheConsultation.getConsultation() != null && ficheConsultation.getDossierMedical() != null && ficheConsultation.getPrescriptions().size() != 0 && ficheConsultation.getOperationAnalyses().size() != 0 && ficheConsultation.getPrescriptions().size() != 0) {
            FicheConsultation ficheConsultationcree = ficheConsultationRepository.save(ficheConsultation);
            new ResponseEntity<>("ficheConsultation created", HttpStatus.CREATED);
            return ficheConsultationcree;
        }
        else{
            new ResponseEntity<>("ficheConsultation n'est pas crée", HttpStatus.BAD_REQUEST);
            return null;
        }
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


    public ResponseEntity<String> addPrescriptionAuDossier(Long id_prescription, int id) {
        if(this.getFicheConsultationById(id) != null) {
            if (prescriptionService.getPrescriptionById(id_prescription) != null) {
            Prescription prescription = prescriptionService.getPrescriptionById(id_prescription);
            FicheConsultation ficheConsultation = this.getFicheConsultationById(id);
            ficheConsultation.getPrescriptions().add(prescription);
            return ResponseEntity.status(200).body("ajout effectué avec succes!");
        } else {
            return ResponseEntity.status(404).body("prescription avec l'ID " + id + " introuvable.");
            }
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


    public ResponseEntity<String> addOperationAnalyseAuDossier(Long id_operation, int id) {
        if(this.getFicheConsultationById(id) != null) {
            if(operationAnalyseService.getOperationAnalyseById(id_operation) != null) {
                OperationAnalyse operationAnalyse = operationAnalyseService.getOperationAnalyseById(id_operation);
                FicheConsultation ficheConsultation = this.getFicheConsultationById(id);
                ficheConsultation.getOperationAnalyses().add(operationAnalyse);
                return ResponseEntity.status(200).body("ajout effectué avec succes!");
            }
            else{
                return ResponseEntity.status(404).body("Operation avec l'ID " + id + " introuvable.");
            }
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
