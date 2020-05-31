package com.taktika.iera.dto;

import com.taktika.iera.model.Barter;

import java.util.List;

public class BarterListDto {

    private int totalBarter;
    private List<Barter> barterListDto;

    public int getTotalBarter() {
        return totalBarter;
    }

    public void setTotalBarter(int totalBarter) {
        this.totalBarter = totalBarter;
    }

    public List<Barter> getBarterListDto() {
        return barterListDto;
    }

    public void setBarterListDto(List<Barter> barterListDto) {
        this.barterListDto = barterListDto;
    }
}
