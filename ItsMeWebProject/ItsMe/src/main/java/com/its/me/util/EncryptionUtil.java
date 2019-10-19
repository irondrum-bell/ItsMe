/**
 * 
 */
package com.its.me.util;

/**
 * @author Hwang Hee Jeong(hjhwang_ymtech_kr)
 *
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {
	
    public static MessageDigest md;

    public static String encrypt(String userPassword) {
        //one way 함수 집합

        String tempPassword = "";

        try {
            //SHA-512알고리즘 사용
            if(md==null) md = MessageDigest.getInstance("SHA-512");
            //문자열로 받아들임
            md.update(userPassword.getBytes());
            byte[] mb = md.digest();

            for (int i = 0; i < mb.length; i++) {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                tempPassword += s;
            }

            return tempPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(encrypt("admin"));
    }
}