package com.taktika.iera.service;

import com.taktika.iera.dto.BarterStatusDto;
import com.taktika.iera.model.BarterStatus;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iBarterStatusService {

    BarterStatusDto saveBarterStatus(BarterStatusDto objBarterStatus) throws Exception;
    BarterStatusDto updateBarterStatus(Long id , BarterStatusDto objBarterStatusDto) throws Exception;
    boolean deleteBarterStatus(Long id) throws Exception;
    BarterStatus searchById(Long id) throws Exception;
}
