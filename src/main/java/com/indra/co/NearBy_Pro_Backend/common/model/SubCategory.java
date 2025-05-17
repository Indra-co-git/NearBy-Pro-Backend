package com.indra.co.NearBy_Pro_Backend.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "subcategories")
public class SubCategory {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean isActive;
    private List<String> allowedServiceTagsIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 