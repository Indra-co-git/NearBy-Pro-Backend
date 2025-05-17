package com.indra.co.NearBy_Pro_Backend.common.dto;

import com.indra.co.NearBy_Pro_Backend.common.model.Address;
import com.indra.co.NearBy_Pro_Backend.common.model.ProfessionDefinition;
import com.indra.co.NearBy_Pro_Backend.common.model.Location;
import com.indra.co.NearBy_Pro_Backend.common.model.Professional;
import java.time.LocalDateTime;
import java.util.List;

public class ProfessionalResponseDto {
        private String id;
        private String fullName;
        private String phoneNumber;
        private String email;
        private String aadhaarNumber;
        private boolean isAvailable;
        private double defaultServiceRadius; // in kilometers
        private Address address;
        private List<ProfessionDefinition> professionDefinitions;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Location currentWorkLocation;
        private boolean isVerified;

        public ProfessionalResponseDto(Professional professional, List<ProfessionDefinitionResponseDto> professionDefinitions) {
            this.id = professional.getId();
            this.fullName = professional.getFullName();
            this.phoneNumber = professional.getPhoneNumber();
            this.email = professional.getEmail();
            this.aadhaarNumber = professional.getAadhaarNumber();
            this.isAvailable = professional.isAvailable();
            this.defaultServiceRadius = professional.getDefaultServiceRadius();
            this.address = professional.getAddress();
            this.professionDefinitions = professional.getProfessionDefinitions();
            this.createdAt = professional.getCreatedAt();
            this.updatedAt = professional.getUpdatedAt();
            this.currentWorkLocation = professional.getCurrentWorkLocation();
        }
}
