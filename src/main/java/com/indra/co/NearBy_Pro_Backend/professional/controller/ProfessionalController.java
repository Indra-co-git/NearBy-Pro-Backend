package com.indra.co.NearBy_Pro_Backend.professional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import com.indra.co.NearBy_Pro_Backend.common.dto.ProfessionalResponseDto;
import com.indra.co.NearBy_Pro_Backend.common.model.Professional;
import com.indra.co.NearBy_Pro_Backend.professional.dto.ProfessionalRegistrationRequest;
import com.indra.co.NearBy_Pro_Backend.professional.dto.ProfessionalUpdateRequest;
import com.indra.co.NearBy_Pro_Backend.professional.service.ProfessionalService;

@RestController
@RequestMapping("/api/v1/professionals")
@Validated
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @PostMapping("/register")
    public ResponseEntity<Professional> registerProfessional(
            @Validated @RequestBody ProfessionalRegistrationRequest request) {
        Professional savedProfessional = professionalService.registerProfessional(request);
        return ResponseEntity.ok(savedProfessional);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Professional> updateProfessional(
            @PathVariable String id,
            @Validated @RequestBody ProfessionalUpdateRequest request) {
        Professional updatedProfessional = professionalService.updateProfessional(id, request);
        return ResponseEntity.ok(updatedProfessional);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponseDto> getProfessional(@PathVariable String id) {
        ProfessionalResponseDto professionalResponseDto = professionalService.getProfessional(id);
        return ResponseEntity.ok(professionalResponseDto);
    }

    @GetMapping("/nearby")
    public ResponseEntity<?> getNearbyProfessionals(
            @RequestParam double longitude,
            @RequestParam double latitude,
            @RequestParam(defaultValue = "5.0") double maxDistance) {
        return ResponseEntity.ok(professionalService.getNearbyProfessionals(longitude, latitude, maxDistance));
    }
} 