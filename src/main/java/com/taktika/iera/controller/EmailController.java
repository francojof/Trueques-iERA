package com.taktika.iera.controller;

import com.taktika.iera.imp.EmailImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/app/email")
public class EmailController {

    @Autowired
    private EmailImp emailImp;

    @GetMapping("/sendMail/{email}")
    public ResponseEntity<Object> sendEmail(@PathVariable(value = "email",required = true)String email){
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(emailImp.sendEmail(email), HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e){
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }
}
