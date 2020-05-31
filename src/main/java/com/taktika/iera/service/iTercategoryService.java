package com.taktika.iera.service;

import com.taktika.iera.dto.TercategoryDtoReq;
import com.taktika.iera.dto.TercategoryDtoRes;
import com.taktika.iera.model.Tercategory;
import java.util.List;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iTercategoryService {

    TercategoryDtoRes saveTercategory(TercategoryDtoReq objTercategoryDtoReq) throws Exception;
    TercategoryDtoRes updateTercategory(Long id , TercategoryDtoReq objTercategoryDtoReq) throws Exception;
    Tercategory searchById(Long id) throws Exception;
    List<Tercategory> listTercategory() throws Exception;
    boolean deleteTercategory(Long id) throws Exception;
}
