package com.taktika.iera.repository;

import com.taktika.iera.model.Person;
import com.taktika.iera.model.Post;
import com.taktika.iera.model.Tercategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Franco Jofré
 * francojof2@gmail.com
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByStatus(byte status, Pageable pager);
    List<Post> findAllByStatusAndTercategory(byte status, Tercategory objTercategory, Pageable pager);
    List<Post> findAllByStatusAndPerson(byte status, Person objPerson, Pageable pager);
    @Query(value = "select count(id) from posts where status=1", nativeQuery = true)
    int totalPosts();
    @Query(value = "select count(id) from posts where status=1 and id_tercategory=?1", nativeQuery = true)
    int totalPostsByTer(Long idTercategory);
    @Query(value = "select count(id) from posts where status=1 and id_person=?1", nativeQuery = true)
    int totalPostsByPerson(Long idPerson);
}
