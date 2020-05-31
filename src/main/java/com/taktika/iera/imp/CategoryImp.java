package com.taktika.iera.imp;

import com.taktika.iera.dto.CategoryDto;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.mapping.CategoryMapping;
import com.taktika.iera.model.Category;
import com.taktika.iera.repository.CategoryRepository;
import com.taktika.iera.service.iCategoryService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Franco Jofré
 * francojof2@gmail.com
 */
@Service
public class CategoryImp implements iCategoryService {

    @Autowired
    CategoryRepository objCategoryRepository;

    @Autowired
    CategoryMapping objCategoryMapping;

    @Override
    public CategoryDto saveCategory(CategoryDto objCategoryDto) throws Exception {
        CategoryDto objCategoryDtoRes;
        Category objCategory;

        try {
            objCategory = objCategoryRepository.findByName(objCategoryDto.getNameDto());
            if (null == objCategory) {
                objCategory = new Category();
                objCategory.setName(objCategoryDto.getNameDto().toUpperCase());
                objCategoryDtoRes = objCategoryMapping.transformModelToDto(objCategoryRepository.save(objCategory));
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
        return objCategoryDtoRes;
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto objCategoryDto) throws Exception {
        CategoryDto objCategoryDtoRes = null;
        try {
            Category objCategory = this.searchById(id);
            if (null != objCategory && null != objCategoryDto.getNameDto()) {
                objCategory.setName(objCategoryDto.getNameDto());
                objCategoryDtoRes = objCategoryMapping.transformModelToDto(objCategoryRepository.save(objCategory));
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
        return objCategoryDtoRes;
    }

    @Override
    public List<Category> listCategory() throws Exception {
        List<Category> CategoryList;
        try {
            CategoryList = objCategoryRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return CategoryList;
    }

    @Override
    public Category searchById(Long id) throws Exception {
        Category objCategory;
        try {
            objCategory = objCategoryMapping.transformOptionalIntoModel(objCategoryRepository.findById(id));
            if (null == objCategory) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objCategory;
    }

    @Override
    public boolean deleteCategory(Long id) throws Exception {
        try {
            Category objCategory = objCategoryMapping.transformOptionalIntoModel(objCategoryRepository.findById(id));
            if (null == objCategory) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            } else {
                objCategoryRepository.deleteById(id);
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
