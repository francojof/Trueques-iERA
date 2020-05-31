package com.taktika.iera.mapping;

import com.taktika.iera.dto.OfferDtoReq;
import com.taktika.iera.dto.OfferDtoRes;
import com.taktika.iera.model.Barter;
import com.taktika.iera.model.Offer;
import com.taktika.iera.model.Post;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferMapping {

    public Offer transformDtoIntoModel(OfferDtoReq objOfferDtoReq, Barter objBarter, Post objPost) throws Exception {
        Offer objOffer = null;
        try {
            if (null != objOfferDtoReq) {
                objOffer = new Offer();
                objOffer.setCreationDate(objOfferDtoReq.getCreationDateDtoReq());
                objOffer.setUpdateDate(objOfferDtoReq.getUpdateDateDtoReq());
                objOffer.setStatus(objOfferDtoReq.getStatusDtoReq());
                objOffer.setPost(objPost);
                objOffer.setBarter(objBarter);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objOffer;
    }

    public OfferDtoRes transformModelToDto(Offer objOffer) throws Exception {
        OfferDtoRes objOfferDtoRes = null;
        try {
            if (null != objOffer) {
                objOfferDtoRes = new OfferDtoRes();
                objOfferDtoRes.setIdDtoRes(objOffer.getId());
                objOfferDtoRes.setCreationDateDtoRes(objOffer.getCreationDate());
                objOfferDtoRes.setUpdateDateDtoRes(objOffer.getUpdateDate());
                objOfferDtoRes.setStatusDtoRes(objOffer.getStatus());
                objOfferDtoRes.setPostNameDtoRes(objOffer.getPost().getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objOfferDtoRes;
    }

    public Offer transformOptionalIntoModel(Optional<Offer> objOfferOptional) throws Exception {
        Offer objOffer = null;
        try {
            if (objOfferOptional.isPresent()) {
                objOffer = new Offer();
                objOffer.setId(objOfferOptional.get().getId());
                objOffer.setUpdateDate(objOfferOptional.get().getUpdateDate());
                objOffer.setStatus(objOfferOptional.get().getStatus());
                objOffer.setCreationDate(objOfferOptional.get().getCreationDate());
                objOffer.setPost(objOfferOptional.get().getPost());
                objOffer.setBarter(objOfferOptional.get().getBarter());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objOffer;
    }
}
