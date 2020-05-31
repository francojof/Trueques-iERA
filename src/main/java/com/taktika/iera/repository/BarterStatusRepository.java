package com.taktika.iera.repository;

import com.taktika.iera.model.BarterStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Brandon Sepulveda
 * brandonsepux@gmail.com
 */

@Repository
public interface BarterStatusRepository extends JpaRepository<BarterStatus,Long> {
    BarterStatus findByName(String nameDto);
}
