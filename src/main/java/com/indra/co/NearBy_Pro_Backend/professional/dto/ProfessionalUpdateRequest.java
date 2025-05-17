package com.indra.co.NearBy_Pro_Backend.professional.dto;

import com.indra.co.NearBy_Pro_Backend.common.model.Location;
import com.indra.co.NearBy_Pro_Backend.common.model.ProfessionDefinition;

import lombok.Data;

import java.util.List;

@Data
public class ProfessionalUpdateRequest {
    private Boolean isAvailable;
    private List<ProfessionDefinition> professionDefinitions;
    private Location currentWorkLocation;
    private double defaultServiceRadius;
} 