package com.indra.co.NearBy_Pro_Backend.professional.dto;

import com.indra.co.NearBy_Pro_Backend.common.model.ProfessionDefinition;

import lombok.Data;

import java.util.List;

@Data
public class ProfessionalUpdateRequest {
    private Boolean isAvailable;
    private List<ProfessionDefinition> professionDefinitions;
    private String currentWorkLocation;
    private double defaultServiceRadius;
} 