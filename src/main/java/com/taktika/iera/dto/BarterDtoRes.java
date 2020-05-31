package com.taktika.iera.dto;

import java.util.Date;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class BarterDtoRes {

    private Long idDtoRes;
    private double surplusMoneyDtoRes;
    private byte executionConfirmationDtoRes;
    private Date creationDateDtoRes;
    private Date updateDateDtoRes;
    private byte statusDtoRes;
    private String userNamePersonDtoRes;    //userName Person (foreign key)
    private String namePersonDtoRes;    //name Person (foreign key)
    private String postNameDtoRes;      //name Post (foreign key)
    private String barterStatusDtoRes;  //name BarterStatus (foreign key)

    public Long getIdDtoRes() {
        return idDtoRes;
    }

    public void setIdDtoRes(Long idDtoRes) {
        this.idDtoRes = idDtoRes;
    }

    public double getSurplusMoneyDtoRes() {
        return surplusMoneyDtoRes;
    }

    public void setSurplusMoneyDtoRes(double surplusMoneyDtoRes) {
        this.surplusMoneyDtoRes = surplusMoneyDtoRes;
    }

    public byte getExecutionConfirmationDtoRes() {
        return executionConfirmationDtoRes;
    }

    public void setExecutionConfirmationDtoRes(byte executionConfirmationDtoRes) {
        this.executionConfirmationDtoRes = executionConfirmationDtoRes;
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

    public String getUserNamePersonDtoRes() {
        return userNamePersonDtoRes;
    }

    public void setUserNamePersonDtoRes(String userNamePersonDtoRes) {
        this.userNamePersonDtoRes = userNamePersonDtoRes;
    }

    public String getNamePersonDtoRes() {
        return namePersonDtoRes;
    }

    public void setNamePersonDtoRes(String namePersonDtoRes) {
        this.namePersonDtoRes = namePersonDtoRes;
    }

    public String getPostNameDtoRes() {
        return postNameDtoRes;
    }

    public void setPostNameDtoRes(String postNameDtoRes) {
        this.postNameDtoRes = postNameDtoRes;
    }

    public String getBarterStatusDtoRes() {
        return barterStatusDtoRes;
    }

    public void setBarterStatusDtoRes(String barterStatusDtoRes) {
        this.barterStatusDtoRes = barterStatusDtoRes;
    }
}
