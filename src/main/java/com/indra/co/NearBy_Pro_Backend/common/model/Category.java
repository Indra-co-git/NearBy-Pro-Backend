package com.indra.co.NearBy_Pro_Backend.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
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
@Document(collection = "categories")
public class Category {
    @Id
    private Long id;
    private String name;
    private String description;
    private String iconUrl;
    private boolean isActive;
    private List<Long> subCategoriesIds;
    private List<Long> allowedServiceTagsIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}