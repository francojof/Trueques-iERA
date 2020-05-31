package com.taktika.iera.repository;

import com.taktika.iera.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory,Long> {
    Subcategory findByName(String nameDtoReq);
}
