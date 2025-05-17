package com.nearbypro.common.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String type = "Point";
    private double[] coordinates; // [longitude, latitude]
    
    public Location(double longitude, double latitude) {
        this.coordinates = new double[]{longitude, latitude};
    }
} 