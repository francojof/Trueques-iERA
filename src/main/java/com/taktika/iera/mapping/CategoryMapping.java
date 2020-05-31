package com.taktika.iera.mapping;

import com.taktika.iera.dto.*;
import com.taktika.iera.model.Category;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryMapping {


    public Category transformDtoIntoModel(CategoryDto objCategoryDto) throws Exception {
        Category objCategory = null;
        try {
            if (null != objCategoryDto) {
                objCategory = new Category();
                objCategory.setName(objCategoryDto.getNameDto().toUpperCase());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCategory;
    }

    public CategoryDto transformModelToDto(Category objCategory) throws Exception {
        CategoryDto objCategoryDto = null;
        try {
            if (null != objCategory) {
                objCategoryDto = new CategoryDto();
                objCategoryDto.setNameDto(objCategory.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCategoryDto;
    }

    public Category transformOptionalIntoModel(Optional<Category> objCategoryOptional) throws Exception {
        Category objCategory = null;
        try {
            if (objCategoryOptional.isPresent()) {
                objCategory = new Category();
                objCategory.setId(objCategoryOptional.get().getId());
                objCategory.setName(objCategoryOptional.get().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCategory;
    }
}
