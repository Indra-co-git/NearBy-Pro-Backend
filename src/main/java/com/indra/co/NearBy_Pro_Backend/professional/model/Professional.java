package com.indra.co.NearBy_Pro_Backend.professional.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.indra.co.NearBy_Pro_Backend.common.model.Address;
import com.indra.co.NearBy_Pro_Backend.common.model.Location;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    private Map<String, List<String>> selectedCategoriesSubCategoriesMap;
    
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Location currentWorkLocation;
    
    private String categoryId;
    private String subCategoryId;
    private List<String> serviceTagIds;
    
    private boolean isVerified;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 