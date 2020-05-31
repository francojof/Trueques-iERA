package com.taktika.iera.dto;

import java.util.Date;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class PostDtoReq {

    private Long idDtoReq;
    private String nameDtoReq;
    private String descriptionDtoReq;
    private double priceDtoReq;
    private String interestDtoReq;
    private Date creationDateDtoReq;
    private Date updateDateDtoReq;
    private byte statusDtoReq;
    private Long idPersonDtoReq;        //id foreign key
    private Long idTerCategoryDtoReq;   //id foreign key
    private Long idCommuneDtoReq;       //id foreign key

    public Long getIdDtoReq() {
        return idDtoReq;
    }

    public void setIdDtoReq(Long idDtoReq) {
        this.idDtoReq = idDtoReq;
    }

    public String getNameDtoReq() {
        return nameDtoReq;
    }

    public void setNameDtoReq(String nameDtoReq) {
        this.nameDtoReq = nameDtoReq;
    }

    public String getDescriptionDtoReq() {
        return descriptionDtoReq;
    }

    public void setDescriptionDtoReq(String descriptionDtoReq) {
        this.descriptionDtoReq = descriptionDtoReq;
    }

    public double getPriceDtoReq() {
        return priceDtoReq;
    }

    public void setPriceDtoReq(double priceDtoReq) {
        this.priceDtoReq = priceDtoReq;
    }

    public String getInterestDtoReq() {
        return interestDtoReq;
    }

    public void setInterestDtoReq(String interestDtoReq) {
        this.interestDtoReq = interestDtoReq;
    }

    public Date getCreationDateDtoReq() {
        return creationDateDtoReq;
    }

    public void setCreationDateDtoReq(Date creationDateDtoReq) {
        this.creationDateDtoReq = creationDateDtoReq;
    }

    public Date getUpdateDateDtoReq() {
        return updateDateDtoReq;
    }

    public void setUpdateDateDtoReq(Date updateDateDtoReq) {
        this.updateDateDtoReq = updateDateDtoReq;
    }

    public byte getStatusDtoReq() {
        return statusDtoReq;
    }

    public void setStatusDtoReq(byte statusDtoReq) {
        this.statusDtoReq = statusDtoReq;
    }

    public Long getIdPersonDtoReq() {
        return idPersonDtoReq;
    }

    public void setIdPersonDtoReq(Long idPersonDtoReq) {
        this.idPersonDtoReq = idPersonDtoReq;
    }

    public Long getIdTerCategoryDtoReq() {
        return idTerCategoryDtoReq;
    }

    public void setIdTerCategoryDtoReq(Long idTerCategoryDtoReq) {
        this.idTerCategoryDtoReq = idTerCategoryDtoReq;
    }

    public Long getIdCommuneDtoReq() {
        return idCommuneDtoReq;
    }

    public void setIdCommuneDtoReq(Long idCommuneDtoReq) {
        this.idCommuneDtoReq = idCommuneDtoReq;
    }
}
