package com.indra.co.NearBy_Pro_Backend.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.indra.co.NearBy_Pro_Backend.common.model.SubCategory;
import com.indra.co.NearBy_Pro_Backend.common.service.SubCategoryService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping
    public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategory subCategory) {
        return ResponseEntity.ok(subCategoryService.createSubCategory(subCategory));
    }

    @GetMapping
    public ResponseEntity<List<SubCategory>> getAllSubCategories() {
        return ResponseEntity.ok(subCategoryService.getAllSubCategories());
    }


    @PutMapping("/{id}")
    public ResponseEntity<SubCategory> updateSubCategory(@PathVariable String id, @RequestBody SubCategory subCategory) {
        subCategory.setId(id);
        return ResponseEntity.ok(subCategoryService.updateSubCategory(subCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable String id) {
        subCategoryService.deleteSubCategory(id);
        return ResponseEntity.ok().build();
    }
} 