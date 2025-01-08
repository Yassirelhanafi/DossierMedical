package emi.spring.dossiermedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class FicheConsultation extends FicheDeSoin{

    private String compteRendu;

    @OneToOne
    @JoinColumn(name= "consultation_id")
    private Consultation consultation;

    @OneToMany
    @JoinColumn(name="prescription_id")
    private List<Prescription> prescriptions = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="operationAnalyse_id")
    private List<OperationAnalyse> operationAnalyses = new ArrayList<>();

    public FicheConsultation(String compteRendu, Consultation consultation, List<Prescription> prescriptions, List<OperationAnalyse> operationAnalyses) {
        this.compteRendu = compteRendu;
        this.consultation = consultation;
        this.prescriptions = prescriptions;
        this.operationAnalyses = operationAnalyses;
    }

    public FicheConsultation() {}

    public FicheConsultation(String compteRendu, List<Prescription> prescriptions, List<OperationAnalyse> operationAnalyses) {
        this.compteRendu = compteRendu;
        this.prescriptions = prescriptions;
        this.operationAnalyses = operationAnalyses;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<OperationAnalyse> getOperationAnalyses() {
        return operationAnalyses;
    }

    public void setOperationAnalyses(List<OperationAnalyse> operationAnalyses) {
        this.operationAnalyses = operationAnalyses;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FicheConsultation that = (FicheConsultation) o;
        return Objects.equals(compteRendu, that.compteRendu) && Objects.equals(consultation, that.consultation) && Objects.equals(prescriptions, that.prescriptions) && Objects.equals(operationAnalyses, that.operationAnalyses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compteRendu, consultation, prescriptions, operationAnalyses);
    }

    @Override
    public String toString() {
        return "FicheConsultation{" +
                "compteRendu='" + compteRendu + '\'' +
                ", consultation=" + consultation +
                ", prescriptions=" + prescriptions +
                ", operationAnalyses=" + operationAnalyses +
                '}';
    }

    public void add(int index, Prescription element) {
        prescriptions.add(index, element);
    }

    public Prescription remove(int index) {
        return prescriptions.remove(index);
    }

    public int size() {
        return prescriptions.size();
    }

    public boolean remove(Object o) {
        return prescriptions.remove(o);
    }
}
