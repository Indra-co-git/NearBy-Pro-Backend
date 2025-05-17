package com.indra.co.NearBy_Pro_Backend.common.dto;

import java.util.List;
import java.util.Locale.Category;
import com.indra.co.NearBy_Pro_Backend.common.model.ServiceTag;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionDefinitionResponseDto {
    private Category category;
    private List<ProfessionSubCategoryDetailsResponse> professionSubCategoryDetailsResponses;
    private double costPerHour;
    private List<ServiceTag> serviceTags;
    private boolean isActive;
}
