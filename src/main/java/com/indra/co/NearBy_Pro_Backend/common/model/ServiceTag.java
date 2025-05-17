package com.indra.co.NearBy_Pro_Backend.common.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "service_tags")
public class ServiceTag extends BaseModel {
    private String name;
    private String description;
    private String subCategoryId;
    private boolean isActive;
} 