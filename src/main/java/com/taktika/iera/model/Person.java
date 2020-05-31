package com.taktika.iera.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",unique = true, nullable = false)
    private String userName;

    @Column(name="name" , nullable = false)
    private String name;

    @Column(name="surname", nullable = false)
    private String surname;

    @Column(name="rut", nullable = false, unique = true)
    private String rut;

    @Column(name="phone", nullable = false, unique = true)
    private int phone;

    @Column(name="birthday", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "status", nullable = false)
    private byte status;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @UpdateTimestamp
    @Column(name = "reactivation_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date reactivationDate;

    @OneToOne
    @JoinColumn(name="id_gender", nullable = false)
    private Gender gender;

    @OneToOne
    @JoinColumn(name="id_commune",  nullable = false)
    private Commune commune;

    @OneToOne
    @JoinColumn(name="id_login",  nullable = false)
    private Login login;

    @OneToOne
    @JoinColumn(name="id_rol", nullable = false)
    private Rol rol;

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getReactivationDate() {
        return reactivationDate;
    }

    public void setReactivationDate(Date reactivationDate) {
        this.reactivationDate = reactivationDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
