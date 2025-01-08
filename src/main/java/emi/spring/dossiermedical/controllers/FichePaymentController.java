package emi.spring.dossiermedical.controllers;

import emi.spring.dossiermedical.entities.FichePayment;
import emi.spring.dossiermedical.services.FichePaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichePayment")
public class FichePaymentController {
    private final FichePaymentService fichePaymentService;

    public FichePaymentController(FichePaymentService fichePaymentService) {
        this.fichePaymentService = fichePaymentService;
    }

    @GetMapping("/all")
    public List<FichePayment> getAllFichePayments() {
        return fichePaymentService.getAllFichePayments();
    }

    @GetMapping("/{id}")
    public FichePayment getFichePaymentById(@PathVariable int id) {
        return fichePaymentService.getFichePaymentById(id);
    }

    @PostMapping("/create")
    public FichePayment createFichePayment(@RequestBody FichePayment fichePayment) {
        return fichePaymentService.create(fichePayment);
    }

    @PutMapping("/update/{id}")
    public FichePayment updateFichePayment(@RequestBody FichePayment fichePayment, @PathVariable int id) {
        return fichePaymentService.update(fichePayment,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFichePayment(@PathVariable int id) {
        fichePaymentService.delete(id);
    }



}
