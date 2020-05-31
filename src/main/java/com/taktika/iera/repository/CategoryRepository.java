package com.taktika.iera.repository;

import com.taktika.iera.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String nameDto);
}
