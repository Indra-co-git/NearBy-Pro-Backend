package com.indra.co.NearBy_Pro_Backend.common.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionDefinition {
    @NotBlank(message = "Category ID is required")
    private long categoryId;
    private List<ProfessionSubCategoryDetails> subCategoryDetails;
    @NotBlank(message = "Cost per hour is required")
    private double costPerHour;
    private List<Long> serviceTagIds;
    @NotBlank(message = "Is active is required")
    private boolean isActive = true;

}
