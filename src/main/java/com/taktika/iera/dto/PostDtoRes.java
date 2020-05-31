package com.taktika.iera.dto;

import java.util.Date;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class PostDtoRes {

    private Long idDtoRes;
    private String nameDtoRes;
    private String descriptionDtoRes;
    private double priceDtoRes;
    private String interestDtoRes;
    private String personEmailDtoRes;       //email Login (foreign key)
    private String terCategoryDtoRes;       //name TerCategoty (foreign key)
    private String communeDtoRes;           //name Commune (foreign key)
    private Date creationDateDtoRes;

    public Long getIdDtoRes() {
        return idDtoRes;
    }

    public void setIdDtoRes(Long idDtoRes) {
        this.idDtoRes = idDtoRes;
    }

    public String getNameDtoRes() {
        return nameDtoRes;
    }

    public void setNameDtoRes(String nameDtoRes) {
        this.nameDtoRes = nameDtoRes;
    }

    public String getDescriptionDtoRes() {
        return descriptionDtoRes;
    }

    public void setDescriptionDtoRes(String descriptionDtoRes) {
        this.descriptionDtoRes = descriptionDtoRes;
    }

    public double getPriceDtoRes() {
        return priceDtoRes;
    }

    public void setPriceDtoRes(double priceDtoRes) {
        this.priceDtoRes = priceDtoRes;
    }

    public String getInterestDtoRes() {
        return interestDtoRes;
    }

    public void setInterestDtoRes(String interestDtoRes) {
        this.interestDtoRes = interestDtoRes;
    }

    public String getPersonEmailDtoRes() {
        return personEmailDtoRes;
    }

    public void setPersonEmailDtoRes(String personEmailDtoRes) {
        this.personEmailDtoRes = personEmailDtoRes;
    }

    public String getTerCategoryDtoRes() {
        return terCategoryDtoRes;
    }

    public void setTerCategoryDtoRes(String terCategoryDtoRes) {
        this.terCategoryDtoRes = terCategoryDtoRes;
    }

    public String getCommuneDtoRes() {
        return communeDtoRes;
    }

    public void setCommuneDtoRes(String communeDtoRes) {
        this.communeDtoRes = communeDtoRes;
    }

    public Date getCreationDateDtoRes() {
        return creationDateDtoRes;
    }

    public void setCreationDateDtoRes(Date creationDateDtoRes) {
        this.creationDateDtoRes = creationDateDtoRes;
    }
}
