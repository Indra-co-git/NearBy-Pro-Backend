package com.indra.co.NearBy_Pro_Backend.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.indra.co.NearBy_Pro_Backend.common.model.ServiceTag;
import java.util.List;

@Repository
public interface ServiceTagRepository extends MongoRepository<ServiceTag, Long> {
    List<ServiceTag> findByIdIn(List<Long> ids);
} 