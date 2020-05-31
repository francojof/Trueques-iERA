package com.taktika.iera.service;

import com.taktika.iera.dto.SubcategoryDtoReq;
import com.taktika.iera.dto.SubcategoryDtoRes;
import com.taktika.iera.model.Subcategory;
import java.util.List;

/**
 * José Valenzuela
 * valenzuela.joseg@gmail.com
 */

public interface iSubcategoryService {

    SubcategoryDtoRes saveSubcategory(SubcategoryDtoReq objSubcategoryDtoReq) throws Exception;
    SubcategoryDtoRes updateSubcategory(Long id , SubcategoryDtoReq objSubcategoryDtoReq) throws Exception;
    List<Subcategory> listSubcategory() throws Exception;
    Subcategory searchById(Long id) throws Exception;
    boolean deleteSubcategory(Long id) throws Exception;
}
