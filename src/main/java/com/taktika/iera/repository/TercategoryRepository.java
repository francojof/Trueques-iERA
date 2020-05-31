package com.taktika.iera.repository;


import com.taktika.iera.model.Tercategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Brandon Sepulveda
 * brandonsepux@gmail.com
 */

@Repository
public interface TercategoryRepository extends JpaRepository<Tercategory,Long> {
    Tercategory findByName(String nameDtoReq);
}
