package com.indra.co.NearBy_Pro_Backend.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.indra.co.NearBy_Pro_Backend.common.model.Category;
import com.indra.co.NearBy_Pro_Backend.common.repository.CategoryRepository;
import com.indra.co.NearBy_Pro_Backend.common.config.SequenceGenerator;
import com.indra.co.NearBy_Pro_Backend.common.dto.CategoryCreateRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    public Category createCategory(CategoryCreateRequest category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        newCategory.setIconUrl(category.getIconUrl());
        newCategory.setCreatedAt(LocalDateTime.now());
        newCategory.setUpdatedAt(LocalDateTime.now());
        return categoryRepository.save(newCategory);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public Category updateCategory(Category category) {
        if (!categoryRepository.existsById(category.getId())) {
            throw new RuntimeException("Category not found with id: " + category.getId());
        }
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }
} 