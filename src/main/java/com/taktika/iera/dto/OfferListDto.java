package com.taktika.iera.dto;

import com.taktika.iera.model.Offer;

import java.util.List;

public class OfferListDto {

    private double totalOffers;
    private List<Offer> listOffer;

    public double getTotalOffers() {
        return totalOffers;
    }

    public void setTotalOffers(double totalOffers) {
        this.totalOffers = totalOffers;
    }

    public List<Offer> getListOffer() {
        return listOffer;
    }

    public void setListOffer(List<Offer> listOffer) {
        this.listOffer = listOffer;
    }
}
