package com.taktika.iera.dto;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class CommuneDtoRes {

    private String nameDtoRes;
    private int postalCodeDtoRes;
    private String countryDtoRes;   //name Country (foreign key)

    public String getNameDtoRes() {
        return nameDtoRes;
    }

    public void setNameDtoRes(String nameDtoRes) {
        this.nameDtoRes = nameDtoRes;
    }

    public int getPostalCodeDtoRes() {
        return postalCodeDtoRes;
    }

    public void setPostalCodeDtoRes(int postalCodeDtoRes) {
        this.postalCodeDtoRes = postalCodeDtoRes;
    }

    public String getCountryDtoRes() {
        return countryDtoRes;
    }

    public void setCountryDtoRes(String countryDtoRes) {
        this.countryDtoRes = countryDtoRes;
    }
}
