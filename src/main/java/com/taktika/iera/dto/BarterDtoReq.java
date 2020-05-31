package com.taktika.iera.dto;

import java.util.Date;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class BarterDtoReq {

    private Long idPersonDtoReq;
    private double surplusMoneyDtoReq;
    private byte executionConfirmationDtoReq;
    private Date creationDateDtoReq;
    private Date updateDateDtoReq;
    private byte statusDtoReq;
    private Long idPost;                    //id foreign key
    private Long idBarterStatusDtoReq;      //id foreign key

    public Long getIdPersonDtoReq() {
        return idPersonDtoReq;
    }

    public void setIdPersonDtoReq(Long idPersonDtoReq) {
        this.idPersonDtoReq = idPersonDtoReq;
    }

    public double getSurplusMoneyDtoReq() {
        return surplusMoneyDtoReq;
    }

    public void setSurplusMoneyDtoReq(double surplusMoneyDtoReq) {
        this.surplusMoneyDtoReq = surplusMoneyDtoReq;
    }

    public byte getExecutionConfirmationDtoReq() {
        return executionConfirmationDtoReq;
    }

    public void setExecutionConfirmationDtoReq(byte executionConfirmationDtoReq) {
        this.executionConfirmationDtoReq = executionConfirmationDtoReq;
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

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdBarterStatusDtoReq() {
        return idBarterStatusDtoReq;
    }

    public void setIdBarterStatusDtoReq(Long idBarterStatusDtoReq) {
        this.idBarterStatusDtoReq = idBarterStatusDtoReq;
    }
}
