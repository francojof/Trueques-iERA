package com.taktika.iera.repository;

import com.taktika.iera.model.Picture;
import com.taktika.iera.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {
    List<Picture> findAllByPost(Post objPost);
}
