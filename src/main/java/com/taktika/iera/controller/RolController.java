package com.taktika.iera.controller;

import com.taktika.iera.dto.RolDto;
import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.exception.SaveException;
import com.taktika.iera.imp.RolImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/app/roles")
public class RolController {

    @Autowired
    RolImp objRolImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> saveRol(@RequestBody RolDto objRolDto) {
        ResponseEntity<Object> objResponseEntity;
        try{
            objResponseEntity = new ResponseEntity<Object>(objRolImp.saveRol(objRolDto), HttpStatus.OK);
        }catch (SaveException e){
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRol(@PathVariable Long id){
        ResponseEntity<Object> objResponsEntity;
        try{
            objResponsEntity = new ResponseEntity<Object>(objRolImp.deleteRol(id), HttpStatus.OK);
        }catch (NotFoundException e){
            e.printStackTrace();
            objResponsEntity = new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            objResponsEntity = new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponsEntity;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> searchById(@PathVariable Long id) {
        ResponseEntity<Object> objResponseEntity = null;
        try {
            objResponseEntity = new ResponseEntity<Object>(objRolImp.searchById(id), HttpStatus.OK);
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
