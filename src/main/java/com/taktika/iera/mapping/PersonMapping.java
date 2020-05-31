package com.taktika.iera.mapping;

import com.taktika.iera.dto.PersonDtoReq;
import com.taktika.iera.dto.PersonDtoRes;
import com.taktika.iera.dto.UserDtoReq;
import com.taktika.iera.model.*;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonMapping {

    public Person transformDtoIntoModel(PersonDtoReq objPersonDtoReq, Commune objCommune, Login objLogin, Rol objRol, Gender objGender) throws Exception {
        Person objPerson = null;
        try {
            if (null != objPersonDtoReq) {
                objPerson = new Person();
                objPerson.setId(objPersonDtoReq.getIdDtoReq());
                objPerson.setUserName(objPersonDtoReq.getUserNameDtoReq().toLowerCase());
                objPerson.setName(objPersonDtoReq.getNameDtoReq().toUpperCase());
                objPerson.setSurname(objPersonDtoReq.getSurnameDtoReq().toUpperCase());
                objPerson.setRut(objPersonDtoReq.getRutDtoReq());
                objPerson.setBirthday(objPersonDtoReq.getBirthdayDtoReq());
                objPerson.setStatus(objPersonDtoReq.getStatusDtoReq());
                objPerson.setCreationDate(objPersonDtoReq.getCreationDateDtoReq());
                objPerson.setUpdateDate(objPersonDtoReq.getUpdateDateDtoReq());
                objPerson.setReactivationDate(objPersonDtoReq.getReactivationDateDtoReq());
                objPerson.setPhone(objPersonDtoReq.getPhoneDtoReq());
                objPerson.setGender(objGender);
                objPerson.setCommune(objCommune);
                objPerson.setLogin(objLogin);
                objPerson.setRol(objRol);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPerson;
    }

    public Person transformUserDtoIntoModel(UserDtoReq objUserDtoReq, Commune objCommune, Login objLogin, Rol objRol, Gender objGender) throws Exception {
        Person objPerson = null;
        try {
            if (null != objUserDtoReq) {
                objPerson = new Person();
                objPerson.setId(objUserDtoReq.getIdDtoReq());
                objPerson.setUserName(objUserDtoReq.getUserNameDtoReq().toLowerCase());
                objPerson.setName(objUserDtoReq.getNameDtoReq().toUpperCase());
                objPerson.setSurname(objUserDtoReq.getSurnameDtoReq().toUpperCase());
                objPerson.setRut(objUserDtoReq.getRutDtoReq());
                objPerson.setBirthday(objUserDtoReq.getBirthdayDtoReq());
                objPerson.setStatus(objUserDtoReq.getStatusDtoReq());
                objPerson.setCreationDate(objUserDtoReq.getCreationDateDtoReq());
                objPerson.setUpdateDate(objUserDtoReq.getUpdateDateDtoReq());
                objPerson.setReactivationDate(objUserDtoReq.getReactivationDateDtoReq());
                objPerson.setPhone(objUserDtoReq.getPhoneDtoReq());
                objPerson.setGender(objGender);
                objPerson.setCommune(objCommune);
                objPerson.setLogin(objLogin);
                objPerson.setRol(objRol);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPerson;
    }

    public PersonDtoRes transformModelToDto(Person objPerson) throws Exception {
        PersonDtoRes objPersonDtoRes = null;
        try {
            if (null != objPerson) {
                objPersonDtoRes = new PersonDtoRes();
                objPersonDtoRes.setIdDtoRes(objPerson.getId());
                objPersonDtoRes.setUserNameDtoRes(objPerson.getUserName());
                objPersonDtoRes.setNameDtoRes(objPerson.getName());
                objPersonDtoRes.setSurnameDtoRes(objPerson.getSurname());
                objPersonDtoRes.setRutDtoRes(objPerson.getRut());
                objPersonDtoRes.setPhoneDtoRes(objPerson.getPhone());
                objPersonDtoRes.setCreationDateDtoRes(objPerson.getCreationDate());
                objPersonDtoRes.setCommuneDtoRes(objPerson.getCommune().getName());
                objPersonDtoRes.setEmailDtoRes(objPerson.getLogin().getEmail());
                objPersonDtoRes.setBirthdayDtoRes(objPerson.getBirthday());
                objPersonDtoRes.setGenderDtoRes(objPerson.getGender().getKind());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPersonDtoRes;
    }

    public Person transformOptionalIntoModel(Optional<Person> objPersonOptional) throws Exception {
        Person objPerson = null;
        try {
            if (objPersonOptional.isPresent()) {
                objPerson = new Person();
                objPerson.setId(objPersonOptional.get().getId());
                objPerson.setUserName(objPersonOptional.get().getUserName());
                objPerson.setName(objPersonOptional.get().getName());
                objPerson.setSurname(objPersonOptional.get().getSurname());
                objPerson.setRut(objPersonOptional.get().getRut());
                objPerson.setPhone(objPersonOptional.get().getPhone());
                objPerson.setBirthday(objPersonOptional.get().getBirthday());
                objPerson.setStatus(objPersonOptional.get().getStatus());
                objPerson.setCreationDate(objPersonOptional.get().getCreationDate());
                objPerson.setUpdateDate(objPersonOptional.get().getUpdateDate());
                objPerson.setReactivationDate(objPersonOptional.get().getReactivationDate());
                objPerson.setGender(objPersonOptional.get().getGender());
                objPerson.setCommune(objPersonOptional.get().getCommune());
                objPerson.setLogin(objPersonOptional.get().getLogin());
                objPerson.setRol(objPersonOptional.get().getRol());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPerson;
    }
}
