package com.taktika.iera.security;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

@Service
public class EncryptPasswordService{

    final static String password = "I AM SHERLOCKED";
    final static  String salt = KeyGenerators.string().generateKey();

    public String encrypt(String passwordUser){
        TextEncryptor encryptor = Encryptors.text(password, salt);
        System.out.println("Salt: \"" + salt + "\"");

        String textToEncrypt = passwordUser;
        System.out.println("Original text: \"" + textToEncrypt + "\"");

        String encryptedText = encryptor.encrypt(textToEncrypt);
        System.out.println("Encrypted text: \"" + encryptedText + "\"");

        return encryptedText;
    }

}
