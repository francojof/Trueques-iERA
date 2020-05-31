package com.taktika.iera.dto;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class TercategoryDtoRes {

    private String nameDtoRes;
    private String subCategoryDtoRes;   //name TerCategory (foreign key)

    public String getNameDtoRes() {
        return nameDtoRes;
    }

    public void setNameDtoRes(String nameDtoRes) {
        this.nameDtoRes = nameDtoRes;
    }

    public String getSubCategoryDtoRes() {
        return subCategoryDtoRes;
    }

    public void setSubCategoryDtoRes(String subCategoryDtoRes) {
        this.subCategoryDtoRes = subCategoryDtoRes;
    }
}
