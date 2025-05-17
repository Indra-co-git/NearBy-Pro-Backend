package com.indra.co.NearBy_Pro_Backend.user.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.annotation.Id;
import com.indra.co.NearBy_Pro_Backend.common.model.Address;
import com.indra.co.NearBy_Pro_Backend.common.model.Location;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User{
    @Id
    private String id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private List<Address> addresses;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Location currentWorkLocation;
    private boolean isActive;
} 