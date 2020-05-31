package com.taktika.iera.imp;

import com.taktika.iera.dto.CommuneDtoReq;
import com.taktika.iera.dto.CommuneDtoRes;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.mapping.CommuneMapping;
import com.taktika.iera.model.Commune;
import com.taktika.iera.model.Country;
import com.taktika.iera.repository.CommuneRepository;
import com.taktika.iera.service.iCommuneService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */
@Service
public class CommuneImp implements iCommuneService {

    @Autowired
    CommuneRepository objCommuneRepository;

    @Autowired
    CommuneMapping objCommuneMapping;

    @Autowired
    CountryImp objCountryImp;

    @Override
    public CommuneDtoRes saveCommune(CommuneDtoReq objCommuneDtoReq) throws Exception {
        CommuneDtoRes objCommuneDtoRes;
        Commune objCommune;
        try {
            objCommune = objCommuneRepository.findByName(objCommuneDtoReq.getNameDtoReq());
            if (null == objCommune) {
                objCommune = new Commune();
                Country objCountry=objCountryImp.searchById(objCommuneDtoReq.getCountryDtoReq());
                objCommune.setName(objCommuneDtoReq.getNameDtoReq());
                objCommune.setPostalCode(objCommuneDtoReq.getPostalCodeDtoReq());
                objCommune.setCountry(objCountry);
                objCommuneDtoRes = objCommuneMapping.transformModelIntoDtoRes(objCommuneRepository.save(objCommune));
            } else {
                throw new SaveException(Constant.SAVE_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (SaveException e) {
            e.printStackTrace();
            throw new SaveException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCommuneDtoRes;
    }

    @Override
    public List<Commune> listCommune() throws Exception {
        List<Commune> communeList;
        try {
            communeList = objCommuneRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return communeList;
    }

    @Override
    public boolean deleteCommune(Long id) throws Exception {
        try {
            Commune objCommune = objCommuneMapping.transformOptionalIntoModel(objCommuneRepository.findById(id));
            if (null == objCommune) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            } else {
                objCommuneRepository.deleteById(id);
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
    public Commune searchById(Long id) throws Exception {
        Commune objCommune;
        try {
            objCommune = objCommuneMapping.transformOptionalIntoModel(objCommuneRepository.findById(id));
            if (null == objCommune) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCommune;
    }
}
