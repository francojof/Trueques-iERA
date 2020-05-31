package com.taktika.iera.service;

import com.taktika.iera.dto.OfferDtoReq;
import com.taktika.iera.dto.OfferDtoRes;
import com.taktika.iera.dto.OfferListDto;
import com.taktika.iera.model.Offer;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iOfferService {
    OfferDtoRes saveOffer(OfferDtoReq objOfferDtoReq) throws Exception;
    OfferListDto listOffer(Long idBarter) throws Exception;
    OfferListDto listOffersByBarter(Long idBarter, int page, int size) throws Exception;
    boolean deleteOffer(Long id) throws Exception;
    boolean deactivateOffer(Long id) throws Exception;
    Offer searchById(Long id) throws Exception;
}
