package com.example.LoginSystem.phashing;

public class PWordHasher {
    public static String encode(String password){
        return new StringBuffer(password).reverse().toString();
    }
    public static String decode(String hash){
        return new StringBuffer(hash).reverse().toString();
    }
}
