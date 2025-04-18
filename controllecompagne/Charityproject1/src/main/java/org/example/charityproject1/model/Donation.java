package org.example.charityproject1.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "donations")
public class Donation {

    @Id
    private String id;

    @DBRef
    @NotNull(message = "La campagne est obligatoire")
    private Campagne campagne;

    @NotBlank(message = "Le nom du donateur est obligatoire")
    private String nomDonateur;

    @NotNull(message = "Le montant est obligatoire")

    @Positive(message = "Le montant doit etre suprieur que 0")
    private BigDecimal montant;

    @NotNull(message = "La date est obligatoire")
    private Date date;

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Campagne getCampagne() {
        return campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    public String getNomDonateur() {
        return nomDonateur;
    }

    public void setNomDonateur(String nomDonateur) {
        this.nomDonateur = nomDonateur;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}