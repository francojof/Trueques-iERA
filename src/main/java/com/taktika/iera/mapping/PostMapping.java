package com.taktika.iera.mapping;

import com.taktika.iera.dto.*;
import com.taktika.iera.imp.FileStorageImp;
import com.taktika.iera.imp.PictureImp;
import com.taktika.iera.model.*;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostMapping {

    @Autowired
    PictureImp objPictureImp;

    @Autowired
    FileStorageImp objFileStorageImp;

    public Post transformDtoIntoModel(PostDtoReq objPostDtoReq, Person objPerson, Tercategory objTercategory, Commune objCommune) throws Exception {
        Post objPost = null;
        try {
            if (null != objPostDtoReq) {
                objPost = new Post();
                objPost.setId(objPostDtoReq.getIdDtoReq());
                objPost.setName(objPostDtoReq.getNameDtoReq().toUpperCase());
                objPost.setDescription(objPostDtoReq.getDescriptionDtoReq().toUpperCase());
                objPost.setInterest(objPostDtoReq.getInterestDtoReq().toUpperCase());
                objPost.setPrice(objPostDtoReq.getPriceDtoReq());
                objPost.setCreationDate(objPostDtoReq.getCreationDateDtoReq());
                objPost.setUpdateDate(objPostDtoReq.getUpdateDateDtoReq());
                objPost.setStatus(objPostDtoReq.getStatusDtoReq());
                objPost.setPerson(objPerson);
                objPost.setTercategory(objTercategory);
                objPost.setCommune(objCommune);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPost;
    }

    public PostDtoRes transformModelToDto(Post objPost) throws Exception {
        PostDtoRes objPostDtoRes = null;
        try {
            if (null != objPost) {
                objPostDtoRes = new PostDtoRes();
                objPostDtoRes.setIdDtoRes(objPost.getId());
                objPostDtoRes.setPersonEmailDtoRes(objPost.getPerson().getLogin().getEmail());
                objPostDtoRes.setTerCategoryDtoRes(objPost.getTercategory().getName());
                objPostDtoRes.setCommuneDtoRes(objPost.getCommune().getName());
                objPostDtoRes.setNameDtoRes(objPost.getName());
                objPostDtoRes.setDescriptionDtoRes(objPost.getDescription());
                objPostDtoRes.setPriceDtoRes(objPost.getPrice());
                objPostDtoRes.setInterestDtoRes(objPost.getInterest());
                objPostDtoRes.setCreationDateDtoRes(objPost.getCreationDate());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPostDtoRes;
    }

    public Post transformOptionalIntoModel(Optional<Post> objPostOptional) throws Exception {
        Post objPost = null;
        try {
            if (objPostOptional.isPresent()) {
                objPost = new Post();
                objPost.setPrice(objPostOptional.get().getPrice());
                objPost.setName(objPostOptional.get().getName());
                objPost.setCommune(objPostOptional.get().getCommune());
                objPost.setInterest(objPostOptional.get().getInterest());
                objPost.setCreationDate(objPostOptional.get().getCreationDate());
                objPost.setUpdateDate(objPostOptional.get().getUpdateDate());
                objPost.setStatus(objPostOptional.get().getStatus());
                objPost.setId(objPostOptional.get().getId());
                objPost.setDescription(objPostOptional.get().getDescription());
                objPost.setTercategory(objPostOptional.get().getTercategory());
                objPost.setPerson(objPostOptional.get().getPerson());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPost;
    }

    public PostDtoImg transformModelIntoDtoImg(Post objpost) throws Exception {
        PostDtoImg objPostDtoImg;
        try {
            objPostDtoImg = new PostDtoImg();
            objPostDtoImg.setId(objpost.getId());
            objPostDtoImg.setName(objpost.getName());
            objPostDtoImg.setDescription(objpost.getDescription());
            objPostDtoImg.setPrice(objpost.getPrice());
            objPostDtoImg.setInterest(objpost.getInterest());
            objPostDtoImg.setCreationDate(objpost.getCreationDate());
            objPostDtoImg.setUpdateDate(objpost.getUpdateDate());
            objPostDtoImg.setStatus(objpost.getStatus());
            objPostDtoImg.setPerson(objpost.getPerson());
            objPostDtoImg.setTercategory(objpost.getTercategory());
            objPostDtoImg.setCommune(objpost.getCommune());
            List<String> urlList = objPictureImp.findAllPicturesByPost(objPostDtoImg.getId());
            List<String> imagesList = new ArrayList<String>();
            int count = 0;
            for (String url : urlList) {
                if (count == 0) {
                    objPostDtoImg.setMainImage(objFileStorageImp.loadFileAsImg(url).getImg());
                    count = 1;
                } else {
                    imagesList.add(objFileStorageImp.loadFileAsImg(url).getImg());
                }
            }
            objPostDtoImg.setImages(imagesList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return objPostDtoImg;
    }
}



