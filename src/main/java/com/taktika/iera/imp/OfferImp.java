package com.taktika.iera.imp;

import com.taktika.iera.dto.OfferDtoReq;
import com.taktika.iera.dto.OfferDtoRes;
import com.taktika.iera.dto.OfferListDto;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.mapping.OfferMapping;
import com.taktika.iera.model.Barter;
import com.taktika.iera.model.Offer;
import com.taktika.iera.model.Post;
import com.taktika.iera.repository.OfferRepository;
import com.taktika.iera.service.iOfferService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */
@Service
public class OfferImp implements iOfferService {

    @Autowired
    OfferRepository objOfferRepository;

    @Autowired
    OfferMapping objOfferMapping;

    @Autowired
    BarterImp objBarterImp;

    @Autowired
    PostImp objPostImp;

    @Override
    public OfferDtoRes saveOffer(OfferDtoReq objOfferDtoReq) throws Exception {
        OfferDtoRes objOfferDtoRes;
        Offer objOffer;
        try {
            Barter objBarter = objBarterImp.searchById(objOfferDtoReq.getIdBarterDtoReq());
            Post objPost = objPostImp.searchById(objOfferDtoReq.getIdPostDtoReq());
            objOffer = objOfferRepository.findByBarterAndPost(objBarter, objPost);
            if (null != objOfferDtoReq && null == objOffer && null != objBarter &&
                    objBarter.getPerson().getId() == objPost.getPerson().getId()) {
                objOfferDtoReq.setCreationDateDtoReq(new Date());
                objOfferDtoReq.setUpdateDateDtoReq(null);
                objOfferDtoReq.setStatusDtoReq((byte) 1);
                objOffer = objOfferMapping.transformDtoIntoModel(objOfferDtoReq, objBarter, objPost);
                objOfferDtoRes = objOfferMapping.transformModelToDto(objOfferRepository.save(objOffer));
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
            throw new Exception(e.getMessage());
        }
        return objOfferDtoRes;
    }

    @Override
    public OfferListDto listOffer(Long idBarter) throws Exception {
        OfferListDto objOfferListDto;
        List<Offer> offerList;
        try {
            Barter objBarter = objBarterImp.searchById(idBarter);
            offerList = objOfferRepository.findAllByBarter(objBarter);
            objOfferListDto = new OfferListDto();
            objOfferListDto.setListOffer(offerList);
            objOfferListDto.setTotalOffers(offerList.size());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objOfferListDto;
    }

    @Override
    public OfferListDto listOffersByBarter(Long idBarter, int page, int size) throws Exception {
        OfferListDto objOfferListDto;
        try {
            Barter objBarter = objBarterImp.searchById(idBarter);
            Pageable pager = PageRequest.of(page, size, Sort.by("id").ascending());
            List<Offer> offerList = objOfferRepository.findAllByStatusAndBarter((byte)1, objBarter, pager);
            objOfferListDto = new OfferListDto();
            objOfferListDto.setTotalOffers(objOfferRepository.totalOffersByBarter(idBarter));
            objOfferListDto.setListOffer(offerList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return objOfferListDto;
    }

    @Override
    public boolean deleteOffer(Long id) throws Exception {
        try {
            Offer objOffer = objOfferMapping.transformOptionalIntoModel(objOfferRepository.findById(id));
            if (null == objOffer) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            } else {
                objOfferRepository.deleteById(id);
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
    public boolean deactivateOffer(Long id) throws Exception {
        try {
            Offer objOffer = objOfferMapping.transformOptionalIntoModel(objOfferRepository.findById(id));
            if (null == objOffer) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            } else {
                objOffer.setStatus((byte) 0);
                objOfferRepository.save(objOffer);
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
    public Offer searchById(Long id) throws Exception {
        Offer objOffer;
        try {
            objOffer = objOfferMapping.transformOptionalIntoModel(objOfferRepository.findById(id));
            if (null == objOffer) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objOffer;
    }

}
