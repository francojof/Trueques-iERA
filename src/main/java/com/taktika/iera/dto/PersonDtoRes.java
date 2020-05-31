package com.taktika.iera.dto;

import java.util.Date;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

public class PersonDtoRes {

    private Long idDtoRes;
    private String userNameDtoRes;
    private String nameDtoRes;
    private String surnameDtoRes;
    private String rutDtoRes;
    private int phoneDtoRes;
    private String communeDtoRes;       //name Commune (foreign key)
    private Date creationDateDtoRes;
    private Date birthdayDtoRes;
    private String emailDtoRes;         //email Login (foreign key)
    private String genderDtoRes;

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

    public String getUserNameDtoRes() {
        return userNameDtoRes;
    }

    public void setUserNameDtoRes(String userNameDtoRes) {
        this.userNameDtoRes = userNameDtoRes;
    }

    public String getSurnameDtoRes() {
        return surnameDtoRes;
    }

    public void setSurnameDtoRes(String surnameDtoRes) {
        this.surnameDtoRes = surnameDtoRes;
    }

    public String getRutDtoRes() {
        return rutDtoRes;
    }

    public void setRutDtoRes(String rutDtoRes) {
        this.rutDtoRes = rutDtoRes;
    }

    public int getPhoneDtoRes() {
        return phoneDtoRes;
    }

    public void setPhoneDtoRes(int phoneDtoRes) {
        this.phoneDtoRes = phoneDtoRes;
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

    public Date getBirthdayDtoRes() {
        return birthdayDtoRes;
    }

    public void setBirthdayDtoRes(Date birthdayDtoRes) {
        this.birthdayDtoRes = birthdayDtoRes;
    }

    public String getEmailDtoRes() {
        return emailDtoRes;
    }

    public void setEmailDtoRes(String emailDtoRes) {
        this.emailDtoRes = emailDtoRes;
    }

    public String getGenderDtoRes() {
        return genderDtoRes;
    }

    public void setGenderDtoRes(String genderDtoRes) {
        this.genderDtoRes = genderDtoRes;
    }
}
