package com.taktika.iera.controller;

import com.taktika.iera.dto.PersonDtoReq;
import com.taktika.iera.dto.UserDtoReq;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.exception.UserErrorException;
import com.taktika.iera.imp.PersonImp;
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
@RequestMapping("api/v1/app/persons")
public class PersonController {

    @Autowired
    PersonImp objPersonImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody UserDtoReq objUserDtoReq) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objPersonImp.saveUser(objUserDtoReq), HttpStatus.OK);
        } catch (UserErrorException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
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
    public ResponseEntity<Object> updatePerson(@PathVariable Long id, @RequestBody PersonDtoReq objPersonDtoReq) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objPersonImp.updatePerson(id, objPersonDtoReq), HttpStatus.OK);
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> listPerson() {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objPersonImp.listPerson(), HttpStatus.OK);
        } catch (Exception e) {
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePerson(@PathVariable Long id) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objPersonImp.deletePerson(id), HttpStatus.OK);
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
            objResponseEntity = new ResponseEntity<Object>(objPersonImp.searchById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/{userName}validate", method = RequestMethod.GET)
    public ResponseEntity<Object> userNameValidate(@PathVariable String userName) {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objPersonImp.userNameValidate(userName), HttpStatus.OK);
        } catch (UserErrorException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }

    /*@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
    public ResponseEntity<Object> searchByEmail(@PathVariable String email) {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objPersonImp.searchByEmail(email), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }*/

}
