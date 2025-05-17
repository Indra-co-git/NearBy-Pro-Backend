package com.indra.co.NearBy_Pro_Backend.professional.dto;

import com.indra.co.NearBy_Pro_Backend.common.model.Address;
import com.indra.co.NearBy_Pro_Backend.common.model.Location;

import lombok.Data;

import java.util.Map;
import java.util.List;

@Data
public class ProfessionalRegistrationRequest {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String aadhaarNumber;
    private double defaultServiceRadius;
    private Address address;
    private Location currentWorkLocation;
    private Map<String, List<String>> selectedCategoriesSubCategoriesMap;
} 