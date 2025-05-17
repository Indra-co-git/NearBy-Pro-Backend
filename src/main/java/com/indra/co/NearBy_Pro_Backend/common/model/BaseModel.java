package com.indra.co.NearBy_Pro_Backend.common.model;

import org.springframework.data.annotation.Id;
import lombok.Data;
import java.util.UUID;
import java.time.LocalDateTime;

@Data
public abstract class BaseModel {
    @Id
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseModel() {
        this.id = UUID.randomUUID().toString();
    }
    public String getId() {
        return id;
    }   
} 