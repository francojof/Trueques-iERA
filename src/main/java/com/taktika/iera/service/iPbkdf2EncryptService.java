package com.taktika.iera.service;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface iPbkdf2EncryptService {
    String generateHashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
    boolean passwordValidate(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
