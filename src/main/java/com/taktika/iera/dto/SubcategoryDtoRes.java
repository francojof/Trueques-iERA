package com.taktika.iera.dto;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class SubcategoryDtoRes {

    private String nameDtoRes;
    private String categoryDtoRes;      //name Category (foreign key)

    public String getNameDtoRes() {
        return nameDtoRes;
    }

    public void setNameDtoRes(String nameDtoRes) {
        this.nameDtoRes = nameDtoRes;
    }

    public String getCategoryDtoRes() {
        return categoryDtoRes;
    }

    public void setCategoryDtoRes(String categoryDtoRes) {
        this.categoryDtoRes = categoryDtoRes;
    }
}
