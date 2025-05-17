package com.indra.co.NearBy_Pro_Backend.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.indra.co.NearBy_Pro_Backend.common.model.SubCategory;
import java.util.List;

public interface SubCategoryRepository extends MongoRepository<SubCategory, String> {
} 