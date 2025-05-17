package com.indra.co.NearBy_Pro_Backend.common.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "professionals")
public class Professional extends BaseModel {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String aadhaarNumber;
    private boolean isAvailable;
    private double defaultServiceRadius; // in kilometers
    private Address address;
    private List<ProfessionDefinition> professionDefinitions;
    
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Location currentWorkLocation;

    private boolean isVerified;
} 