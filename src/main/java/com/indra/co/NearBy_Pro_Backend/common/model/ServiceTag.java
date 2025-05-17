package com.indra.co.NearBy_Pro_Backend.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Document(collection = "service_tags")
public class ServiceTag {
    @Id
    private Long id;
    private String name;
    private String description;
    private Long subCategoryId;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 