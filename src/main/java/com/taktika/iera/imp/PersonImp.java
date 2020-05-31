package com.taktika.iera.imp;

import com.taktika.iera.dto.LoginDtoRes;
import com.taktika.iera.dto.PersonDtoReq;
import com.taktika.iera.dto.PersonDtoRes;
import com.taktika.iera.dto.UserDtoReq;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.exception.UserErrorException;
import com.taktika.iera.mapping.PersonMapping;
import com.taktika.iera.model.*;
import com.taktika.iera.repository.LoginRepository;
import com.taktika.iera.repository.PersonRepository;
import com.taktika.iera.service.iPersonService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Brandon Sepulveda and Cristian Gómez
 * brandonsepux@gmail.com
 * cristiang.contacto@gmail.com
 */
@Service
public class PersonImp implements iPersonService {

    @Autowired
    PersonRepository objPersonRepository;

    @Autowired
    PersonMapping objPersonMapping;

    @Autowired
    GenderImp objGenderImp;

    @Autowired
    LoginImp objLoginImp;

    @Autowired
    LoginRepository objLoginRepository;

    @Autowired
    CommuneImp objCommuneImp;

    @Autowired
    RolImp objRolImp;


    @Override
    public PersonDtoRes saveUser(UserDtoReq objUserDtoReq) throws Exception {
        PersonDtoRes objPersonDtoRes;
        Person objPersonRut;
        Person objPersonUserName;
        Person objInactivePerson;
        LoginDtoRes objLoginDtoRes;
        try {
            objPersonUserName = objPersonRepository.findByUserName(objUserDtoReq.getUserNameDtoReq());
            if (null != objPersonUserName) {
                throw new UserErrorException(Constant.USER_ERROR);
            }
            objPersonRut = objPersonRepository.findByRut(objUserDtoReq.getRutDtoReq());
            objInactivePerson = objPersonRepository.findByRutAndStatus(objUserDtoReq.getRutDtoReq(), (byte) 0);
            if (null != objUserDtoReq && null != objInactivePerson) {
                objLoginDtoRes = objLoginImp.saveLogin(objUserDtoReq.getEmailDtoReq(), objUserDtoReq.getPasswordDtoReq());
                Gender objGender = objGenderImp.searchById(objUserDtoReq.getIdGenderDtoReq());
                Rol objRol = objRolImp.searchById((long) 1);
                Commune objCommune = objCommuneImp.searchById(objUserDtoReq.getIdCommuneDtoReq());
                Login objLogin = objLoginImp.searchById(objLoginDtoRes.getIdDtoRes());
                objUserDtoReq.setIdDtoReq(objInactivePerson.getId());
                objUserDtoReq.setStatusDtoReq((byte) 1);
                objUserDtoReq.setReactivationDateDtoReq(new Date());
                objUserDtoReq.setCreationDateDtoReq(objInactivePerson.getUpdateDate());
                objUserDtoReq.setUpdateDateDtoReq(objInactivePerson.getUpdateDate());
                objInactivePerson = objPersonMapping.transformUserDtoIntoModel(objUserDtoReq, objCommune, objLogin, objRol, objGender);
                objPersonDtoRes = objPersonMapping.transformModelToDto(objPersonRepository.save(objInactivePerson));
            } else if (null != objUserDtoReq && null == objPersonRut && null == objPersonUserName) {
                objLoginDtoRes = objLoginImp.saveLogin(objUserDtoReq.getEmailDtoReq(), objUserDtoReq.getPasswordDtoReq());
                Gender objGender = objGenderImp.searchById(objUserDtoReq.getIdGenderDtoReq());
                Rol objRol = objRolImp.searchById((long) 1);
                Commune objCommune = objCommuneImp.searchById(objUserDtoReq.getIdCommuneDtoReq());
                Login objLogin = objLoginImp.searchById(objLoginDtoRes.getIdDtoRes());
                objUserDtoReq.setStatusDtoReq((byte) 1);
                objUserDtoReq.setCreationDateDtoReq(new Date());
                objUserDtoReq.setUpdateDateDtoReq(null);
                objUserDtoReq.setReactivationDateDtoReq(null);
                Person objPerson = objPersonMapping.transformUserDtoIntoModel(objUserDtoReq, objCommune, objLogin, objRol, objGender);
                objPersonDtoRes = objPersonMapping.transformModelToDto(objPersonRepository.save(objPerson));
            } else {
                throw new SaveException(Constant.SAVE_ERROR);
            }
        } catch (UserErrorException e) {
            e.printStackTrace();
            throw new UserErrorException(e.getMessage());
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (SaveException e) {
            e.printStackTrace();
            throw new SaveException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPersonDtoRes;
    }

    @Override
    public PersonDtoRes updatePerson(Long id, PersonDtoReq objPersonDtoReq) throws Exception {
        PersonDtoRes objPersonDtoRes;
        try {
            Person objPerson = searchById(id);
            if (null != objPerson && null != id && null != objPersonDtoReq) {
                if (objPerson.getCommune().getId() != objPersonDtoReq.getIdCommuneDtoReq()) {
                    Commune objCommune = objCommuneImp.searchById(objPersonDtoReq.getIdCommuneDtoReq());
                    objPerson.setCommune(objCommune);
                } else if (objPerson.getGender().getId() != objPersonDtoReq.getIdGenderDtoReq()) {
                    Gender objGender = objGenderImp.searchById(objPersonDtoReq.getIdGenderDtoReq());
                    objPerson.setGender(objGender);
                }
                objPersonDtoReq.setIdDtoReq(null);
                objPersonDtoReq.setCreationDateDtoReq(objPerson.getCreationDate());
                objPersonDtoReq.setBirthdayDtoReq(objPerson.getBirthday());
                objPersonDtoReq.setIdDtoReq(objPerson.getId());
                objPersonDtoReq.setUserNameDtoReq(objPerson.getUserName());
                objPersonDtoReq.setReactivationDateDtoReq(objPerson.getReactivationDate());
                objPersonDtoReq.setRutDtoReq(objPerson.getRut());
                objPersonDtoReq.setStatusDtoReq(objPerson.getStatus());
                objPersonDtoReq.setUpdateDateDtoReq(new Date());
                objPerson = objPersonMapping.transformDtoIntoModel(objPersonDtoReq, objPerson.getCommune(), objPerson.getLogin(), objPerson.getRol(), objPerson.getGender());
                objPersonDtoRes = objPersonMapping.transformModelToDto(objPersonRepository.save(objPerson));
            } else {
                throw new UpdateException(Constant.UPDATE_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (UpdateException e) {
            e.printStackTrace();
            throw new UpdateException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPersonDtoRes;
    }

    @Override
    public List<Person> listPerson() throws Exception {
        List<Person> personList;
        try {
            personList = objPersonRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return personList;
    }

    @Override
    public boolean deletePerson(Long id) throws Exception {
        try {
            Person objPerson = objPersonMapping.transformOptionalIntoModel(objPersonRepository.findById(id));
            if (null != objPerson) {
                objLoginImp.deleteLogin(objPerson.getLogin().getId());
                objPerson.setStatus((byte) 0);
                objPersonRepository.save(objPerson);
                return true;
            } else {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
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
    public Person searchById(Long id) throws Exception {
        Person objPerson;
        try {
            objPerson = objPersonMapping.transformOptionalIntoModel(objPersonRepository.findById(id));
            if (null == objPerson) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPerson;
    }

    @Override
    public boolean userNameValidate(String userName) throws Exception {
        Person objPersonUserName;
        try {
            objPersonUserName = objPersonRepository.findByUserName(userName.toLowerCase());
            if (null != objPersonUserName) {
                throw new UserErrorException(Constant.USER_ERROR);
            }
            return true;
        } catch (UserErrorException e) {
            e.printStackTrace();
            throw new UserErrorException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public PersonDtoRes searchByEmail(String email) throws Exception {
        PersonDtoRes objPersonDtoRes = null;
        Login objLogin;
        try {
            if (null != email) {
                objLogin = objLoginRepository.findByEmail(email);
                if (null != objLogin) {
                    Person objPerson = objPersonRepository.findByLogin(objLogin);
                    objPersonDtoRes = objPersonMapping.transformModelToDto(objPerson);
                }else {
                    throw new NotFoundException(Constant.NOT_FOUND_ERROR);
                }
            }
        } catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return objPersonDtoRes;
    }


}
