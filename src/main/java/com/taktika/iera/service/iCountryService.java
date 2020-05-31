package com.taktika.iera.service;

import com.taktika.iera.dto.CountryDto;
import com.taktika.iera.model.Country;
import java.util.List;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iCountryService {

    CountryDto saveCountry(CountryDto objCountryDto) throws Exception;
    List<Country> listCountry() throws Exception;
    boolean deleteCountry(Long id) throws Exception;
    Country searchById(Long id) throws Exception;
}
