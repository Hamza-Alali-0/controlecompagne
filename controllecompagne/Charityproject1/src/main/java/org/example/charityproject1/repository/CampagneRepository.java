package org.example.charityproject1.repository;

import org.example.charityproject1.model.Campagne;
import org.example.charityproject1.projection.CampagneResume;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CampagneRepository extends MongoRepository<Campagne, String> {
    
    
    @Query("{'dateDebut': {$lte: ?0}, 'dateFin': {$gte: ?0}}")
    
    List<CampagneResume> findActivesCampagnes(Date currentDate);
}