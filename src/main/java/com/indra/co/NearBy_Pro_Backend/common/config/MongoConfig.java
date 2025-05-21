package com.indra.co.NearBy_Pro_Backend.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initIndexes() {
        // Create geospatial index for Professional collection
        mongoTemplate.getCollection("professionalsTree").createIndex(
            org.bson.Document.parse("{ \"currentWorkLocation\" : \"2dsphere\" }")
        );
    }
} 