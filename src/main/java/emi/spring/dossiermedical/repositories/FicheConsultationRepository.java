package emi.spring.dossiermedical.repositories;

import emi.spring.dossiermedical.entities.FicheConsultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheConsultationRepository extends JpaRepository<FicheConsultation, Integer> {
}
