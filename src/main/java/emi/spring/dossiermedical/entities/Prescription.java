package emi.spring.dossiermedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String periode;
    private String indication;

    public Prescription(String designation, String periode, String indication) {
        this.designation = designation;
        this.periode = periode;
        this.indication = indication;
    }

    public Prescription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(id, that.id) && Objects.equals(designation, that.designation) && Objects.equals(periode, that.periode) && Objects.equals(indication, that.indication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, periode, indication);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", periode='" + periode + '\'' +
                ", indication='" + indication + '\'' +
                '}';
    }
}
