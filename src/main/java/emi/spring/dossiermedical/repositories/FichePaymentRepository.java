package emi.spring.dossiermedical.repositories;

import emi.spring.dossiermedical.entities.FichePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichePaymentRepository extends JpaRepository<FichePayment, Integer> {
}
