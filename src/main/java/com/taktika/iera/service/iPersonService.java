package com.taktika.iera.service;

import com.taktika.iera.dto.PersonDtoReq;
import com.taktika.iera.dto.PersonDtoRes;
import com.taktika.iera.dto.UserDtoReq;
import com.taktika.iera.model.Person;
import java.util.List;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iPersonService {

    PersonDtoRes saveUser(UserDtoReq objUserDtoReq) throws Exception;
    PersonDtoRes updatePerson(Long id , PersonDtoReq objPersonDtoReq) throws Exception;
    List<Person> listPerson() throws Exception;
    boolean deletePerson(Long id) throws Exception;
    Person searchById(Long id) throws Exception;
    boolean userNameValidate(String userName)throws Exception;
    PersonDtoRes searchByEmail(String email) throws Exception;
}
