package com.taktika.iera.service;

import com.taktika.iera.dto.LoginDtoReq;
import com.taktika.iera.dto.LoginDtoRes;
import com.taktika.iera.dto.PersonDtoRes;
import com.taktika.iera.model.Login;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public interface iLoginService {
    LoginDtoRes saveLogin(String email, String password) throws Exception;
    PersonDtoRes validateLogin(LoginDtoReq objLoginDtoReq) throws Exception;
    boolean deleteLogin(Long id) throws Exception;
    LoginDtoRes updateLogin(Long id, LoginDtoReq objLoginDtoReq) throws Exception;
    Login searchById(Long id) throws Exception;
}
