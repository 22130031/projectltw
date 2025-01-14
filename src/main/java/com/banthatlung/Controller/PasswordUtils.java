package com.banthatlung.Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    public static String encryptPassword(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException("Error hashing password",e);
        }
    }
}