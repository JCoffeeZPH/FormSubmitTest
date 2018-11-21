package com.Test;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * com.Test
 * Administrator
 * 2018/11/21
 * 15:58
 */
public class TokenProccessor {
    private TokenProccessor(){}
    private static final TokenProccessor PROCCESSOR = new TokenProccessor();
    public static TokenProccessor getInstance(){
        return PROCCESSOR;
    }
    public String makeToken(){
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        MessageDigest md= null;
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] md5 = md.digest(token.getBytes());
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(md5);
    }

}
