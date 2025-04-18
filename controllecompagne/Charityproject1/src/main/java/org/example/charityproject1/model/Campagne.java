package org.example.charityproject1.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "campagnes")
public class Campagne {

    @Id
    private String id;

    @NotBlank(message = " nom de la campagne est obligatoire")
    private String nom;

    @NotNull(message = "objectif montant est obligatoire")

    @Positive(message = "objectif montant doit etre superieur que 0")
    private BigDecimal objectifMontant;

    @NotNull(message = "La date de debut est obligatoire")
    private Date dateDebut;

    @FutureOrPresent(message = "La date de fin doit etre future ou presente")
    private Date dateFin;

  


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getObjectifMontant() {
        return objectifMontant;
    }

    public void setObjectifMontant(BigDecimal objectifMontant) {
        this.objectifMontant = objectifMontant;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}