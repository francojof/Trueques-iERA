package com.taktika.iera.mapping;

import com.taktika.iera.dto.*;
import com.taktika.iera.model.*;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BarterStatusMapping {


    public BarterStatus transformDtoIntoModel(BarterStatusDto objBarterStatusDto) throws Exception {
        BarterStatus objBarterStatus = null;
        try {
            if (null != objBarterStatusDto) {
                objBarterStatus = new BarterStatus();
                objBarterStatus.setName(objBarterStatusDto.getNameDto().toUpperCase());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarterStatus;
    }

    public BarterStatusDto transformModelToDto(BarterStatus objBarterStatus) throws Exception {

        BarterStatusDto objBarterStatusDto = null;
        try {
            if (null != objBarterStatus) {
                objBarterStatusDto = new BarterStatusDto();
                objBarterStatusDto.setNameDto(objBarterStatus.getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarterStatusDto;
    }

    public BarterStatus transformOptionalIntoModel(Optional<BarterStatus> objBarterStatusOptional) throws Exception {
        BarterStatus objBarterStatus = null;
        try {
            if (objBarterStatusOptional.isPresent()) {
                objBarterStatus = new BarterStatus();
                objBarterStatus.setId(objBarterStatusOptional.get().getId());
                objBarterStatus.setName(objBarterStatusOptional.get().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarterStatus;
    }
}
