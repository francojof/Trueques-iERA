package com.taktika.iera.service;

import com.taktika.iera.model.Place;

import java.util.List;

public interface iPlaceService {
    Place searchById(Long id) throws Exception;
    List<Place> listPlaces() throws Exception;
}
