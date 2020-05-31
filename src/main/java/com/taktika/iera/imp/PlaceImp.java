package com.taktika.iera.imp;

import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.mapping.PlaceMapping;
import com.taktika.iera.model.Place;
import com.taktika.iera.repository.PlaceRepository;
import com.taktika.iera.service.iPlaceService;
import com.taktika.iera.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */
@Service
public class PlaceImp implements iPlaceService {

    @Autowired
    PlaceRepository objPlaceRepository;

    @Autowired
    PlaceMapping objPlaceMapping;

    public Place searchById(Long id) throws Exception {
        Place objPlace;
        try {
            objPlace = objPlaceMapping.transformOptionalIntoModel(objPlaceRepository.findById(id));
            if (null == objPlace) {
                throw new NotFoundException(Constant.NOT_FOUND_ERROR);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new NotFoundException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPlace;
    }

    @Override
    public List<Place> listPlaces() throws Exception {
        List<Place> placesList;
        try {
            placesList = objPlaceRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return placesList;
    }
}
