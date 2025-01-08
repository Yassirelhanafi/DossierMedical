package emi.spring.dossiermedical.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

@Entity
public class FichePayment extends FicheDeSoin {

    @Temporal(TemporalType.DATE)
    private Date dateExigibilité;
    private Date datePayement;
    private double montantPaye;
    private boolean indicateurPayement;

    public FichePayment(int numeroFiche, Date dateCreation, String agentCreateur, String addresseCreateur, DossierMedical dossierMedical, Date dateExigibilité, Date datePayement, double montantPaye, boolean indicateurPayement) {
        super(numeroFiche, dateCreation, agentCreateur, addresseCreateur, dossierMedical);
        this.dateExigibilité = dateExigibilité;
        this.datePayement = datePayement;
        this.montantPaye = montantPaye;
        this.indicateurPayement = indicateurPayement;
    }


    public FichePayment() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FichePayment that = (FichePayment) o;
        return Double.compare(montantPaye, that.montantPaye) == 0 && indicateurPayement == that.indicateurPayement && Objects.equals(dateExigibilité, that.dateExigibilité) && Objects.equals(datePayement, that.datePayement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateExigibilité, datePayement, montantPaye, indicateurPayement);
    }

    public Date getDateExigibilité() {
        return dateExigibilité;
    }

    public void setDateExigibilité(Date dateExigibilité) {
        this.dateExigibilité = dateExigibilité;
    }

    public Date getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Date datePayement) {
        this.datePayement = datePayement;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public boolean getIndicateurPayement() {
        return indicateurPayement;
    }

    public void setIndicateurPayement(boolean indicateurPayement) {
        this.indicateurPayement = indicateurPayement;
    }

    @Override
    public String toString() {
        return "FichePayment{" +
                "dateExigibilité=" + dateExigibilité +
                ", datePayement=" + datePayement +
                ", montantPaye=" + montantPaye +
                ", indicateurPayement=" + indicateurPayement +
                '}';
    }
}
