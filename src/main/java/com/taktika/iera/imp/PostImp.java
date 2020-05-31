package com.taktika.iera.imp;

import com.taktika.iera.dto.PostDtoReq;
import com.taktika.iera.dto.PostDtoRes;
import com.taktika.iera.dto.PostDtoImg;
import com.taktika.iera.dto.PostsListDto;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.mapping.PostMapping;
import com.taktika.iera.model.*;
import com.taktika.iera.repository.PostRepository;
import com.taktika.iera.service.iPostService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */
@Service
public class PostImp implements iPostService {

    @Autowired
    PostRepository objPostRepository;

    @Autowired
    PostMapping objPostMapping;

    @Autowired
    PersonImp objPersonImp;

    @Autowired
    TercategoryImp objTercategoryImp;

    @Autowired
    CommuneImp objCommuneImp;

    @Override
    public PostDtoRes savePost(PostDtoReq objPostDtoReq) throws Exception {
        PostDtoRes objPostDtoRes;
        Post objPost;
        try {
            if (null != objPostDtoReq) {
                Person objPerson = objPersonImp.searchById(objPostDtoReq.getIdPersonDtoReq());
                Tercategory objTercategory = objTercategoryImp.searchById(objPostDtoReq.getIdTerCategoryDtoReq());
                Commune objCommune = objCommuneImp.searchById(objPostDtoReq.getIdCommuneDtoReq());
                objPostDtoReq.setStatusDtoReq((byte) 1);
                objPostDtoReq.setCreationDateDtoReq(new Date());
                objPostDtoReq.setUpdateDateDtoReq(null);
                objPost = objPostMapping.transformDtoIntoModel(objPostDtoReq, objPerson, objTercategory, objCommune);
                objPostDtoRes = objPostMapping.transformModelToDto(objPostRepository.save(objPost));
            } else {
                throw new SaveException(Constant.SAVE_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (SaveException e) {
            e.printStackTrace();
            throw new SaveException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPostDtoRes;
    }

    @Override
    public PostDtoRes updatePost(Long id, PostDtoReq objPostDtoReq) throws Exception {
        PostDtoRes objPostDtoRes;
        try {
            Post objPost = this.searchById(id);
            if (null != objPost && null != id && null != objPostDtoReq) {
                if (objPost.getCommune().getId() != objPostDtoReq.getIdCommuneDtoReq()) {
                    Commune objCommune = objCommuneImp.searchById(objPostDtoReq.getIdCommuneDtoReq());
                    objPost.setCommune(objCommune);
                }
                if (objPost.getTercategory().getId() != objPostDtoReq.getIdTerCategoryDtoReq()) {
                    Tercategory objTercategory = objTercategoryImp.searchById(objPostDtoReq.getIdTerCategoryDtoReq());
                    objPost.setTercategory(objTercategory);
                }
                objPostDtoReq.setCreationDateDtoReq(objPost.getCreationDate());
                objPostDtoReq.setUpdateDateDtoReq(new Date());
                objPostDtoReq.setIdDtoReq(id);
                objPostDtoReq.setStatusDtoReq((byte) 1);
                objPost = objPostMapping.transformDtoIntoModel(objPostDtoReq, objPost.getPerson(), objPost.getTercategory(), objPost.getCommune());
                objPostDtoRes = objPostMapping.transformModelToDto(objPostRepository.save(objPost));
            } else {
                throw new UpdateException(Constant.UPDATE_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (UpdateException e) {
            e.printStackTrace();
            throw new UpdateException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPostDtoRes;
    }

    @Override
    public Post searchById(Long id) throws Exception {
        Post objPost;
        try {
            objPost = objPostMapping.transformOptionalIntoModel(objPostRepository.findById(id));
            if (null == objPost) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPost;
    }

    @Override
    public boolean deletePost(Long id) throws Exception {
        try {
            Post objPost = objPostMapping.transformOptionalIntoModel(objPostRepository.findById(id));
            if (null == objPost) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            } else {
                objPost.setStatus((byte) 0);
                objPostRepository.save(objPost);
                return true;
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
    }

    @Override
    public PostsListDto listAllPost(int page, int size) throws Exception {
        PostsListDto objPostsListDto;
        try {
            Pageable pager = PageRequest.of(page, size, Sort.by("id").ascending());
            List<Post> postsList = objPostRepository.findAllByStatus((byte)1, pager);
            objPostsListDto = new PostsListDto();
            objPostsListDto.setTotalPosts(objPostRepository.totalPosts());
            List<PostDtoImg> potsImgList = new ArrayList<>();
            for (Post post: postsList){
                potsImgList.add(objPostMapping.transformModelIntoDtoImg(post));
            }
            objPostsListDto.setPostsListDto(potsImgList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return objPostsListDto;
    }

    @Override
    public PostsListDto listAllPostByTercategory(Long idTercategory, int page, int size) throws Exception {
        PostsListDto objPostsListDto;
        try {
            Pageable pager = PageRequest.of(page, size, Sort.by("id").ascending());
            Tercategory objTercategory = objTercategoryImp.searchById(idTercategory);
            List<Post> postsList = objPostRepository.findAllByStatusAndTercategory((byte)1, objTercategory, pager);
            objPostsListDto = new PostsListDto();
            objPostsListDto.setTotalPosts(objPostRepository.totalPostsByTer(idTercategory));
            List<PostDtoImg> potsImgList = new ArrayList<>();
            for (Post post: postsList){
                potsImgList.add(objPostMapping.transformModelIntoDtoImg(post));
            }
            objPostsListDto.setPostsListDto(potsImgList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return objPostsListDto;
    }

    @Override
    public PostsListDto listAllPostByPerson(Long idPerson, int page, int size) throws Exception {
        PostsListDto objPostsListDto;
        try {
            Pageable pager = PageRequest.of(page, size, Sort.by("id").ascending());
            Person objPerson = objPersonImp.searchById(idPerson);
            List<Post> postsList = objPostRepository.findAllByStatusAndPerson((byte)1, objPerson, pager);
            objPostsListDto = new PostsListDto();
            objPostsListDto.setTotalPosts(objPostRepository.totalPostsByPerson(idPerson));
            List<PostDtoImg> potsImgList = new ArrayList<>();
            for (Post post: postsList){
                potsImgList.add(objPostMapping.transformModelIntoDtoImg(post));
            }
            objPostsListDto.setPostsListDto(potsImgList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return objPostsListDto;
    }


}
