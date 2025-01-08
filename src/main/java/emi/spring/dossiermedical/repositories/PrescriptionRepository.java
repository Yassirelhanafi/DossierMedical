package emi.spring.dossiermedical.repositories;

import emi.spring.dossiermedical.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
