package com.indra.co.NearBy_Pro_Backend.professional.dto;

import lombok.Data;

import java.util.Map;
import java.util.List;

@Data
public class ProfessionalUpdateRequest {
    private Boolean isAvailable;
    private String categoryId;
    private String subCategoryId;
    private List<String> serviceTagIds;
    private Map<String, List<String>> selectedCategoriesSubCategoriesMap;
} 