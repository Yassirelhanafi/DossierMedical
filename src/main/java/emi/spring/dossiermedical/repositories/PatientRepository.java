package emi.spring.dossiermedical.repositories;

import emi.spring.dossiermedical.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
