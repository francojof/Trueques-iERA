package com.taktika.iera.service;

import com.taktika.iera.dto.PostDtoRes;
import com.taktika.iera.dto.PostDtoReq;
import com.taktika.iera.dto.PostsListDto;
import com.taktika.iera.model.Post;
import org.springframework.data.domain.Page;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iPostService {

    PostDtoRes savePost(PostDtoReq objPostDtoReq) throws Exception;
    PostDtoRes updatePost(Long id , PostDtoReq objPostDtoReq) throws Exception;
    Post searchById(Long id) throws Exception;
    boolean deletePost(Long id) throws Exception;
    PostsListDto listAllPost(int page, int size) throws Exception;
    PostsListDto listAllPostByTercategory(Long idTercategory, int page, int size) throws Exception;
    PostsListDto listAllPostByPerson(Long idPerson, int page, int size) throws Exception;
}
