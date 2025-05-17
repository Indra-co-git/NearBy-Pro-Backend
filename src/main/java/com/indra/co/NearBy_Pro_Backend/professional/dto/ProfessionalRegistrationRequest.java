package com.indra.co.NearBy_Pro_Backend.professional.dto;

import com.indra.co.NearBy_Pro_Backend.common.model.Address;
import com.indra.co.NearBy_Pro_Backend.common.model.Location;
import com.indra.co.NearBy_Pro_Backend.common.model.ProfessionDefinition;
import com.indra.co.NearBy_Pro_Backend.common.model.Professional;
import java.util.UUID;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import java.util.Map;
import java.util.List;
import java.time.LocalDateTime; 




@Data
public class ProfessionalRegistrationRequest {
    @NotBlank(message = "Full name is required")
    private String fullName;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    private String email;
    @NotBlank(message = "Aadhaar number is required")
    private String aadhaarNumber;
    @NotBlank(message = "Default service radius is required")
    private double defaultServiceRadius = 5.0;
    @NotBlank(message = "Address is required")
    private Address address;
    @NotBlank(message = "Profession definitions are required")
    private List<ProfessionDefinition> professionDefinitions;
    
    public Professional toProfessional() {
        return Professional.builder()
                .id(UUID.randomUUID().toString())
                .fullName(fullName)
                .phoneNumber(phoneNumber)
                .email(email)
                .aadhaarNumber(aadhaarNumber)
                .defaultServiceRadius(defaultServiceRadius)
                .address(address)
                .professionDefinitions(professionDefinitions)
                .isAvailable(true)
                .isVerified(false)
                .currentWorkLocation(Location.builder()
                        .latitude(address.getLocation().getLatitude())
                        .longitude(address.getLocation().getLongitude())
                        .build())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
} 