package com.taktika.iera.imp;

import com.taktika.iera.dto.LoginDtoReq;
import com.taktika.iera.dto.LoginDtoRes;
import com.taktika.iera.dto.PersonDtoRes;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.exception.ValidateSessionException;
import com.taktika.iera.mapping.LoginMapping;
import com.taktika.iera.model.Login;
import com.taktika.iera.model.Person;
import com.taktika.iera.repository.LoginRepository;
import com.taktika.iera.service.iLoginService;
import com.taktika.iera.service.iPbkdf2EncryptService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */
@Service
public class LoginImp implements iLoginService {

    @Autowired
    private LoginRepository objLoginRepository;

    @Autowired
    private LoginMapping objLoginMapping;
    
    @Autowired
    private PersonImp objPersonImp;

    @Autowired
    private iPbkdf2EncryptService iPbkdf2EncryptService;

    @Autowired
    private EmailImp objEmailImp;

    @Override
    public LoginDtoRes saveLogin(String email, String password) throws Exception {
        LoginDtoRes objLoginDtoRes;
        Login objLogin;
        Login objInactiveLogin;
        try {
            objLogin = objLoginRepository.findByEmail(email);
            objInactiveLogin = objLoginRepository.findByEmailAndStatus(email, (byte) 0);
            if (null == objLogin && null == objInactiveLogin) {
                objLogin = new Login();
                objLogin.setEmail(email);
                objLogin.setPassword(iPbkdf2EncryptService.generateHashPassword(password));
                objLogin.setStatus((byte) 1);
                objLoginDtoRes = objLoginMapping.transformModelIntoDto(objLoginRepository.save(objLogin));
                objEmailImp.sendEmail(objLoginDtoRes.getEmailDtoRes());
            } else if (null != objLogin && null != objInactiveLogin) {
                objInactiveLogin.setPassword(iPbkdf2EncryptService.generateHashPassword(password));
                objInactiveLogin.setStatus((byte) 1);
                objLoginDtoRes = objLoginMapping.transformModelIntoDto(objLoginRepository.save(objInactiveLogin));
                objEmailImp.sendEmail(objLoginDtoRes.getEmailDtoRes());
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
        return objLoginDtoRes;
    }

    @Override
    public PersonDtoRes validateLogin(LoginDtoReq objLoginDtoReq) throws Exception {
        Login objLogin;
        PersonDtoRes objPersonDtoRes = null;
        try {
            objLogin = objLoginRepository.findByEmail(objLoginDtoReq.getEmailDtoReq().toLowerCase());
            if (null != objLogin) {
                boolean password = iPbkdf2EncryptService.passwordValidate(objLoginDtoReq.getPasswordDtoReq(), objLogin.getPassword());
                if (password){
                    objPersonDtoRes = objPersonImp.searchByEmail(objLoginDtoReq.getEmailDtoReq());
                }
            } else {
                throw new ValidateSessionException(Constant.SESSION_ERROR);
            }
        } catch (ValidateSessionException e) {
            e.printStackTrace();
            throw new ValidateSessionException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPersonDtoRes;
    }

    @Override
    public boolean deleteLogin(Long id) throws Exception {
        try {
            Login objLogin = objLoginMapping.transformOptionalIntoModel(objLoginRepository.findById(id));
            if (null != objLogin) {
                objLogin.setStatus((byte) 0);
                objLoginRepository.save(objLogin);
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
    public LoginDtoRes updateLogin(Long id, LoginDtoReq objLoginDtoReq) throws Exception {
        LoginDtoRes objLoginDtoRes;
        try {
            Login objLogin = this.searchById(id);
            if (null != objLogin && null != objLoginDtoReq.getEmailDtoReq() && null != objLoginDtoReq.getPasswordDtoReq()) {
                objLogin.setEmail(objLoginDtoReq.getEmailDtoReq());
                objLogin.setPassword(iPbkdf2EncryptService.generateHashPassword(objLoginDtoReq.getPasswordDtoReq()));
                objLoginDtoRes = objLoginMapping.transformModelIntoDto(objLoginRepository.save(objLogin));
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
        return objLoginDtoRes;
    }

    @Override
    public Login searchById(Long id) throws Exception {
        Login objLogin;
        try {
            objLogin = objLoginMapping.transformOptionalIntoModel(objLoginRepository.findById(id));
            if (null == objLogin) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objLogin;
    }
}
