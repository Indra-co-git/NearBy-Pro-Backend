package com.indra.co.NearBy_Pro_Backend.common.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionSubCategoryDetails {
    @NotBlank(message = "Sub category ID is required")
    private long subCategoryId;
    @NotBlank(message = "Cost per hour is required")
    private double costPerHour;
}
