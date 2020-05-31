package com.taktika.iera.dto;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class TercategoryDtoReq {

    private String nameDtoReq;
    private Long idSubCategoryDtoReq;       //id TerCategory (foreign key)

    public String getNameDtoReq() {
        return nameDtoReq;
    }

    public void setNameDtoReq(String nameDtoReq) {
        this.nameDtoReq = nameDtoReq;
    }

    public Long getIdSubCategoryDtoReq() {
        return idSubCategoryDtoReq;
    }

    public void setIdSubCategoryDtoReq(Long idSubCategoryDtoReq) {
        this.idSubCategoryDtoReq = idSubCategoryDtoReq;
    }
}
