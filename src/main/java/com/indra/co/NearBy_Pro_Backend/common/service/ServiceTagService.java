package com.indra.co.NearBy_Pro_Backend.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indra.co.NearBy_Pro_Backend.common.model.ServiceTag;
import com.indra.co.NearBy_Pro_Backend.common.repository.ServiceTagRepository;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class ServiceTagService {

    @Autowired
    private ServiceTagRepository serviceTagRepository;

    public ServiceTag createServiceTag(ServiceTag serviceTag) {
        validateServiceTag(serviceTag);
        serviceTag.setCreatedAt(LocalDateTime.now());
        serviceTag.setUpdatedAt(LocalDateTime.now());
        return serviceTagRepository.save(serviceTag);
    }

    public List<ServiceTag> getAllServiceTags() {
        return serviceTagRepository.findAll();
    }

    public ServiceTag getServiceTagById(String id) {
        return serviceTagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceTag not found with id: " + id));
    }

    public List<ServiceTag> getServiceTagsBySubCategoryId(String subCategoryId) {
        return serviceTagRepository.findBySubCategoryId(subCategoryId);
    }

    public ServiceTag updateServiceTag(ServiceTag serviceTag) {
        validateServiceTag(serviceTag);
        if (!serviceTagRepository.existsById(serviceTag.getId().toString())) {
            throw new RuntimeException("ServiceTag not found with id: " + serviceTag.getId());
        }
        serviceTag.setUpdatedAt(LocalDateTime.now());
        return serviceTagRepository.save(serviceTag);
    }

    public void deleteServiceTag(String id) {
        if (!serviceTagRepository.existsById(id)) {
            throw new RuntimeException("ServiceTag not found with id: " + id);
        }
        serviceTagRepository.deleteById(id);
    }

    private void validateServiceTag(ServiceTag serviceTag) {
        if (serviceTag.getName() == null || serviceTag.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Service tag name cannot be empty");
        }
        if (serviceTag.getSubCategoryId() == null) {
            throw new IllegalArgumentException("SubCategory ID cannot be empty");
        }
    }
} 