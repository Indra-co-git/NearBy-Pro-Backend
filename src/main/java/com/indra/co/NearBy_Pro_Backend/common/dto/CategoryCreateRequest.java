package com.indra.co.NearBy_Pro_Backend.common.dto;

import lombok.Data;
import java.util.List;

@Data
public class CategoryCreateRequest {
    private String name;
    private String description;
    private String iconUrl = null;
    private List<String> subCategoriesIds = null;
    private List<String> allowedServiceTagsIds = null;
}
