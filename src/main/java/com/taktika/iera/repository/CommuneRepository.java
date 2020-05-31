package com.taktika.iera.repository;

import com.taktika.iera.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */

@Repository
public interface CommuneRepository extends JpaRepository<Commune,Long> {
    Commune findByName(String nameDtoReq);
}
