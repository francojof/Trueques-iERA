package com.taktika.iera.service;

import com.taktika.iera.dto.*;
import com.taktika.iera.model.Barter;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iBarterService {

    BarterDtoRes saveBarter(SaveBarterDtoReq objSaveBarterDtoReq) throws Exception;
    BarterDtoRes updateBarter(Long id, BarterDtoReq objBarterDtoReq) throws Exception;
    boolean deleteBarter(Long id) throws Exception;
    Barter searchById(Long id) throws Exception;
    BarterListDto listBartersByPost(Long idMainPost, int page, int size) throws Exception;
    BarterListDto listBartersByPerson(Long idPerson, int page, int size) throws Exception;
}
