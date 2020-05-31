package com.taktika.iera.service;

import com.taktika.iera.dto.GenderDto;
import com.taktika.iera.model.Gender;
import java.util.List;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iGenderService {
    GenderDto saveGender(GenderDto objGenderDto) throws Exception;
    boolean deleteGender(Long id) throws Exception;
    Gender searchById(Long id) throws Exception;
    List<Gender> listGender() throws Exception;
}
