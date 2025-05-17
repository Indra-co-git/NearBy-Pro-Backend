package com.indra.co.NearBy_Pro_Backend.professionalSearchEngine.dto;

import com.indra.co.NearBy_Pro_Backend.common.model.Location;

import lombok.Data;

import java.util.List;

@Data
public class ProfessionalSearchRequest {
    // Location based search
    private Location location;
    private Double maxDistance; // in kilometers
    
    // Category based filters
    private Long categoryId;
    private Long subCategoryId;
    private List<Long> serviceTagIds;
    
    // Availability filter
    private Boolean isAvailable;
    
    // Search term for name or description
    private String searchTerm;
    
    // Sorting options
    private SortBy sortBy;
    private SortOrder sortOrder;
    
    // Pagination
    private Integer page = 0;
    private Integer size = 10;
    
    public enum SortBy {
        DISTANCE,
        RELEVANCE
    }
    
    public enum SortOrder {
        ASC,
        DESC
    }
} 