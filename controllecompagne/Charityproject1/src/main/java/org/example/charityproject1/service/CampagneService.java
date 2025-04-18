package org.example.charityproject1.service;

import org.example.charityproject1.model.Campagne;
import org.example.charityproject1.projection.CampagneResume;
import org.example.charityproject1.repository.CampagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CampagneService {

    @Autowired
    private CampagneRepository campagneRepository;

    
    public List<CampagneResume> getCampagnesActives() {
        return campagneRepository.findActivesCampagnes(new Date());
    }

   
    public Optional<Campagne> getCampagneById(String id) {
        return campagneRepository.findById(id);
    }
}