package emi.spring.dossiermedical.repositories;

import emi.spring.dossiermedical.entities.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Integer> {
}
