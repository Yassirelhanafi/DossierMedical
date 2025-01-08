package emi.spring.dossiermedical.repositories;

import emi.spring.dossiermedical.entities.FicheDeSoin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheDeSoinRepository extends JpaRepository<FicheDeSoin, Integer> {
}
