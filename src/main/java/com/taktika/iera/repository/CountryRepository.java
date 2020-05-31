package com.taktika.iera.repository;

import com.taktika.iera.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    Country findByName(String nameDto);
}
