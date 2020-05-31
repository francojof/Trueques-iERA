package com.taktika.iera.repository;

import com.taktika.iera.model.Login;
import com.taktika.iera.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Brandon Sepulveda
 * brandonsepux@gmail.com
 */

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
    Person findByRut(String rut);
    Person findByRutAndStatus(String rut, byte status);
    Person findByUserName(String userName);
    Person findByLogin(Login objLogin);
}
