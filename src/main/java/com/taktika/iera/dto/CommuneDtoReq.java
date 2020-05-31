package com.taktika.iera.dto;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class CommuneDtoReq {

    private String nameDtoReq;
    private int postalCodeDtoReq;
    private Long countryDtoReq;     //id foreign key

    public String getNameDtoReq() {
        return nameDtoReq;
    }

    public void setNameDtoReq(String nameDtoReq) {
        this.nameDtoReq = nameDtoReq;
    }

    public int getPostalCodeDtoReq() {
        return postalCodeDtoReq;
    }

    public void setPostalCodeDtoReq(int postalCodeDtoReq) {
        this.postalCodeDtoReq = postalCodeDtoReq;
    }

    public Long getCountryDtoReq() {
        return countryDtoReq;
    }

    public void setCountryDtoReq(Long countryDtoReq) {
        this.countryDtoReq = countryDtoReq;
    }
}
