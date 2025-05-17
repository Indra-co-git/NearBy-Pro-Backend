package com.indra.co.NearBy_Pro_Backend.professionalSearchEngine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.indra.co.NearBy_Pro_Backend.common.model.Professional;
import com.indra.co.NearBy_Pro_Backend.professionalSearchEngine.dto.ProfessionalSearchRequest;
import com.indra.co.NearBy_Pro_Backend.professionalSearchEngine.service.ProfessionalSearchService;

@RestController
@RequestMapping("/api/v1/search/professionals")
public class ProfessionalSearchController {

    @Autowired
    private ProfessionalSearchService searchService;

    @PostMapping
    public ResponseEntity<Page<Professional>> searchProfessionals(@RequestBody ProfessionalSearchRequest request) {
        Page<Professional> results = searchService.searchProfessionals(request);
        return ResponseEntity.ok(results);
    }
} 