package emi.spring.dossiermedical.controllers;

import emi.spring.dossiermedical.entities.Consultation;
import emi.spring.dossiermedical.services.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/all")
    public List<Consultation> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable Long id) {
        return consultationService.getConsultationById(id);
    }

    @PostMapping("/create")
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        return consultationService.create(consultation);
    }

    @PutMapping("/update/{id}")
    public Consultation updateConsultation(@RequestBody Consultation consultation, @PathVariable Long id) {
        return consultationService.update(consultation,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteConsultation(@PathVariable Long id) {
        consultationService.delete(id);
    }



}
