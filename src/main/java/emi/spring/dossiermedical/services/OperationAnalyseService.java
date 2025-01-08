package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.OperationAnalyse;
import emi.spring.dossiermedical.repositories.OperationAnalyseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OperationAnalyseService {

    private OperationAnalyseRepository operationAnalyseRepository;

    public OperationAnalyseService(OperationAnalyseRepository operationAnalyseRepository) {
        this.operationAnalyseRepository = operationAnalyseRepository;
    }

    public OperationAnalyse create(OperationAnalyse operationAnalyse) {
        Optional<OperationAnalyse> opAnalyse = operationAnalyseRepository.findById(operationAnalyse.getId());
        if (opAnalyse.isPresent()) {
            return opAnalyse.get();
        }
        return operationAnalyseRepository.save(operationAnalyse);
    }

    public OperationAnalyse getOperationAnalyseById(Long id) {
        Optional<OperationAnalyse> operationAnalyse = operationAnalyseRepository.findById(id);
        return operationAnalyse.orElse(null);
    }

    public List<OperationAnalyse> getAllOperationAnalyses() {
        return operationAnalyseRepository.findAll();
    }

    public OperationAnalyse update(OperationAnalyse operationAnalyse, Long id) {
        Optional<OperationAnalyse> operationAnalyseOptional = operationAnalyseRepository.findById(id);
        if (operationAnalyseOptional.isPresent()) {
            operationAnalyseOptional.get().setDescription(operationAnalyse.getDescription());
            operationAnalyseOptional.get().setDateheureOperation(operationAnalyse.getDateheureOperation());
            operationAnalyseOptional.get().setResultat(operationAnalyse.getResultat());
            return operationAnalyseRepository.save(operationAnalyseOptional.get());
        }
        return operationAnalyseRepository.save(operationAnalyse);
    }

    public void delete(Long id) {
        operationAnalyseRepository.deleteById(id);
    }


}
