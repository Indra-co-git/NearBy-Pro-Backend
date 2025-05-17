package com.indra.co.NearBy_Pro_Backend.common.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import java.util.List;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "professionals")
public class Professional {
    @Id
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
    
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Location currentWorkLocation;

    private boolean isVerified;
} 