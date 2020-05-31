package com.taktika.iera.imp;

import com.taktika.iera.dto.CountryDto;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.mapping.CountryMapping;
import com.taktika.iera.model.Country;
import com.taktika.iera.repository.CountryRepository;
import com.taktika.iera.service.iCountryService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */
@Service
public class CountryImp implements iCountryService {

    @Autowired
    CountryRepository objCountryRepository;

    @Autowired
    CountryMapping objCountryMapping;

    @Override
    public CountryDto saveCountry(CountryDto objCountryDto) throws Exception {
        Country objCountry;
        try {
            objCountry = objCountryRepository.findByName(objCountryDto.getNameDto());
            if (null == objCountry ) {
                objCountry = new Country();
                objCountry.setName(objCountryDto.getNameDto().toUpperCase());
                objCountryDto = objCountryMapping.transformModelIntoDto(objCountryRepository.save(objCountry));
            } else {
                throw new SaveException(Constant.SAVE_ERROR);
            }
        } catch (SaveException e) {
            e.printStackTrace();
            throw new SaveException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCountryDto;
    }

    @Override
    public List<Country> listCountry() throws Exception {
        List<Country> countryList;
        try {
            countryList = objCountryRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return countryList;
    }

    @Override
    public boolean deleteCountry(Long id) throws Exception {
        try {
            Country objCountry = objCountryMapping.transformOptionalIntoModel(objCountryRepository.findById(id));
            if (null == objCountry) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            } else {
                objCountryRepository.deleteById(id);
                return true;
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
    }

    @Override
    public Country searchById(Long id) throws Exception {
        Country objCountry;
        try {
            objCountry = objCountryMapping.transformOptionalIntoModel(objCountryRepository.findById(id));
            if (null == objCountry) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCountry;
    }
}
