package com.taktika.iera.repository;

import com.taktika.iera.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Brandon Sepulveda
 * brandonsepux@gmail.com
 */

@Repository
public interface GenderRepository extends JpaRepository<Gender,Long> {
    Gender findByKind(String kindDto);
}
