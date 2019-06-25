package com.itheima.until;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
private  static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public  static   String  password(String password){

         return    bCryptPasswordEncoder.encode(password);

    }


    public static void main(String[] args) {
           String  s = "112";

        String encode = bCryptPasswordEncoder.encode(s);
        System.out.printf(encode);

    }
}
