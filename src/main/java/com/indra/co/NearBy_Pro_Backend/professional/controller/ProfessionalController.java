package com.indra.co.NearBy_Pro_Backend.professional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.indra.co.NearBy_Pro_Backend.professional.model.Professional;
import com.indra.co.NearBy_Pro_Backend.professional.repository.ProfessionalRepository;
import com.indra.co.NearBy_Pro_Backend.professional.dto.ProfessionalRegistrationRequest;
import com.indra.co.NearBy_Pro_Backend.professional.dto.ProfessionalUpdateRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/professionals")
public class ProfessionalController {

    @Autowired
    private ProfessionalRepository professionalRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerProfessional(@RequestBody ProfessionalRegistrationRequest request) {
        // Check if professional already exists
        if (professionalRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent()) {
            return ResponseEntity.badRequest().body("Professional with this phone number already exists");
        }
        
        if (request.getEmail() != null && professionalRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Professional with this email already exists");
        }

        // Create new professional
        Professional professional = Professional.builder()
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .aadhaarNumber(request.getAadhaarNumber())
                .defaultServiceRadius(request.getDefaultServiceRadius())
                .address(request.getAddress())
                .currentWorkLocation(request.getCurrentWorkLocation())
                .selectedCategoriesSubCategoriesMap(request.getSelectedCategoriesSubCategoriesMap())
                .isAvailable(false) // Default to false until verified
                .isVerified(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Professional savedProfessional = professionalRepository.save(professional);
        return ResponseEntity.ok(savedProfessional);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProfessional(
            @PathVariable String id,
            @RequestBody ProfessionalUpdateRequest request) {
        
        return professionalRepository.findById(id)
                .map(professional -> {
                    // Update fields if they are not null
                    if (request.getCategoryId() != null) {
                        professional.setCategoryId(request.getCategoryId());
                    }
                    if (request.getSubCategoryId() != null) {
                        professional.setSubCategoryId(request.getSubCategoryId());
                    }
                    if (request.getServiceTagIds() != null) {
                        professional.setServiceTagIds(request.getServiceTagIds());
                    }
                    if (request.getSelectedCategoriesSubCategoriesMap() != null) {
                        professional.setSelectedCategoriesSubCategoriesMap(request.getSelectedCategoriesSubCategoriesMap());
                    }
                    
                    professional.setUpdatedAt(LocalDateTime.now());
                    
                    Professional updatedProfessional = professionalRepository.save(professional);
                    return ResponseEntity.ok(updatedProfessional);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessional(@PathVariable String id) {
        return professionalRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nearby")
    public ResponseEntity<?> getNearbyProfessionals(
            @RequestParam double longitude,
            @RequestParam double latitude,
            @RequestParam(defaultValue = "5.0") double maxDistance) {
        
        return ResponseEntity.ok(professionalRepository.findNearbyAvailableProfessionals(longitude, latitude, maxDistance));
    }
} 