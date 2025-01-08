package emi.spring.dossiermedical.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private String codeAccessPatient;

    @OneToMany(mappedBy = "dossierMedical")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<FicheDeSoin> fichesDeSoins = new ArrayList<>();

    public DossierMedical(int id, Date dateCreation, String codeAccessPatient, List<FicheDeSoin> fichesDeSoins) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.codeAccessPatient = codeAccessPatient;
        this.fichesDeSoins = fichesDeSoins;
    }

    public DossierMedical() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCodeAccessPatient() {
        return codeAccessPatient;
    }

    public void setCodeAccessPatient(String codeAccessPatient) {
        this.codeAccessPatient = codeAccessPatient;
    }

    public List<FicheDeSoin> getFichesDeSoins() {
        return fichesDeSoins;
    }

    public void setFichesDeSoins(List<FicheDeSoin> fichesDeSoins) {
        this.fichesDeSoins = fichesDeSoins;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DossierMedical that = (DossierMedical) o;
        return id == that.id && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(codeAccessPatient, that.codeAccessPatient) && Objects.equals(fichesDeSoins, that.fichesDeSoins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreation, codeAccessPatient, fichesDeSoins);
    }

    @Override
    public String toString() {
        return "DossierMedical{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", codeAccessPatient='" + codeAccessPatient + '\'' +
                ", fichesDeSoins=" + fichesDeSoins +
                '}';
    }



    public FicheDeSoin remove(int index) {
        return fichesDeSoins.remove(index);
    }

    public int size() {
        return fichesDeSoins.size();
    }

    public boolean add(FicheDeSoin ficheDeSoin) {
        return fichesDeSoins.add(ficheDeSoin);
    }

    public boolean contains(Object o) {
        return fichesDeSoins.contains(o);
    }

    public boolean remove(Object o) {
        return fichesDeSoins.remove(o);
    }
}
