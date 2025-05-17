package com.indra.co.NearBy_Pro_Backend.common.model;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionDefinition {
    private String categoryId;
    private List<ProfessionSubCategoryDetails> subCategoryDetails;
    private double costPerHour;
    private boolean isActive = true;
}
