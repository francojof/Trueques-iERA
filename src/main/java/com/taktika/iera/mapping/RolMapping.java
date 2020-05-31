package com.taktika.iera.mapping;


import com.taktika.iera.dto.RolDto;
import com.taktika.iera.model.Rol;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolMapping {

    public Rol transformOptionalIntoModel(Optional<Rol> objRolOptional) throws Exception {
        Rol objRol = null;
        try {
            if (objRolOptional.isPresent()) {
                objRol = new Rol();
                objRol.setId(objRolOptional.get().getId());
                objRol.setKind(objRolOptional.get().getKind().toUpperCase());
                objRol.setStatus(objRolOptional.get().getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objRol;
    }

    public Rol transformDtoIntoModel(RolDto objRolDto) throws Exception {
        Rol objRol = null;
        try {
            if (null != objRolDto) {
                objRol = new Rol();
                objRol.setStatus((byte) 1);
                objRol.setKind(objRolDto.getKindDto().toUpperCase());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objRol;
    }

    public RolDto transformModelIntoDto(Rol objRol) throws Exception {
        RolDto objRolDto = null;
        try {
            if (null != objRol) {
                objRolDto = new RolDto();
                objRolDto.setKindDto(objRol.getKind());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objRolDto;
    }
}
