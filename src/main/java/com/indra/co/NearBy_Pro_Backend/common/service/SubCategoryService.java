package com.indra.co.NearBy_Pro_Backend.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indra.co.NearBy_Pro_Backend.common.model.SubCategory;
import com.indra.co.NearBy_Pro_Backend.common.repository.SubCategoryRepository;
import com.indra.co.NearBy_Pro_Backend.common.config.SequenceGenerator;
import java.util.List;
import java.time.LocalDateTime;
        
@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    public SubCategory createSubCategory(SubCategory subCategory) {
        subCategory.setId(sequenceGenerator.generateSequence("subcategory_sequence"));
        subCategory.setCreatedAt(LocalDateTime.now());
        subCategory.setUpdatedAt(LocalDateTime.now());
        return subCategoryRepository.save(subCategory);
    }

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public SubCategory updateSubCategory(SubCategory subCategory) {
        if (!subCategoryRepository.existsById(subCategory.getId())) {
            throw new RuntimeException("SubCategory not found with id: " + subCategory.getId());
        }
        subCategory.setUpdatedAt(LocalDateTime.now());
        return subCategoryRepository.save(subCategory);
    }

    public void deleteSubCategory(Long id) {
        if (!subCategoryRepository.existsById(id)) {
            throw new RuntimeException("SubCategory not found with id: " + id);
        }
        subCategoryRepository.deleteById(id);
    }

    public List<SubCategory> getSubCategoriesByIds(List<Long> ids) {
        return subCategoryRepository.findByIdIn(ids);
    }
    
    
} 