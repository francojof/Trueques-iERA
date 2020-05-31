package com.taktika.iera.dto;

import java.util.Date;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class OfferDtoReq {

    private Long idBarterDtoReq;          //id foreign key
    private Date creationDateDtoReq;
    private Date updateDateDtoReq;
    private byte statusDtoReq;
    private Long idPostDtoReq;            //id foreign key

    public Long getIdBarterDtoReq() {
        return idBarterDtoReq;
    }

    public void setIdBarterDtoReq(Long idBarterDtoReq) {
        this.idBarterDtoReq = idBarterDtoReq;
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

    public Long getIdPostDtoReq() {
        return idPostDtoReq;
    }

    public void setIdPostDtoReq(Long idPostDtoReq) {
        this.idPostDtoReq = idPostDtoReq;
    }
}
