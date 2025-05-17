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
@Document(collection = "subcategories")
public class SubCategory extends BaseModel {
    private String name;
    private String description;
    private boolean isActive;
    private String iconUrl;
    private List<String> allowedServiceTagsIds;
} 