package com.indra.co.NearBy_Pro_Backend.common.dto;

import lombok.Builder;
import lombok.Data;
import com.indra.co.NearBy_Pro_Backend.common.model.SubCategory;
import com.indra.co.NearBy_Pro_Backend.common.model.ServiceTag;
import java.util.List;

@Data
@Builder
public class CategoryDetailsResponseDto {
    private Long id;
    private String name;
    private String description;
    private String iconUrl;
    private boolean isActive;
    private List<SubCategory> subCategories;
    private List<ServiceTag> allowedServiceTags;
}
