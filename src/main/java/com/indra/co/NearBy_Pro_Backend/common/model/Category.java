package com.indra.co.NearBy_Pro_Backend.common.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "categories")
public class Category extends BaseModel {
    private String name;
    private String description;
    private String iconUrl;
    private boolean isActive;
    private List<String> subCategoriesIds;
    private List<String> allowedServiceTagsIds;
}