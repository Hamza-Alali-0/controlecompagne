package org.example.charityproject1.repository;

import org.example.charityproject1.model.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends MongoRepository<Donation, String> {
    
    
    List<Donation> findByCampagneId(String campagneId);
}