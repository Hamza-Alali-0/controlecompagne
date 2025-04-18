package org.example.charityproject1.service;

import org.example.charityproject1.dto.DonDTO;
import org.example.charityproject1.model.Campagne;
import org.example.charityproject1.model.Donation;
import org.example.charityproject1.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DonService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private CampagneService campagneService;

  
    public DonDTO enregistrerDon(String campagneId, DonDTO donDTO) {
        Optional<Campagne> optionalCampagne = campagneService.getCampagneById(campagneId);
        if (optionalCampagne.isEmpty()) {
            throw new RuntimeException("Campagne existe pas avec ID: " + campagneId);
        }

        Campagne campagne = optionalCampagne.get();
        
        
        Date now = new Date();
        if (now.before(campagne.getDateDebut()) || now.after(campagne.getDateFin())) {
            throw new RuntimeException("La campagne est pas active");
        }

        Donation donation = new Donation();
        donation.setCampagne(campagne);
        donation.setNomDonateur(donDTO.getNomDonateur());
        donation.setMontant(donDTO.getMontant());
        donation.setDate(new Date());

        Donation savedDonation = donationRepository.save(donation);
        
        return entityToDto(savedDonation);
    }

    

//entite vers dto 

    public DonDTO entityToDto(Donation donation) {
        DonDTO donDTO = new DonDTO();
        donDTO.setId(donation.getId());
        donDTO.setNomCampagne(donation.getCampagne().getNom());
        donDTO.setNomDonateur(donation.getNomDonateur());
        donDTO.setMontant(donation.getMontant());
        donDTO.setDate(donation.getDate());
        return donDTO;
    }
}