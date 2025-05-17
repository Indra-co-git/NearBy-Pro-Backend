package com.indra.co.NearBy_Pro_Backend.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.indra.co.NearBy_Pro_Backend.common.model.Category;

public interface CategoryRepository extends MongoRepository<Category, Long> {
} 