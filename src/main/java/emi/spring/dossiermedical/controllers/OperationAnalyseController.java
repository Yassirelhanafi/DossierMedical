package emi.spring.dossiermedical.controllers;

import emi.spring.dossiermedical.entities.OperationAnalyse;
import emi.spring.dossiermedical.services.OperationAnalyseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operationAnalyse")
public class OperationAnalyseController {
    private final OperationAnalyseService operationAnalyseService;

    public OperationAnalyseController(OperationAnalyseService operationAnalyseService) {
        this.operationAnalyseService = operationAnalyseService;
    }

    @GetMapping("/all")
    public List<OperationAnalyse> getAllOperationAnalyses() {
        return operationAnalyseService.getAllOperationAnalyses();
    }

    @GetMapping("/{id}")
    public OperationAnalyse getOperationAnalyseById(@PathVariable Long id) {
        return operationAnalyseService.getOperationAnalyseById(id);
    }

    @PostMapping("/create")
    public OperationAnalyse createOperationAnalyse(@RequestBody OperationAnalyse operationAnalyse) {
        return operationAnalyseService.create(operationAnalyse);
    }

    @PutMapping("/update/{id}")
    public OperationAnalyse updateOperationAnalyse(@RequestBody OperationAnalyse operationAnalyse, @PathVariable Long id) {
        return operationAnalyseService.update(operationAnalyse,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOperationAnalyse(@PathVariable Long id) {
        operationAnalyseService.delete(id);
    }



}
