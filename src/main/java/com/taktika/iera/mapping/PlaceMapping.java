package com.taktika.iera.mapping;

import com.taktika.iera.model.Place;
import com.taktika.iera.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceMapping {

    public Place transformOptionalIntoModel(Optional<Place> objPlaceOptional) throws Exception {
        Place objPlace = null;
        try {
            if (objPlaceOptional.isPresent()) {
                objPlace = new Place();
                objPlace.setId(objPlaceOptional.get().getId());
                objPlace.setName(objPlaceOptional.get().getName());
                objPlace.setCommune(objPlaceOptional.get().getCommune());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Constant.SYSTEM_ERROR);
        }
        return objPlace;
    }

}
