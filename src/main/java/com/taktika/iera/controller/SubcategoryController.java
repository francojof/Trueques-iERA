package com.taktika.iera.controller;

import com.taktika.iera.dto.SubcategoryDtoReq;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.exception.UpdateException;
import com.taktika.iera.imp.SubcategoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/app/subcategories")
public class SubcategoryController {

    @Autowired
    SubcategoryImp objSubcategoryImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> saveSubcategory(@RequestBody SubcategoryDtoReq objSubcategoryDtoReq) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objSubcategoryImp.saveSubcategory(objSubcategoryDtoReq), HttpStatus.OK);
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
    public ResponseEntity<Object> updateSubcategory(@PathVariable Long id, @RequestBody SubcategoryDtoReq objSubcategoryDtoReq) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objSubcategoryImp.updateSubcategory(id, objSubcategoryDtoReq), HttpStatus.OK);
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
    public ResponseEntity<Object> listSubcategory() {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objSubcategoryImp.listSubcategory(), HttpStatus.OK);
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
            objResponseEntity = new ResponseEntity<Object>(objSubcategoryImp.searchById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSubcategory(@PathVariable Long id) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objSubcategoryImp.deleteSubcategory(id), HttpStatus.OK);
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
