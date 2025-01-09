package emi.spring.dossiermedical.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FicheDeSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroFiche;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private String agentCreateur;
    private String addresseCreateur;

    @ManyToOne
    @JoinColumn(name="dossier_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private DossierMedical dossierMedical;

    public FicheDeSoin(int numeroFiche, Date dateCreation, String agentCreateur, String addresseCreateur, DossierMedical dossierMedical) {
        this.numeroFiche = numeroFiche;
        this.dateCreation = dateCreation;
        this.agentCreateur = agentCreateur;
        this.addresseCreateur = addresseCreateur;
        this.dossierMedical = dossierMedical;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FicheDeSoin that = (FicheDeSoin) o;
        return numeroFiche == that.numeroFiche && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(agentCreateur, that.agentCreateur) && Objects.equals(addresseCreateur, that.addresseCreateur) && Objects.equals(dossierMedical, that.dossierMedical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroFiche, dateCreation, agentCreateur, addresseCreateur, dossierMedical);
    }

    @Override
    public String toString() {
        return "FicheDeSoin{" +
                "numeroFiche=" + numeroFiche +
                ", dateCreation=" + dateCreation +
                ", agentCreateur='" + agentCreateur + '\'' +
                ", addresseCreateur='" + addresseCreateur + '\'' +
                ", dossierMedical=" + dossierMedical +
                '}';
    }

    public FicheDeSoin() {
    }

    public int getNumeroFiche() {
        return numeroFiche;
    }

    public void setNumeroFiche(int numeroFiche) {
        this.numeroFiche = numeroFiche;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAgentCreateur() {
        return agentCreateur;
    }

    public void setAgentCreateur(String agentCreateur) {
        this.agentCreateur = agentCreateur;
    }

    public String getAddresseCreateur() {
        return addresseCreateur;
    }

    public void setAddresseCreateur(String addresseCreateur) {
        this.addresseCreateur = addresseCreateur;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }
}
