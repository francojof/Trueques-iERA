package com.taktika.iera.imp;

import com.taktika.iera.dto.BarterStatusDto;
import com.taktika.iera.dto.LoginDtoRes;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.mapping.BarterStatusMapping;
import com.taktika.iera.model.BarterStatus;
import com.taktika.iera.model.Login;
import com.taktika.iera.model.Rol;
import com.taktika.iera.repository.BarterStatusRepository;
import com.taktika.iera.service.iBarterStatusService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */
@Service
public class BarterStatusImp implements iBarterStatusService {

    @Autowired
    BarterStatusRepository objBarterStatusRepository;

    @Autowired
    BarterStatusMapping objBarterStatusMapping;

    @Override
    public BarterStatusDto saveBarterStatus(BarterStatusDto objBarterStatusDto) throws Exception {
        BarterStatus objBarterStatus;
        try {
            objBarterStatus = objBarterStatusRepository.findByName(objBarterStatusDto.getNameDto());
            if (null == objBarterStatus) {
                objBarterStatus = new BarterStatus();
                objBarterStatus.setName(objBarterStatusDto.getNameDto().toUpperCase());
                objBarterStatusDto = objBarterStatusMapping.transformModelToDto(objBarterStatusRepository.save(objBarterStatus));
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
        return objBarterStatusDto;
    }

    @Override
    public BarterStatusDto updateBarterStatus(Long id, BarterStatusDto objBarterStatusDto) throws Exception {

        try {
            BarterStatus objBarterStatus = this.searchById(id);
            if (null != objBarterStatus && null != objBarterStatusDto.getNameDto()){
                objBarterStatus.setName(objBarterStatusDto.getNameDto());
                objBarterStatusDto = objBarterStatusMapping.transformModelToDto(objBarterStatusRepository.save(objBarterStatus));
            }else {
                throw new UpdateException(Constant.UPDATE_ERROR);
            }
        }catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (UpdateException e){
            e.printStackTrace();
            throw new UpdateException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarterStatusDto;
    }

    @Override
    public boolean deleteBarterStatus(Long id) throws Exception {

        try {
            BarterStatus objBarterStatus = objBarterStatusMapping.transformOptionalIntoModel(objBarterStatusRepository.findById(id));
            if (null == objBarterStatus ){
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }else {
                objBarterStatusRepository.deleteById(id);
                return true;
            }
        }catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
    }

    @Override
    public BarterStatus searchById(Long id) throws Exception {
        BarterStatus objBarterStatus;
        try {
            objBarterStatus = objBarterStatusMapping.transformOptionalIntoModel(objBarterStatusRepository.findById(id));
            if (null == objBarterStatus){
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        }catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarterStatus;
    }
}
