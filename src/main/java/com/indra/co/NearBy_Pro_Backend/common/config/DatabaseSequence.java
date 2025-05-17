package com.indra.co.NearBy_Pro_Backend.common.config;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "database_sequences")
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;
} 