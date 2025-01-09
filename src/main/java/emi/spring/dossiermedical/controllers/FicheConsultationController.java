package emi.spring.dossiermedical.controllers;

import emi.spring.dossiermedical.entities.FicheConsultation;
import emi.spring.dossiermedical.entities.FicheDeSoin;
import emi.spring.dossiermedical.entities.OperationAnalyse;
import emi.spring.dossiermedical.entities.Prescription;
import emi.spring.dossiermedical.services.FicheConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ficheConsultation")
public class FicheConsultationController {
    private final FicheConsultationService ficheConsultationService;

    public FicheConsultationController(FicheConsultationService ficheConsultationService) {
        this.ficheConsultationService = ficheConsultationService;
    }

    @GetMapping("/all")
    public List<FicheConsultation> getAllFicheConsultations() {
        return ficheConsultationService.getAllFicheConsultations();
    }

    @GetMapping("/{id}")
    public FicheConsultation getFicheConsultationById(@PathVariable int id) {
        return ficheConsultationService.getFicheConsultationById(id);
    }

    @PostMapping("/create")
    public FicheConsultation createFicheConsultation(@RequestBody FicheConsultation ficheConsultation) {
        return ficheConsultationService.create(ficheConsultation);
    }

    @PutMapping("/update/{id}")
    public FicheConsultation updateFicheConsultation(@RequestBody FicheConsultation ficheConsultation, @PathVariable int id) {
        return ficheConsultationService.update(ficheConsultation,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFicheConsultation(@PathVariable int id) {
        ficheConsultationService.delete(id);
    }


    @PatchMapping("/ddPrescriptionAuDossier/{id}/{id_prescription}")
    public ResponseEntity<String> addPrescriptionAuDossier(@PathVariable Long id_prescription, @PathVariable int id) {
       return ficheConsultationService.addPrescriptionAuDossier(id_prescription, id);
    }

    @PatchMapping("/removeOperationAnalyseDuDossier/{id}/{id_fichier}")
    public ResponseEntity<String> removeOperationAnalyseDuDossier(@PathVariable Long id_operationAnalyse, @PathVariable int id) {
       return ficheConsultationService.removeOperationAnalyseDuDossier(id_operationAnalyse, id);
    }

    @PatchMapping("/addOperationAnalyseAuDossier/{id}/{id_operation}")
    public ResponseEntity<String> addOperationAnalyseAuDossier(@PathVariable Long id_operation,@PathVariable int id) {
        return ficheConsultationService.addOperationAnalyseAuDossier(id_operation, id);
    }


    @PatchMapping("/removePrescriptionDuDossier/{id}/{id_fichier}")
    public ResponseEntity<String> removePrescriptionDuDossier(@PathVariable Long id_prescription,@PathVariable int id) {
       return ficheConsultationService.removePrescriptionDuDossier(id_prescription, id);

    }





}
