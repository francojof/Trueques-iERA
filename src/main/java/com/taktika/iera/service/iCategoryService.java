package com.taktika.iera.service;

import com.taktika.iera.dto.CategoryDto;
import com.taktika.iera.model.Category;
import java.util.List;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iCategoryService {

    CategoryDto saveCategory(CategoryDto objCategoryDto) throws Exception;
    CategoryDto updateCategory(Long id , CategoryDto objCategoryDto) throws Exception;
    List<Category> listCategory()throws Exception;
    Category searchById(Long id) throws Exception;
    boolean deleteCategory(Long id) throws Exception;

}
