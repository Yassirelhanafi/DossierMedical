package emi.spring.dossiermedical.controllers;

import emi.spring.dossiermedical.entities.Prescription;
import emi.spring.dossiermedical.services.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/all")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id);
    }

    @PostMapping("/create")
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.create(prescription);
    }

    @PutMapping("/update/{id}")
    public Prescription updatePrescription(@RequestBody Prescription prescription, @PathVariable Long id) {
        return prescriptionService.update(prescription,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePrescription(@PathVariable Long id) {
        prescriptionService.delete(id);
    }



}
