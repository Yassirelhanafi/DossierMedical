package emi.spring.dossiermedical.services;

import emi.spring.dossiermedical.entities.Consultation;
import emi.spring.dossiermedical.repositories.ConsultationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsultationService {

    private ConsultationRepository consulationRepository;

    public ConsultationService(ConsultationRepository consulationRepository) {
        this.consulationRepository = consulationRepository;
    }

    public Consultation create(Consultation consulation) {
        return consulationRepository.save(consulation);
    }

    public Consultation getConsultationById(Long id) {
        Optional<Consultation> consulation = consulationRepository.findById(id);
        return consulation.orElse(null);
    }

    public List<Consultation> getAllConsultations() {
        return consulationRepository.findAll();
    }

    public Consultation update(Consultation consulation, Long id) {
        Optional<Consultation> consulationOptional = consulationRepository.findById(id);
        if (consulationOptional.isPresent()) {
            consulationOptional.get().setDateConsultation(consulation.getDateConsultation());
            consulationOptional.get().setEtatConsult(consulation.getEtatConsult());
            consulationOptional.get().setHeure(consulation.getHeure());
            consulationOptional.get().setLieu(consulation.getLieu());

            return consulationRepository.save(consulationOptional.get());
        }
        return consulationRepository.save(consulation);
    }

    public void delete(Long id) {
        consulationRepository.deleteById(id);
    }


}
