package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.Prescription;
import emi.spring.dossiermedical.repositories.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrescriptionService {

    private PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription create(Prescription prescription) {
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(prescription.getId());
        if (prescriptionOptional.isPresent()) {
            return prescription;
        }
        return prescriptionRepository.save(prescription);
    }

    public Prescription getPrescriptionById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.orElse(null);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription update(Prescription prescription, Long id) {
        Optional<Prescription> prescriptionOptional = prescriptionRepository.findById(id);
        if (prescriptionOptional.isPresent()) {
            prescriptionOptional.get().setDesignation(prescription.getDesignation());
            prescriptionOptional.get().setIndication(prescription.getIndication());
            prescriptionOptional.get().setPeriode(prescription.getPeriode());
            return prescriptionRepository.save(prescriptionOptional.get());
        }
        return prescriptionRepository.save(prescription);
    }

    public void delete(Long id) {
        prescriptionRepository.deleteById(id);
    }


}
