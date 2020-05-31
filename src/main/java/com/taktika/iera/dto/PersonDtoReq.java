package com.taktika.iera.dto;

import java.util.Date;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class PersonDtoReq {

    private Long idDtoReq;
    private String userNameDtoReq;
    private String nameDtoReq;
    private String surnameDtoReq;
    private int phoneDtoReq;
    private String rutDtoReq;
    private Date birthdayDtoReq;
    private byte statusDtoReq;
    private Date creationDateDtoReq;
    private Date updateDateDtoReq;
    private Date reactivationDateDtoReq;
    private Long idGenderDtoReq;        //id foreign key
    private Long idCommuneDtoReq;       //id foreign key
    private Long idLoginDtoReq;         //id foreign key
    private Long idRolDtoReq;           //id foreign key

    public Long getIdDtoReq() {
        return idDtoReq;
    }

    public void setIdDtoReq(Long idDtoReq) {
        this.idDtoReq = idDtoReq;
    }

    public String getUserNameDtoReq() {
        return userNameDtoReq;
    }

    public void setUserNameDtoReq(String userNameDtoReq) {
        this.userNameDtoReq = userNameDtoReq;
    }

    public String getNameDtoReq() {
        return nameDtoReq;
    }

    public void setNameDtoReq(String nameDtoReq) {
        this.nameDtoReq = nameDtoReq;
    }

    public String getSurnameDtoReq() {
        return surnameDtoReq;
    }

    public void setSurnameDtoReq(String surnameDtoReq) {
        this.surnameDtoReq = surnameDtoReq;
    }

    public int getPhoneDtoReq() {
        return phoneDtoReq;
    }

    public void setPhoneDtoReq(int phoneDtoReq) {
        this.phoneDtoReq = phoneDtoReq;
    }

    public String getRutDtoReq() {
        return rutDtoReq;
    }

    public void setRutDtoReq(String rutDtoReq) {
        this.rutDtoReq = rutDtoReq;
    }

    public Date getBirthdayDtoReq() {
        return birthdayDtoReq;
    }

    public void setBirthdayDtoReq(Date birthdayDtoReq) {
        this.birthdayDtoReq = birthdayDtoReq;
    }

    public byte getStatusDtoReq() {
        return statusDtoReq;
    }

    public void setStatusDtoReq(byte statusDtoReq) {
        this.statusDtoReq = statusDtoReq;
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

    public Date getReactivationDateDtoReq() {
        return reactivationDateDtoReq;
    }

    public void setReactivationDateDtoReq(Date reactivationDateDtoReq) {
        this.reactivationDateDtoReq = reactivationDateDtoReq;
    }

    public Long getIdGenderDtoReq() {
        return idGenderDtoReq;
    }

    public void setIdGenderDtoReq(Long idGenderDtoReq) {
        this.idGenderDtoReq = idGenderDtoReq;
    }

    public Long getIdCommuneDtoReq() {
        return idCommuneDtoReq;
    }

    public void setIdCommuneDtoReq(Long idCommuneDtoReq) {
        this.idCommuneDtoReq = idCommuneDtoReq;
    }

    public Long getIdLoginDtoReq() {
        return idLoginDtoReq;
    }

    public void setIdLoginDtoReq(Long idLoginDtoReq) {
        this.idLoginDtoReq = idLoginDtoReq;
    }

    public Long getIdRolDtoReq() {
        return idRolDtoReq;
    }

    public void setIdRolDtoReq(Long idRolDtoReq) {
        this.idRolDtoReq = idRolDtoReq;
    }
}
