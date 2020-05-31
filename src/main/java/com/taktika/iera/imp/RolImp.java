package com.taktika.iera.imp;

import com.taktika.iera.dto.RolDto;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.mapping.RolMapping;
import com.taktika.iera.model.Rol;
import com.taktika.iera.repository.RolRepository;
import com.taktika.iera.service.iRolService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Brandon Sepulveda
 * brandonsepux@gmail.com
 */
@Service
public class RolImp implements iRolService {

    @Autowired
    RolRepository objRolRepository;

    @Autowired
    RolMapping objRolMapping;


    @Override
    public RolDto saveRol(RolDto objRolDto) throws Exception {
        Rol objRol;
        try {
            objRol = objRolRepository.findByKind(objRolDto.getKindDto());
            if (null == objRol) {
                objRol = new Rol();
                objRol.setKind(objRolDto.getKindDto());
                objRol.setStatus((byte) 1);
                objRolDto = objRolMapping.transformModelIntoDto(objRolRepository.save(objRol));
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
        return objRolDto;
    }

    @Override
    public boolean deleteRol(Long id) throws Exception {
        try {
            Rol objRol = objRolMapping.transformOptionalIntoModel(objRolRepository.findById(id));
            if (null == objRol) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            } else {
                objRolRepository.deleteById(id);
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
    public Rol searchById(Long id) throws Exception {
        Rol objRol;
        try {
            objRol = objRolMapping.transformOptionalIntoModel(objRolRepository.findById(id));
            if (null == objRol) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objRol;
    }
}
