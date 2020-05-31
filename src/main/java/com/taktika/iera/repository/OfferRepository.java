package com.taktika.iera.repository;

import com.taktika.iera.model.Barter;
import com.taktika.iera.model.Offer;
import com.taktika.iera.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    Offer findByBarterAndPost(Barter objBarter, Post objPost);
    List<Offer> findAllByBarter(Barter objBarter);
    List<Offer> findAllByStatusAndBarter(byte status, Barter objBarter, Pageable pager);
    @Query(value = "select count(id) from offers where status=1 and id_barter = ?1", nativeQuery = true)
    int totalOffersByBarter(Long idBarter);
}
