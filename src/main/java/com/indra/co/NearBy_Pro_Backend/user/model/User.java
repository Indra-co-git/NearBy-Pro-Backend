package com.indra.co.NearBy_Pro_Backend.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String fullName;
    @Indexed(unique = true)
    private String phoneNumber;
    private String email;
    private List<Address> addresses;
    
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Location location;
    
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 