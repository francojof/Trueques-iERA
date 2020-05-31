package com.taktika.iera.imp;

import com.taktika.iera.dto.SubcategoryDtoReq;
import com.taktika.iera.dto.SubcategoryDtoRes;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.mapping.SubcategoryMapping;
import com.taktika.iera.model.Category;
import com.taktika.iera.model.Subcategory;
import com.taktika.iera.repository.SubcategoryRepository;
import com.taktika.iera.service.iSubcategoryService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */
@Service
public class SubcategoryImp implements iSubcategoryService {

    @Autowired
    SubcategoryMapping objSubcategoryMapping;

    @Autowired
    SubcategoryRepository objSubcategoryRepository;

    @Autowired
    CategoryImp objCategoryImp;

    @Override
    public SubcategoryDtoRes saveSubcategory(SubcategoryDtoReq objSubcategoryDtoReq) throws Exception {
        SubcategoryDtoRes objSubcategoryDtoRes;
        Subcategory objSubcategory;
        try {
            objSubcategory = objSubcategoryRepository.findByName(objSubcategoryDtoReq.getNameDtoReq());
            if (null == objSubcategory && null != objSubcategoryDtoReq) {
                objSubcategory = new Subcategory();
                Category objCategory = objCategoryImp.searchById(objSubcategoryDtoReq.getIdCategoryDtoReq());
                objSubcategory.setName(objSubcategoryDtoReq.getNameDtoReq());
                objSubcategory.setCategory(objCategory);
                objSubcategoryDtoRes = objSubcategoryMapping.transformModelToDto(objSubcategoryRepository.save(objSubcategory));
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
        return objSubcategoryDtoRes;
    }

    @Override
    public SubcategoryDtoRes updateSubcategory(Long id, SubcategoryDtoReq objSubcategoryDtoReq) throws Exception {
        SubcategoryDtoRes objSubcategoryDtoRes;
        try {
            Subcategory objSubcategory = searchById(id);
            if (null != objSubcategory && null != objSubcategoryDtoReq.getNameDtoReq() && null != objSubcategoryDtoReq.getIdCategoryDtoReq()) {
                objSubcategory.setName(objSubcategoryDtoReq.getNameDtoReq());
                if (objSubcategory.getCategory().getId() != objSubcategoryDtoReq.getIdCategoryDtoReq()) {
                    Category objCategory = objCategoryImp.searchById(objSubcategoryDtoReq.getIdCategoryDtoReq());
                    objSubcategory.setCategory(objCategory);
                }
                objSubcategoryDtoRes = objSubcategoryMapping.transformModelToDto(objSubcategoryRepository.save(objSubcategory));
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
        return objSubcategoryDtoRes;
    }

    @Override
    public List<Subcategory> listSubcategory() throws Exception {
        List<Subcategory> subcategoryList;
        try {
            subcategoryList = objSubcategoryRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return subcategoryList;
    }

    @Override
    public Subcategory searchById(Long id) throws Exception {
        Subcategory objSubcategory;
        try {
            objSubcategory = objSubcategoryMapping.transformOptionalIntoModel(objSubcategoryRepository.findById(id));
            if (null == objSubcategory) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objSubcategory;
    }

    @Override
    public boolean deleteSubcategory(Long id) throws Exception {
        try {
            Subcategory objSubcategory = objSubcategoryMapping.transformOptionalIntoModel(objSubcategoryRepository.findById(id));
            if (null == objSubcategory) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            } else {
                objSubcategoryRepository.deleteById(id);
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
}
