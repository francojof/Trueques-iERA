package com.taktika.iera.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "barters")
public class Barter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surplus_money", nullable = false)
    private double surplusMoney;

    @Column(name = "execution_confirmation", nullable = false)
    private byte executionConfirmation;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @Column(name = "status", nullable = false)
    private byte status;

    @OneToOne
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

    @OneToOne
    @JoinColumn(name = "id_post", nullable = false)
    private Post post;

    @OneToOne
    @JoinColumn(name = "id_barter_status",  nullable = false)
    private BarterStatus barterStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSurplusMoney() {
        return surplusMoney;
    }

    public void setSurplusMoney(double surplusMoney) {
        this.surplusMoney = surplusMoney;
    }

    public byte getExecutionConfirmation() {
        return executionConfirmation;
    }

    public void setExecutionConfirmation(byte executionConfirmation) {
        this.executionConfirmation = executionConfirmation;
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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public BarterStatus getBarterStatus() {
        return barterStatus;
    }

    public void setBarterStatus(BarterStatus barterStatus) {
        this.barterStatus = barterStatus;
    }
}
