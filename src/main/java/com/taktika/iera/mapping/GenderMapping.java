package com.taktika.iera.mapping;


import com.taktika.iera.dto.GenderDto;
import com.taktika.iera.model.Gender;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderMapping {

    public Gender transformOptionalIntoModel(Optional<Gender> objGenderOptional) throws Exception {
        Gender objGender = null;
        try {
            if (objGenderOptional.isPresent()) {
                objGender = new Gender();
                objGender.setId(objGenderOptional.get().getId());
                objGender.setKind(objGenderOptional.get().getKind());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objGender;
    }

    public Gender transformDtoIntoModel(GenderDto objGenderDto) throws Exception {
        Gender objGender = null;
        try {
            if (null != objGenderDto) {
                objGender = new Gender();
                objGender.setKind(objGenderDto.getKindDto().toUpperCase());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objGender;
    }

    public GenderDto transformModelIntoDto(Gender objGender) throws Exception {
        GenderDto objGenderDto = null;
        try {
            if (null != objGender) {
                objGenderDto = new GenderDto();
                objGenderDto.setKindDto(objGender.getKind());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objGenderDto;
    }
}
