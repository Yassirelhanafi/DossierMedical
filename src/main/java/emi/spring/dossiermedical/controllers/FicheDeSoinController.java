package emi.spring.dossiermedical.controllers;

import emi.spring.dossiermedical.entities.FicheDeSoin;
import emi.spring.dossiermedical.services.FicheDeSoinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ficheDeSoin")
public class FicheDeSoinController {
    private final FicheDeSoinService ficheDeSoinService;

    public FicheDeSoinController(FicheDeSoinService ficheDeSoinService) {
        this.ficheDeSoinService = ficheDeSoinService;
    }

    @GetMapping("/all")
    public List<FicheDeSoin> getAllFicheDeSoins() {
        return ficheDeSoinService.getAllFicheDeSoins();
    }

    @GetMapping("/{id}")
    public FicheDeSoin getFicheDeSoinById(@PathVariable int id) {
        return ficheDeSoinService.getFicheDeSoinById(id);
    }

    @PostMapping("/create")
    public FicheDeSoin createFicheDeSoin(@RequestBody FicheDeSoin ficheDeSoin) {
        return ficheDeSoinService.create(ficheDeSoin);
    }

    @PutMapping("/update/{id}")
    public FicheDeSoin updateFicheDeSoin(@RequestBody FicheDeSoin ficheDeSoin, @PathVariable int id) {
        return ficheDeSoinService.update(ficheDeSoin,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFicheDeSoin(@PathVariable int id) {
        ficheDeSoinService.delete(id);
    }



}
