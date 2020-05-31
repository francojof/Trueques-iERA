package com.taktika.iera.mapping;

import com.taktika.iera.dto.*;
import com.taktika.iera.model.*;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TercategoryMapping {

    public Tercategory transformDtoIntoModel(TercategoryDtoReq objTercategoryDto, Subcategory objSubcategory) throws Exception {
        Tercategory objTercategory = null;
        try {
            if (null != objTercategoryDto) {
                objTercategory = new Tercategory();
                objTercategory.setName(objTercategoryDto.getNameDtoReq().toUpperCase());
                objTercategory.setSubcategory(objSubcategory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objTercategory;
    }

    public TercategoryDtoRes transformModelToDto(Tercategory objTercategory) throws Exception {

        TercategoryDtoRes objTercategoryDtoRes = null;
        try {
            if (null != objTercategory) {
                objTercategoryDtoRes = new TercategoryDtoRes();
                objTercategoryDtoRes.setNameDtoRes(objTercategory.getName());
                objTercategoryDtoRes.setSubCategoryDtoRes(objTercategory.getSubcategory().getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objTercategoryDtoRes;
    }


    public Tercategory transformOptionalIntoModel(Optional<Tercategory> objTercategoryOptional) throws Exception {
        Tercategory objTercategory = null;
        try {
            if (objTercategoryOptional.isPresent()) {
                objTercategory = new Tercategory();
                objTercategory.setId(objTercategoryOptional.get().getId());
                objTercategory.setName(objTercategoryOptional.get().getName());
                objTercategory.setSubcategory(objTercategoryOptional.get().getSubcategory());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objTercategory;
    }
}
