package com.taktika.iera.service;

import com.taktika.iera.dto.RolDto;
import com.taktika.iera.model.Rol;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iRolService {

    RolDto saveRol(RolDto objRolDto) throws Exception;
    boolean deleteRol(Long id) throws Exception;
    Rol searchById(Long id) throws Exception;
}
