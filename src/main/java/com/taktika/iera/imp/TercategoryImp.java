package com.taktika.iera.imp;

import com.taktika.iera.dto.TercategoryDtoReq;
import com.taktika.iera.dto.TercategoryDtoRes;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.mapping.TercategoryMapping;
import com.taktika.iera.model.Subcategory;
import com.taktika.iera.model.Tercategory;
import com.taktika.iera.repository.TercategoryRepository;
import com.taktika.iera.service.iTercategoryService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */
@Service
public class TercategoryImp implements iTercategoryService {

    @Autowired
    TercategoryRepository objTercategoryRepository;

    @Autowired
    TercategoryMapping objTercategoryMapping;

    @Autowired
    SubcategoryImp objSubcategoryImp;

    @Override
    public TercategoryDtoRes saveTercategory(TercategoryDtoReq objTercategoryDtoReq) throws Exception {
        TercategoryDtoRes objTercategoryDtoRes;
        Tercategory objTercategory;
        try {
            objTercategory = objTercategoryRepository.findByName(objTercategoryDtoReq.getNameDtoReq());
            if (null == objTercategory && null != objTercategoryDtoReq) {
                objTercategory = new Tercategory();
                Subcategory objSubcategory = objSubcategoryImp.searchById(objTercategoryDtoReq.getIdSubCategoryDtoReq());
                objTercategory.setName(objTercategoryDtoReq.getNameDtoReq().toUpperCase());
                objTercategory.setSubcategory(objSubcategory);
                objTercategoryDtoRes = objTercategoryMapping.transformModelToDto(objTercategoryRepository.save(objTercategory));
            } else {
                throw new SaveException(Constant.SAVE_ERROR);
            }
        } catch (SaveException e) {
            e.printStackTrace();
            throw new SaveException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objTercategoryDtoRes;
    }

    @Override
    public TercategoryDtoRes updateTercategory(Long id, TercategoryDtoReq objTercategoryDtoReq) throws Exception {
        TercategoryDtoRes objTercategoryDtoRes;
        try {
            Tercategory objTercategory = searchById(id);
            if (null != objTercategory && null != objTercategoryDtoReq.getNameDtoReq() && null != objTercategoryDtoReq.getIdSubCategoryDtoReq()){
                objTercategory.setName(objTercategoryDtoReq.getNameDtoReq().toUpperCase());
                if (objTercategory.getSubcategory().getId() != objTercategoryDtoReq.getIdSubCategoryDtoReq()){
                    Subcategory objSubcategory = objSubcategoryImp.searchById(objTercategoryDtoReq.getIdSubCategoryDtoReq());
                    objTercategory.setSubcategory(objSubcategory);
                }
                objTercategoryDtoRes = objTercategoryMapping.transformModelToDto(objTercategoryRepository.save(objTercategory));
            }else {
                throw new UpdateException(Constant.UPDATE_ERROR);
            }
        }catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (UpdateException e){
            e.printStackTrace();
            throw new UpdateException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objTercategoryDtoRes;
    }

    @Override
    public Tercategory searchById(Long id) throws Exception {
        Tercategory objTercategory;
        try {
            objTercategory = objTercategoryMapping.transformOptionalIntoModel(objTercategoryRepository.findById(id));
            if (null == objTercategory){
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        }catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objTercategory;
    }

    @Override
    public List<Tercategory> listTercategory() throws Exception {
        List<Tercategory> tercategoryList;
        try {
            tercategoryList = objTercategoryRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return tercategoryList;

    }

    @Override
    public boolean deleteTercategory(Long id) throws Exception {
        try {
            Tercategory objTercategory = objTercategoryMapping.transformOptionalIntoModel(objTercategoryRepository.findById(id));
            if (null == objTercategory){
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }else {
                objTercategoryRepository.deleteById(id);
                return true;
            }
        }catch (NotFoundException e){
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
    }
}
