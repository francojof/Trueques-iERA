package com.taktika.iera.service;

import com.taktika.iera.dto.CommuneDtoReq;
import com.taktika.iera.dto.CommuneDtoRes;
import com.taktika.iera.model.Commune;
import java.util.List;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iCommuneService {

    CommuneDtoRes saveCommune(CommuneDtoReq objCommuneDtoReq) throws Exception;
    List<Commune> listCommune() throws Exception;
    boolean deleteCommune(Long id) throws Exception;
    Commune searchById(Long id) throws Exception;
}
