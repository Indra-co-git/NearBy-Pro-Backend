package com.indra.co.NearBy_Pro_Backend.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.indra.co.NearBy_Pro_Backend.common.model.ServiceTag;
import com.indra.co.NearBy_Pro_Backend.common.service.ServiceTagService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/service-tags")
public class ServiceTagController {

    @Autowired
    private ServiceTagService serviceTagService;

    @PostMapping
    public ResponseEntity<ServiceTag> createServiceTag(@RequestBody ServiceTag serviceTag) {
        return ResponseEntity.ok(serviceTagService.createServiceTag(serviceTag));
    }

    @GetMapping
    public ResponseEntity<List<ServiceTag>> getAllServiceTags() {
        return ResponseEntity.ok(serviceTagService.getAllServiceTags());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceTag> getServiceTagById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceTagService.getServiceTagById(id));
    }

    @GetMapping("/subcategory/{subCategoryId}")
    public ResponseEntity<List<ServiceTag>> getServiceTagsBySubCategoryId(@PathVariable Long subCategoryId) {
        return ResponseEntity.ok(serviceTagService.getServiceTagsBySubCategoryId(subCategoryId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceTag> updateServiceTag(@PathVariable Long id, @RequestBody ServiceTag serviceTag) {
        serviceTag.setId(id);
        return ResponseEntity.ok(serviceTagService.updateServiceTag(serviceTag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceTag(@PathVariable Long id) {
        serviceTagService.deleteServiceTag(id);
        return ResponseEntity.ok().build();
    }
} 