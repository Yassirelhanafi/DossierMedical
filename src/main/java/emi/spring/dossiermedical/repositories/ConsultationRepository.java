package emi.spring.dossiermedical.repositories;

import emi.spring.dossiermedical.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
