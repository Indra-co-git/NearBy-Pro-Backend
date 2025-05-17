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
@Document(collection = "subcategories")
public class SubCategory {
    @Id
    private Long id;
    private String name;
    private String description;
    private boolean isActive;
    private String iconUrl;
    private List<Long> allowedServiceTagsIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 