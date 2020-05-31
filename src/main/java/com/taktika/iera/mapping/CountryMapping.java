package com.taktika.iera.mapping;

import com.taktika.iera.dto.CountryDto;
import com.taktika.iera.model.Country;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryMapping {

    public Country transformOptionalIntoModel(Optional<Country> objCountryOptional) throws Exception {
        Country objCountry = null;
        try {
            if (objCountryOptional.isPresent()) {
                objCountry = new Country();
                objCountry.setId(objCountryOptional.get().getId());
                objCountry.setName(objCountryOptional.get().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCountry;
    }

    public Country transformDtoIntoModel(CountryDto objCountryDto) throws Exception {
        Country objCountry = null;
        try {
            if (null != objCountryDto) {
                objCountry = new Country();
                objCountry.setName(objCountryDto.getNameDto().toUpperCase());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCountry;
    }

    public CountryDto transformModelIntoDto(Country objCountry) throws Exception {
        CountryDto objCountryDto = null;
        try {
            if (null != objCountry) {
                objCountryDto = new CountryDto();
                objCountryDto.setNameDto(objCountry.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCountryDto;
    }
}
