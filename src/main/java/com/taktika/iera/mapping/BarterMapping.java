package com.taktika.iera.mapping;

import com.taktika.iera.dto.BarterDtoReq;
import com.taktika.iera.dto.BarterDtoRes;
import com.taktika.iera.dto.SaveBarterDtoReq;
import com.taktika.iera.model.Barter;
import com.taktika.iera.model.BarterStatus;
import com.taktika.iera.model.Person;
import com.taktika.iera.model.Post;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BarterMapping {


    public Barter transformDtoIntoModel(BarterDtoReq objBarterDto, Person objPerson, Post objPost, BarterStatus objBarterStatus) throws Exception {
        Barter objBarter = null;
        try {
            if (null != objBarterDto) {
                objBarter = new Barter();
                objBarter.setSurplusMoney(objBarterDto.getSurplusMoneyDtoReq());
                objBarter.setExecutionConfirmation(objBarterDto.getExecutionConfirmationDtoReq());
                objBarter.setCreationDate(objBarterDto.getCreationDateDtoReq());
                objBarter.setUpdateDate(objBarterDto.getUpdateDateDtoReq());
                objBarter.setStatus(objBarterDto.getStatusDtoReq());
                objBarter.setPerson(objPerson);
                objBarter.setBarterStatus(objBarterStatus);
                objBarter.setPost(objPost);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarter;
    }

    public Barter transformSaveDtoIntoModel(SaveBarterDtoReq objSaveBarterDto, Person objPerson, Post objPost, BarterStatus objBarterStatus) throws Exception {
        Barter objBarter = null;
        try {
            if (null != objSaveBarterDto) {
                objBarter = new Barter();
                objBarter.setSurplusMoney(objSaveBarterDto.getSurplusMoneyDtoReq());
                objBarter.setExecutionConfirmation(objSaveBarterDto.getExecutionConfirmationDtoReq());
                objBarter.setCreationDate(objSaveBarterDto.getCreationDateDtoReq());
                objBarter.setUpdateDate(objSaveBarterDto.getUpdateDateDtoReq());
                objBarter.setStatus(objSaveBarterDto.getStatusDtoReq());
                objBarter.setPerson(objPerson);
                objBarter.setBarterStatus(objBarterStatus);
                objBarter.setPost(objPost);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarter;
    }

    public BarterDtoRes transformModelToDto(Barter objBarter) throws Exception {
        BarterDtoRes objBarterDtoRes = null;
        try {
            if (null != objBarter) {
                objBarterDtoRes = new BarterDtoRes();
                objBarterDtoRes.setIdDtoRes(objBarter.getId());
                objBarterDtoRes.setUpdateDateDtoRes(objBarter.getUpdateDate());
                objBarterDtoRes.setBarterStatusDtoRes(objBarter.getBarterStatus().getName());
                objBarterDtoRes.setCreationDateDtoRes(objBarter.getCreationDate());
                objBarterDtoRes.setExecutionConfirmationDtoRes(objBarter.getExecutionConfirmation());
                objBarterDtoRes.setSurplusMoneyDtoRes(objBarter.getSurplusMoney());
                objBarterDtoRes.setStatusDtoRes(objBarter.getStatus());
                objBarterDtoRes.setUserNamePersonDtoRes(objBarter.getPerson().getUserName());
                objBarterDtoRes.setNamePersonDtoRes(objBarter.getPerson().getName());
                objBarterDtoRes.setPostNameDtoRes(objBarter.getPost().getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarterDtoRes;
    }

    public Barter transformOptionalIntoModel(Optional<Barter> objBarterOptional) throws Exception {
        Barter objBarter = null;
        try {
            if (objBarterOptional.isPresent()) {
                objBarter = new Barter();
                objBarter.setId(objBarterOptional.get().getId());
                objBarter.setSurplusMoney(objBarterOptional.get().getSurplusMoney());
                objBarter.setExecutionConfirmation(objBarterOptional.get().getExecutionConfirmation());
                objBarter.setCreationDate(objBarterOptional.get().getCreationDate());
                objBarter.setUpdateDate(objBarterOptional.get().getUpdateDate());
                objBarter.setStatus(objBarterOptional.get().getStatus());
                objBarter.setPerson(objBarterOptional.get().getPerson());
                objBarter.setPost(objBarterOptional.get().getPost());
                objBarter.setBarterStatus(objBarterOptional.get().getBarterStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarter;
    }
}
