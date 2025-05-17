package com.indra.co.NearBy_Pro_Backend.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.indra.co.NearBy_Pro_Backend.common.model.SubCategory;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SubCategoryRepository extends MongoRepository<SubCategory, Long> {

    List<SubCategory> findByIdIn(List<Long> ids);
} 