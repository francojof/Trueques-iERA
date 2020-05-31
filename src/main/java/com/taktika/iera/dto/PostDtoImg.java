package com.taktika.iera.dto;

import com.taktika.iera.model.Commune;
import com.taktika.iera.model.Person;
import com.taktika.iera.model.Tercategory;

import java.util.Date;
import java.util.List;

// this class have all attributes of Post class more two extra attributes, main image and other images
public class PostDtoImg {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String interest;
    private Date creationDate;
    private Date updateDate;
    private byte status;
    private Person person;
    private Tercategory tercategory;
    private Commune commune;
    private String mainImage;               //main image
    private List<String> images;            //other images

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
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

    public Tercategory getTercategory() {
        return tercategory;
    }

    public void setTercategory(Tercategory tercategory) {
        this.tercategory = tercategory;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
