package com.taktika.iera.dto;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class SubcategoryDtoReq {

    private String nameDtoReq;
    private Long idCategoryDtoReq;      //id foreign key

    public String getNameDtoReq() {
        return nameDtoReq;
    }

    public void setNameDtoReq(String nameDtoReq) {
        this.nameDtoReq = nameDtoReq;
    }

    public Long getIdCategoryDtoReq() {
        return idCategoryDtoReq;
    }

    public void setIdCategoryDtoReq(Long idCategoryDtoReq) {
        this.idCategoryDtoReq = idCategoryDtoReq;
    }
}
