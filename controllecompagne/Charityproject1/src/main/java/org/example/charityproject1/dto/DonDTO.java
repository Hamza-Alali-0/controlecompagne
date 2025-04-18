package org.example.charityproject1.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DonDTO {
    private String id;
    private String nomDonateur;
    private String userId;
    private BigDecimal montant;
    private Date date;
    private String nomCampagne;  // Add this field

    public DonDTO(String id, String actionChariteNom, String userId, BigDecimal montant, Date date) {
        this.id = id;
        this.nomDonateur = actionChariteNom;
        this.userId = userId;
        this.montant = montant;
        this.date = date;
    }

    public DonDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomDonateur() {
        return nomDonateur;
    }

    public void setNomDonateur(String nomDonateur) {  // Fixed capitalization
        this.nomDonateur = nomDonateur;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    
    public String getNomCampagne() {
        return nomCampagne;
    }
    
    public void setNomCampagne(String nomCampagne) {
        this.nomCampagne = nomCampagne;
    }
}