package com.taktika.iera.mapping;

import com.taktika.iera.dto.CommuneDtoReq;
import com.taktika.iera.dto.CommuneDtoRes;
import com.taktika.iera.model.Commune;
import com.taktika.iera.model.Country;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommuneMapping {

    public Commune transformDtoIntoModel(CommuneDtoReq commune, Country objCountry) throws Exception {
        Commune objCommune = null;
        try {
            objCommune = new Commune();
            objCommune.setName(commune.getNameDtoReq().toUpperCase());
            objCommune.setPostalCode(commune.getPostalCodeDtoReq());
            objCommune.setCountry(objCountry);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCommune;
    }

    public CommuneDtoRes transformModelIntoDtoRes(Commune objCommune) throws Exception {
        CommuneDtoRes objCommuneDtoRes = null;
        try {
            objCommuneDtoRes = new CommuneDtoRes();
            objCommuneDtoRes.setNameDtoRes(objCommune.getName());
            objCommuneDtoRes.setCountryDtoRes(objCommune.getCountry().getName());
            objCommuneDtoRes.setPostalCodeDtoRes(objCommune.getPostalCode());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCommuneDtoRes;
    }

    public Commune transformOptionalIntoModel(Optional<Commune> objCommuneOptional) throws Exception {
        Commune objCommune = null;
        try {
            if (objCommuneOptional.isPresent()) {
                objCommune = new Commune();
                objCommune.setId(objCommuneOptional.get().getId());
                objCommune.setName(objCommuneOptional.get().getName());
                objCommune.setPostalCode(objCommuneOptional.get().getPostalCode());
                objCommune.setCountry(objCommuneOptional.get().getCountry());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCommune;
    }
}
