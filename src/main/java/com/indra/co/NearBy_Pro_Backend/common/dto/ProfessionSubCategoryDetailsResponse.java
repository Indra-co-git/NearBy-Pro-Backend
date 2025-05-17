package com.indra.co.NearBy_Pro_Backend.common.dto;

import com.indra.co.NearBy_Pro_Backend.common.model.SubCategory;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionSubCategoryDetailsResponse {
    private SubCategory subCategory;
    private double costPerHour;
}
