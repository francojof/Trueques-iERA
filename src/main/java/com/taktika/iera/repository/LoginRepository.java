package com.taktika.iera.repository;

import com.taktika.iera.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {
    Login findByEmail(String email);
    Login findByEmailAndStatus(String email, byte b);
}
