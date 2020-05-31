package com.taktika.iera.imp;

import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.model.Picture;
import com.taktika.iera.model.Post;
import com.taktika.iera.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */
@Service
public class PictureImp {

    @Autowired
    private PostImp objPostImp;

    @Autowired
    private PictureRepository objPictureRepository;

    public boolean savePictureData(Long idPost, String pictureUrl) throws Exception {
        boolean res = false;
        Picture objPicture;
        try {
            if (null != idPost && null != pictureUrl) {
                Post objPost = objPostImp.searchById(idPost);
                if (null != objPost) {
                    objPicture = new Picture();
                    objPicture.setPost(objPost);
                    objPicture.setPictureUrl(pictureUrl);
                    objPictureRepository.save(objPicture);
                    res = true;
                }
            } else {
                res = false;
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return res;
    }

    public List findAllPicturesByPost(Long idPost) throws Exception {
        List<Picture> pictureList = null;
        Post objPost;
        List urlList = null;
        try {
            if (null != idPost) {
                objPost = objPostImp.searchById(idPost);
                pictureList = objPictureRepository.findAllByPost(objPost);
                urlList = new ArrayList();
                for (Picture object : pictureList) {
                    urlList.add(object.getPictureUrl());
                }
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return urlList;
    }

}
