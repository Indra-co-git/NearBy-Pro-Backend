package com.indra.co.NearBy_Pro_Backend.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indra.co.NearBy_Pro_Backend.common.model.SubCategory;
import com.indra.co.NearBy_Pro_Backend.common.repository.SubCategoryRepository;
import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory createSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public SubCategory updateSubCategory(SubCategory subCategory) {
        if (!subCategoryRepository.existsById(subCategory.getId().toString())) {
            throw new RuntimeException("SubCategory not found with id: " + subCategory.getId());
        }
        return subCategoryRepository.save(subCategory);
    }

    public void deleteSubCategory(String id) {
        if (!subCategoryRepository.existsById(id)) {
            throw new RuntimeException("SubCategory not found with id: " + id);
        }
        subCategoryRepository.deleteById(id);
    }
} 