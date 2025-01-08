package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.DossierMedical;
import emi.spring.dossiermedical.entities.Patient;
import emi.spring.dossiermedical.repositories.DossierMedicalRepository;
import emi.spring.dossiermedical.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {

    private PatientRepository patientRepository;
    private DossierMedicalService dossierMedicalService;



    public PatientService(PatientRepository patientRepository, DossierMedicalService dossierMedicalService) {
        this.patientRepository = patientRepository;
        this.dossierMedicalService = dossierMedicalService;
    }

    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient create(Patient patient, DossierMedical dossierMedical) {
        dossierMedicalService.create(dossierMedical);
        patient.setDossierMedical(dossierMedical);
        return patientRepository.save(patient);
    }


    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient update(Patient patient, Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            patientOptional.get().setAddresse(patient.getAddresse());
            patientOptional.get().setDateNaissance(patient.getDateNaissance());
            patientOptional.get().setNom(patient.getNom());
            patientOptional.get().setnSS(patient.getnSS());
            patientOptional.get().setPrenom(patient.getPrenom());
            patientOptional.get().setSexe(patient.getSexe());
            patientOptional.get().setNumTelephone(patient.getNumTelephone());
            patientOptional.get().setDossierMedical(patient.getDossierMedical());


            return patientRepository.save(patientOptional.get());
        }
        return patientRepository.save(patient);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }


}
