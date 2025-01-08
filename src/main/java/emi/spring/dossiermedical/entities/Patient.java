package emi.spring.dossiermedical.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nSS;
    private String prenom;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private char sexe;
    private String addresse;
    private int numTelephone;

    @OneToOne
    @JoinColumn(name="patient_id")
    private DossierMedical dossierMedical;

    public Patient(Long id, String nSS, String prenom, String nom, Date dateNaissance, char sexe, String addresse, int numTelephone, DossierMedical dossierMedical) {
        this.id = id;
        this.nSS = nSS;
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.addresse = addresse;
        this.numTelephone = numTelephone;
        this.dossierMedical = dossierMedical;
    }

    public Patient(Long id, String nSS, String prenom, String nom, Date dateNaissance, char sexe, String addresse, int numTelephone) {
        this.id = id;
        this.nSS = nSS;
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.addresse = addresse;
        this.numTelephone = numTelephone;
    }

    public Patient() {
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public int getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getnSS() {
        return nSS;
    }

    public void setnSS(String nSS) {
        this.nSS = nSS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return sexe == patient.sexe && numTelephone == patient.numTelephone && Objects.equals(id, patient.id) && Objects.equals(nSS, patient.nSS) && Objects.equals(prenom, patient.prenom) && Objects.equals(nom, patient.nom) && Objects.equals(dateNaissance, patient.dateNaissance) && Objects.equals(addresse, patient.addresse) && Objects.equals(dossierMedical, patient.dossierMedical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nSS, prenom, nom, dateNaissance, sexe, addresse, numTelephone, dossierMedical);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nSS='" + nSS + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", sexe=" + sexe +
                ", addresse='" + addresse + '\'' +
                ", numTelephone=" + numTelephone +
                ", dossierMedical=" + dossierMedical +
                '}';
    }
}
