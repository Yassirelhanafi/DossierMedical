package emi.spring.dossiermedical.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    private String heure;
    private String lieu;
    private char etatConsult;

    public Consultation(Long id, Date dateConsultation, String lieu, String heure, char etatConsult) {
        this.id = id;
        this.dateConsultation = dateConsultation;
        this.lieu = lieu;
        this.heure = heure;
        this.etatConsult = etatConsult;
    }

    public Consultation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public char getEtatConsult() {
        return etatConsult;
    }

    public void setEtatConsult(char etatConsult) {
        this.etatConsult = etatConsult;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consultation that = (Consultation) o;
        return etatConsult == that.etatConsult && Objects.equals(id, that.id) && Objects.equals(dateConsultation, that.dateConsultation) && Objects.equals(heure, that.heure) && Objects.equals(lieu, that.lieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateConsultation, heure, lieu, etatConsult);
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateConsultation=" + dateConsultation +
                ", heure='" + heure + '\'' +
                ", lieu='" + lieu + '\'' +
                ", etatConsult=" + etatConsult +
                '}';
    }
}
