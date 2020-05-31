package com.taktika.iera.mapping;

import com.taktika.iera.dto.SubcategoryDtoReq;
import com.taktika.iera.dto.SubcategoryDtoRes;
import com.taktika.iera.model.Category;
import com.taktika.iera.model.Subcategory;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SubcategoryMapping {


    public Subcategory transformDtoIntoModel(SubcategoryDtoReq objSubCategoryDto, Category objCategory) throws Exception {
        Subcategory objSubcategory = null;
        try {
            if (null != objSubCategoryDto) {
                objSubcategory = new Subcategory();
                objSubcategory.setName(objSubCategoryDto.getNameDtoReq().toUpperCase());
                objSubcategory.setCategory(objCategory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objSubcategory;
    }

    public SubcategoryDtoRes transformModelToDto(Subcategory objSubcategory) throws Exception {
        SubcategoryDtoRes objSubcategoryDtoRes = null;
        try {
            if (null != objSubcategory) {
                objSubcategoryDtoRes = new SubcategoryDtoRes();
                objSubcategoryDtoRes.setNameDtoRes(objSubcategory.getName());
                objSubcategoryDtoRes.setCategoryDtoRes(objSubcategory.getCategory().getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objSubcategoryDtoRes;
    }


    public Subcategory transformOptionalIntoModel(Optional<Subcategory> objSubCategoryOptional) throws Exception {
        Subcategory objSubcategory = null;
        try {
            if (objSubCategoryOptional.isPresent()) {
                objSubcategory = new Subcategory();
                objSubcategory.setId(objSubCategoryOptional.get().getId());
                objSubcategory.setName(objSubCategoryOptional.get().getName());
                objSubcategory.setCategory(objSubCategoryOptional.get().getCategory());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objSubcategory;
    }
}

