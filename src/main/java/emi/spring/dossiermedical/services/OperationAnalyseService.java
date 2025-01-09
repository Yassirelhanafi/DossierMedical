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
        if(operationAnalyseRepository.existsById(id)){
            operationAnalyse.setId(id);
            return operationAnalyseRepository.save(operationAnalyse);
        }
        else{
            return null;
        }
    }

    public void delete(Long id) {
        operationAnalyseRepository.deleteById(id);
    }


}
