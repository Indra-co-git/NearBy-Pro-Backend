package com.indra.co.NearBy_Pro_Backend.professionalSearchEngine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import com.indra.co.NearBy_Pro_Backend.common.model.Professional;
import com.indra.co.NearBy_Pro_Backend.professionalSearchEngine.dto.ProfessionalSearchRequest;
import com.indra.co.NearBy_Pro_Backend.professionalSearchEngine.dto.ProfessionalSearchRequest.SortBy;
import com.indra.co.NearBy_Pro_Backend.professionalSearchEngine.dto.ProfessionalSearchRequest.SortOrder;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalSearchService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Page<Professional> searchProfessionals(ProfessionalSearchRequest request) {
        Query query = buildSearchQuery(request);
        PageRequest pageRequest = createPageRequest(request);
        
        // Execute query
        List<Professional> professionals = mongoTemplate.find(query, Professional.class);
        long total = mongoTemplate.count(Query.of(query).limit(-1).skip(-1), Professional.class);
        
        return PageableExecutionUtils.getPage(
            professionals,
            pageRequest,
            () -> total
        );
    }

    private Query buildSearchQuery(ProfessionalSearchRequest request) {
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        // Add location criteria
        addLocationCriteria(query, request);
        
        // Add category criteria
        addCategoryCriteria(criteriaList, request);
        
        // Add availability criteria
        addAvailabilityCriteria(criteriaList, request);
        
        // Add search term criteria
        addSearchTermCriteria(criteriaList, request);
        
        // Add all criteria to query
        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        // Add sorting
        addSorting(query, request);

        return query;
    }

    private void addLocationCriteria(Query query, ProfessionalSearchRequest request) {
        if (request.getLocation() != null) {
            double maxDistance = request.getMaxDistance() != null ? request.getMaxDistance() : 5.0;
            query.addCriteria(Criteria.where("currentWorkLocation")
                    .nearSphere(new Point(request.getLocation().getLongitude(), request.getLocation().getLatitude()))
                    .maxDistance(maxDistance * 1000)); // Convert km to meters
        }
    }

    private void addCategoryCriteria(List<Criteria> criteriaList, ProfessionalSearchRequest request) {
        if (request.getCategoryId() != null) {
            criteriaList.add(Criteria.where("categoryId").is(request.getCategoryId()));
        }
        if (request.getSubCategoryId() != null) {
            criteriaList.add(Criteria.where("subCategoryId").is(request.getSubCategoryId()));
        }
        if (request.getServiceTagIds() != null && !request.getServiceTagIds().isEmpty()) {
            criteriaList.add(Criteria.where("serviceTagIds").in(request.getServiceTagIds()));
        }
    }

    private void addAvailabilityCriteria(List<Criteria> criteriaList, ProfessionalSearchRequest request) {
        if (request.getIsAvailable() != null) {
            criteriaList.add(Criteria.where("isAvailable").is(request.getIsAvailable()));
        }
    }

    private void addSearchTermCriteria(List<Criteria> criteriaList, ProfessionalSearchRequest request) {
        if (request.getSearchTerm() != null && !request.getSearchTerm().trim().isEmpty()) {
            criteriaList.add(new Criteria().orOperator(
                Criteria.where("fullName").regex(request.getSearchTerm(), "i"),
                Criteria.where("description").regex(request.getSearchTerm(), "i")
            ));
        }
    }

    private void addSorting(Query query, ProfessionalSearchRequest request) {
        if (request.getSortBy() != null) {
            String sortField = getSortField(request.getSortBy());
            Sort.Direction direction = request.getSortOrder() == SortOrder.DESC ? 
                Sort.Direction.DESC : Sort.Direction.ASC;
            
            // Special handling for distance-based sorting
            if (request.getSortBy() == SortBy.DISTANCE && request.getLocation() != null) {
                // Distance is already considered in the nearSphere query
                // We'll use the natural order of results
            } else {
                query.with(Sort.by(direction, sortField));
            }
        }
    }

    private PageRequest createPageRequest(ProfessionalSearchRequest request) {
        return PageRequest.of(
            request.getPage(),
            request.getSize(),
            Sort.by(Sort.Direction.DESC, "createdAt")
        );
    }

    private String getSortField(SortBy sortBy) {
        switch (sortBy) {
            case RELEVANCE:
                return "relevance";
            case DISTANCE:
                return "distance";
            default:
                return "createdAt";
        }
    }
} 