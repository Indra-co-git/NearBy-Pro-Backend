package com.indra.co.NearBy_Pro_Backend.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.co.NearBy_Pro_Backend.common.dto.ProfessionDefinitionResponseDto;
import com.indra.co.NearBy_Pro_Backend.common.model.ProfessionDefinition;
import com.indra.co.NearBy_Pro_Backend.common.model.Category;
import com.indra.co.NearBy_Pro_Backend.common.model.SubCategory;
import com.indra.co.NearBy_Pro_Backend.common.model.ServiceTag;
import com.indra.co.NearBy_Pro_Backend.common.model.ProfessionSubCategoryDetails;
import java.util.List;
import java.util.stream.Collectors;
import com.indra.co.NearBy_Pro_Backend.common.dto.ProfessionSubCategoryDetailsResponse;
import java.util.ArrayList;
@Service
public class ProfessionDefinitionService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private ServiceTagService serviceTagService;

    public List<ProfessionDefinitionResponseDto> getProfessionDefinitions(List<ProfessionDefinition> professionDefinitions) {
            // List<ProfessionDefinitionResponseDto> professionDefinitionResponseDtos = professionDefinitions.stream()
            // .map(professionDefinition -> {
            //     Category category = categoryService.getCategoryById(professionDefinition.getCategoryId());
            //     List<ProfessionSubCategoryDetails> subCategoryDetails = professionDefinition.getSubCategoryDetails();
            //     List<Long> subCategoryIds = subCategoryDetails.stream()
            //             .map(ProfessionSubCategoryDetails::getSubCategoryId)
            //             .collect(Collectors.toList()); 
            //     List<Long> serviceTagIds = professionDefinition.getServiceTagIds();
            //     List<ServiceTag> serviceTags = serviceTagService.getServiceTagsByIds(serviceTagIds);
            //     List<SubCategory> subCategories = subCategoryService.getSubCategoriesByIds(subCategoryIds);
            //     ProfessionSubCategoryDetailsResponse professionSubCategoryDetailsResponse = ProfessionSubCategoryDetailsResponse.builder()
            //             .subCategory(subCategories.get(0))
            //             .costPerHour(professionDefinition.getSubCategoryDetails().get(0).getCostPerHour())
            //             .build();
                
            // })
            // .collect(Collectors.toList());

            return new ArrayList<>();
    }
    
    
}
