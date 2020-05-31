package com.taktika.iera.imp;

import com.taktika.iera.dto.*;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.mapping.BarterMapping;
import com.taktika.iera.model.*;
import com.taktika.iera.repository.BarterRepository;
import com.taktika.iera.service.iBarterService;
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
public class BarterImp implements iBarterService {

    @Autowired
    BarterRepository objBarterRepository;

    @Autowired
    BarterMapping objBarterMapping;

    @Autowired
    PersonImp objPersonImp;

    @Autowired
    PostImp objPostImp;

    @Autowired
    OfferImp objOfferImp;

    @Autowired
    BarterStatusImp objBarterStatusImp;

    @Override
    public BarterDtoRes saveBarter(SaveBarterDtoReq objSaveBarterDtoReq) throws Exception {
        BarterDtoRes objBarterDtoRes;
        OfferDtoReq objOfferDtoReq;
        Barter objB;
        Post objFirstToOffer;
        try {
            objFirstToOffer = objPostImp.searchById(objSaveBarterDtoReq.getIdFirstOfferPostDtoReq());
            if (null != objSaveBarterDtoReq && null != objSaveBarterDtoReq.getIdFirstOfferPostDtoReq() &&
                    objFirstToOffer.getPerson().getId() == objSaveBarterDtoReq.getIdPersonDtoReq()) {
                objSaveBarterDtoReq.setExecutionConfirmationDtoReq((byte) 0);
                objSaveBarterDtoReq.setCreationDateDtoReq(new Date());
                objSaveBarterDtoReq.setUpdateDateDtoReq(null);
                objSaveBarterDtoReq.setStatusDtoReq((byte) 1);
                Person objPerson = objPersonImp.searchById(objSaveBarterDtoReq.getIdPersonDtoReq());
                Post objPost = objPostImp.searchById(objSaveBarterDtoReq.getIdPost());
                BarterStatus objBarterStatus = objBarterStatusImp.searchById((long) 1);
                objB = objBarterRepository.save(objBarterMapping.transformSaveDtoIntoModel(objSaveBarterDtoReq, objPerson, objPost, objBarterStatus));
                objBarterDtoRes = objBarterMapping.transformModelToDto(objB);
                objOfferDtoReq = new OfferDtoReq();
                objOfferDtoReq.setIdBarterDtoReq(objBarterDtoRes.getIdDtoRes());
                objOfferDtoReq.setIdPostDtoReq(objSaveBarterDtoReq.getIdFirstOfferPostDtoReq());
                objOfferImp.saveOffer(objOfferDtoReq);
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
        return objBarterDtoRes;
    }

    @Override
    public BarterDtoRes updateBarter(Long id, BarterDtoReq objBarterDtoReq) throws Exception {
        BarterDtoRes objBarterDtoRes;
        Barter objBarter;
        try {
            objBarter = this.searchById(id);
            if (null != id && null != objBarterDtoReq) {
                BarterStatus objBarterStatus = objBarterStatusImp.searchById(objBarterDtoReq.getIdBarterStatusDtoReq());
                objBarter.setBarterStatus(objBarterStatus);
                objBarter.setUpdateDate(new Date());
                objBarter.setStatus((byte) 1);
                objBarter.setSurplusMoney(objBarterDtoReq.getSurplusMoneyDtoReq());
                objBarter.setExecutionConfirmation(objBarterDtoReq.getExecutionConfirmationDtoReq());
                if (objBarterDtoReq.getIdBarterStatusDtoReq().equals((long) 3) && objBarterDtoReq.getExecutionConfirmationDtoReq() == 1) {
                    objBarter.setStatus((byte) 0);
                    OfferListDto objOfferListDto = objOfferImp.listOffer(id);
                    for (Offer object : objOfferListDto.getListOffer()) {
                        objOfferImp.deactivateOffer(object.getId());
                    }
                }
                objBarterDtoRes = objBarterMapping.transformModelToDto(objBarterRepository.save(objBarter));
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
        return objBarterDtoRes;
    }

    @Override
    public boolean deleteBarter(Long id) throws Exception {
        Barter objBarter;
        try {
            objBarter = objBarterMapping.transformOptionalIntoModel(objBarterRepository.findById(id));
            if (null == objBarter) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
            objBarter.setStatus((byte) 0);
            objBarterRepository.save(objBarter);
            return true;
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Barter searchById(Long id) throws Exception {
        Barter objBarter;
        try {
            objBarter = objBarterMapping.transformOptionalIntoModel(objBarterRepository.findById(id));
            if (null == objBarter) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objBarter;
    }

    @Override
    public BarterListDto listBartersByPost(Long idMainPost, int page, int size) throws Exception {
        BarterListDto objBarterListDto;
        try {
            Post objPost = objPostImp.searchById(idMainPost);
            Pageable pager = PageRequest.of(page, size, Sort.by("id").ascending());
            List<Barter> barterList = objBarterRepository.findAllByStatusAndPost((byte)1, objPost, pager);
            objBarterListDto = new BarterListDto();
            objBarterListDto.setTotalBarter(objBarterRepository.totalBartersByPost(idMainPost));
            objBarterListDto.setBarterListDto(barterList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return objBarterListDto;
    }

    @Override
    public BarterListDto listBartersByPerson(Long idPerson, int page, int size) throws Exception {
        BarterListDto objBarterListDto;
        try {
            Person objPerson = objPersonImp.searchById(idPerson);
            Pageable pager = PageRequest.of(page, size, Sort.by("id").ascending());
            List<Barter> barterList = objBarterRepository.findAllByStatusAndPerson((byte)1, objPerson, pager);
            objBarterListDto = new BarterListDto();
            objBarterListDto.setTotalBarter(objBarterRepository.totalBartersByPerson(idPerson));
            objBarterListDto.setBarterListDto(barterList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return objBarterListDto;
    }

}
