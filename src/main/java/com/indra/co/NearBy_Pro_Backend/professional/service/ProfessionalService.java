package com.indra.co.NearBy_Pro_Backend.professional.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.co.NearBy_Pro_Backend.professional.repository.ProfessionalRepository;
import com.indra.co.NearBy_Pro_Backend.common.model.Professional;
import com.indra.co.NearBy_Pro_Backend.professional.dto.ProfessionalRegistrationRequest;
import com.indra.co.NearBy_Pro_Backend.professional.dto.ProfessionalUpdateRequest;
import com.indra.co.NearBy_Pro_Backend.professional.exception.ProfessionalException;
import com.indra.co.NearBy_Pro_Backend.common.dto.ProfessionalResponseDto;
import java.time.LocalDateTime;
import java.util.List;
import com.indra.co.NearBy_Pro_Backend.common.service.ProfessionDefinitionService;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ProfessionDefinitionService professionDefinitionService;

    public Professional registerProfessional(ProfessionalRegistrationRequest request) {
        // Check if professional already exists
        if (professionalRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent()) {
            throw new ProfessionalException("Professional with this phone number already exists", "DUPLICATE_PHONE");
        }
        
        if (request.getEmail() != null && professionalRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ProfessionalException("Professional with this email already exists", "DUPLICATE_EMAIL");
        }

        Professional professional = request.toProfessional();
        return professionalRepository.save(professional);
    }

    public Professional updateProfessional(String id, ProfessionalUpdateRequest request) {
        Professional professional = professionalRepository.findById(id)
                .orElseThrow(() -> new ProfessionalException("Professional not found with id: " + id, "NOT_FOUND"));

        // Update fields if they are not null
        if (request.getProfessionDefinitions() != null) {
            professional.setProfessionDefinitions(request.getProfessionDefinitions());
        }
        
        professional.setUpdatedAt(LocalDateTime.now());
        
        return professionalRepository.save(professional);
    }

    public ProfessionalResponseDto getProfessional(String id) {
        Professional professional = professionalRepository.findById(id)
                .orElseThrow(() -> new ProfessionalException("Professional not found with id: " + id, "NOT_FOUND"));
        return new ProfessionalResponseDto(professional, professionDefinitionService.getProfessionDefinitions(professional.getProfessionDefinitions()));
    }

    public List<Professional> getNearbyProfessionals(double longitude, double latitude, double maxDistance) {
        validateLocationParameters(longitude, latitude, maxDistance);
        return professionalRepository.findNearbyAvailableProfessionals(longitude, latitude, maxDistance);
    }

    private void validateLocationParameters(double longitude, double latitude, double maxDistance) {
        if (maxDistance <= 0) {
            throw new ProfessionalException("Max distance must be greater than 0", "INVALID_PARAMETER");
        }

        if (longitude < -180 || longitude > 180) {
            throw new ProfessionalException("Invalid longitude value", "INVALID_PARAMETER");
        }

        if (latitude < -90 || latitude > 90) {
            throw new ProfessionalException("Invalid latitude value", "INVALID_PARAMETER");
        }
    }
} 