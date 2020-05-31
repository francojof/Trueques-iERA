package com.taktika.iera.controller;

import com.taktika.iera.dto.OfferDtoReq;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.imp.OfferImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/app/offers")
public class OfferController {

    @Autowired
    OfferImp objOfferImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> saveOffer(@RequestBody OfferDtoReq objOfferDtoReq) {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objOfferImp.saveOffer(objOfferDtoReq), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (SaveException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/lists/{idBarter}", method = RequestMethod.GET)
    public ResponseEntity<Object> listOffer(@PathVariable Long idBarter, @RequestParam int page, @RequestParam int size) {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objOfferImp.listOffersByBarter(idBarter, page, size), HttpStatus.OK);
        } catch (Exception e) {
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteOffer(@PathVariable Long id) {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objOfferImp.deleteOffer(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> searchById(@PathVariable Long id) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objOfferImp.searchById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }
}