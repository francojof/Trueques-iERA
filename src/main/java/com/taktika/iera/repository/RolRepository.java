package com.taktika.iera.repository;

import com.taktika.iera.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Brandon Sepulveda
 * brandonsepux@gmail.com
 */

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    Rol findByKind(String Kind);
}
