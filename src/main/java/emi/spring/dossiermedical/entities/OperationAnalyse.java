package emi.spring.dossiermedical.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class OperationAnalyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateheureOperation;
    private String resultat;

    public OperationAnalyse(String description, Date dateheureOperation, String resultat) {

        this.description = description;
        this.dateheureOperation = dateheureOperation;
        this.resultat = resultat;
    }

    public OperationAnalyse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateheureOperation() {
        return dateheureOperation;
    }

    public void setDateheureOperation(Date dateheureOperation) {
        this.dateheureOperation = dateheureOperation;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OperationAnalyse that = (OperationAnalyse) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(dateheureOperation, that.dateheureOperation) && Objects.equals(resultat, that.resultat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, dateheureOperation, resultat);
    }

    @Override
    public String toString() {
        return "OperationAnalyse{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateheureOperation=" + dateheureOperation +
                ", resultat='" + resultat + '\'' +
                '}';
    }
}
