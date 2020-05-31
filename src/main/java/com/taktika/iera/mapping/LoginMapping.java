package com.taktika.iera.mapping;

import com.taktika.iera.dto.LoginDtoRes;
import com.taktika.iera.model.Login;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

@Service
public class LoginMapping {

    public Login transformOptionalIntoModel(Optional<Login> objLoginOptional) throws Exception {
        Login objLogin = null;
        try {
            if (objLoginOptional.isPresent()) {
                objLogin = new Login();
                objLogin.setId(objLoginOptional.get().getId());
                objLogin.setEmail(objLoginOptional.get().getEmail().toLowerCase());
                objLogin.setPassword(objLoginOptional.get().getPassword());
                objLogin.setStatus(objLoginOptional.get().getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objLogin;
    }

    public LoginDtoRes transformModelIntoDto(Login objLogin) throws Exception {
        LoginDtoRes objLoginDtoRes = null;
        try {
            if (null != objLogin) {
                objLoginDtoRes = new LoginDtoRes();
                objLoginDtoRes.setEmailDtoRes(objLogin.getEmail());
                objLoginDtoRes.setIdDtoRes(objLogin.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objLoginDtoRes;
    }

}
