package com.indra.co.NearBy_Pro_Backend.professional.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.indra.co.NearBy_Pro_Backend.common.model.Professional;
import com.indra.co.NearBy_Pro_Backend.common.model.ProfessionDefinition;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessionalRepository extends MongoRepository<Professional, String> {
    
    Optional<Professional> findByPhoneNumber(String phoneNumber);
    
    Optional<Professional> findByEmail(String email);

    List<Professional> findByProfessionDefinitionsContaining(ProfessionDefinition professionDefinition);
    
    @Query("{'currentWorkLocation': {$near: {$geometry: {type: 'Point', coordinates: [?0, ?1]}, $maxDistance: ?2}}}")
    List<Professional> findNearbyProfessionals(double longitude, double latitude, double maxDistance);
    
    @Query("{'isAvailable': true, 'currentWorkLocation': {$near: {$geometry: {type: 'Point', coordinates: [?0, ?1]}, $maxDistance: ?2}}}")
    List<Professional> findNearbyAvailableProfessionals(double longitude, double latitude, double maxDistance);
} 