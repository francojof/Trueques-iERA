package com.taktika.iera.dto;

import java.util.Date;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class OfferDtoRes {

    private Long idDtoRes;
    private Date creationDateDtoRes;
    private Date updateDateDtoRes;
    private byte statusDtoRes;
    private String postNameDtoRes;      //name Post (foreign key)

    public Long getIdDtoRes() {
        return idDtoRes;
    }

    public void setIdDtoRes(Long idDtoRes) {
        this.idDtoRes = idDtoRes;
    }

    public Date getCreationDateDtoRes() {
        return creationDateDtoRes;
    }

    public void setCreationDateDtoRes(Date creationDateDtoRes) {
        this.creationDateDtoRes = creationDateDtoRes;
    }

    public Date getUpdateDateDtoRes() {
        return updateDateDtoRes;
    }

    public void setUpdateDateDtoRes(Date updateDateDtoRes) {
        this.updateDateDtoRes = updateDateDtoRes;
    }

    public byte getStatusDtoRes() {
        return statusDtoRes;
    }

    public void setStatusDtoRes(byte statusDtoRes) {
        this.statusDtoRes = statusDtoRes;
    }

    public String getPostNameDtoRes() {
        return postNameDtoRes;
    }

    public void setPostNameDtoRes(String postNameDtoRes) {
        this.postNameDtoRes = postNameDtoRes;
    }
}
