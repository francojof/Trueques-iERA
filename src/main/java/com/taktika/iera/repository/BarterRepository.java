package com.taktika.iera.repository;

import com.taktika.iera.model.Barter;
import com.taktika.iera.model.Person;
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
public interface BarterRepository extends JpaRepository<Barter, Long> {
    List<Barter> findAllByStatusAndPost(byte status, Post objPost, Pageable pager);
    List<Barter> findAllByStatusAndPerson(byte status, Person objPerson, Pageable pager);
    @Query(value = "select count(id) from barters where status=1 and id_post = ?1", nativeQuery = true)
    int totalBartersByPost(Long idPost);
    @Query(value = "select count(id) from barters where status=1 and id_person =?1", nativeQuery = true)
    int totalBartersByPerson(Long idPerson);
}

