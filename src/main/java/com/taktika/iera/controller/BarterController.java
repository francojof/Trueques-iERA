package com.taktika.iera.controller;

import com.taktika.iera.dto.BarterDtoReq;
import com.taktika.iera.dto.OfferDtoReq;
import com.taktika.iera.dto.SaveBarterDtoReq;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.imp.BarterImp;
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
@RequestMapping("api/v1/app/barters")
public class BarterController {

    @Autowired
    BarterImp objBarterImp;

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<Object> saveBarter(@RequestBody SaveBarterDtoReq objSaveBarterDtoReq) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objBarterImp.saveBarter(objSaveBarterDtoReq), HttpStatus.OK);
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

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    private ResponseEntity<Object> updateBarter(@PathVariable Long id, @RequestBody BarterDtoReq objBarterDtoReq) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objBarterImp.updateBarter(id, objBarterDtoReq), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UpdateException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    private ResponseEntity<Object> deleteBarter(@PathVariable Long id) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objBarterImp.deleteBarter(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> searchById(@PathVariable Long id) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objBarterImp.searchById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "lists/posts/{idPost}/page", method = RequestMethod.GET)
    public ResponseEntity<Object> listBartersByPost(@PathVariable Long idPost, @RequestParam int page, @RequestParam int size) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objBarterImp.listBartersByPost(idPost, page, size), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "lists/profile/{idPerson}/page", method = RequestMethod.GET)
    public ResponseEntity<Object> listBartersByPerson(@PathVariable Long idPerson, @RequestParam int page, @RequestParam int size) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objBarterImp.listBartersByPerson(idPerson, page, size), HttpStatus.OK);
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
