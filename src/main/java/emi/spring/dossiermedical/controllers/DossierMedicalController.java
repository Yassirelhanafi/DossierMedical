package emi.spring.dossiermedical.controllers;

import emi.spring.dossiermedical.entities.DossierMedical;
import emi.spring.dossiermedical.entities.FicheDeSoin;
import emi.spring.dossiermedical.services.DossierMedicalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dossierMedical")
public class DossierMedicalController {
    private final DossierMedicalService dossierMedicalService;

    public DossierMedicalController(DossierMedicalService dossierMedicalService) {
        this.dossierMedicalService = dossierMedicalService;
    }

    @GetMapping("/all")
    public List<DossierMedical> getAllDossierMedicals() {
        return dossierMedicalService.getAllDossierMedicals();
    }

    @GetMapping("/{id}")
    public DossierMedical getDossierMedicalById(@PathVariable int id) {
        return dossierMedicalService.getDossierMedicalById(id);
    }

    @PostMapping("/create")
    public DossierMedical createDossierMedical(@RequestBody DossierMedical dossierMedical) {
        return dossierMedicalService.create(dossierMedical);
    }

    @PutMapping("/update/{id}")
    public DossierMedical updateDossierMedical(@RequestBody DossierMedical dossierMedical, @PathVariable int id) {
        return dossierMedicalService.update(dossierMedical, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDossierMedical(@PathVariable int id) {
        dossierMedicalService.delete(id);
    }


    @PatchMapping("/addFichetoDossier/{id}/{id_fiche}")
    public ResponseEntity<String> addFicheDeSoinAuDossier(@PathVariable int id_fiche, @PathVariable int id) {
        return dossierMedicalService.addFicheDeSoinAuDossier(id_fiche, id);
    }

    @PatchMapping("/removeFromDossier/{id}/{id_fichier}")
    public ResponseEntity<String> removeFicheDeSoinDuDossier(@PathVariable int id_fichier, @PathVariable int id) {
        return dossierMedicalService.removeFicheDeSoinDuDossier(id_fichier, id);
    }
}
