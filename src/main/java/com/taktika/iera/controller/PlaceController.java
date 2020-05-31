package com.taktika.iera.controller;

import com.taktika.iera.imp.PlaceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/app/meetingPlaces")
public class PlaceController {

    @Autowired
    PlaceImp objPlaceImp;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listPerson() {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objPlaceImp.listPlaces(), HttpStatus.OK);
        } catch (Exception e) {
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return objResponseEntity;
    }

}
