/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class Mining {
    
    private final long  maxCounter;
    
    public Mining(long max){
        this.maxCounter = max;
    }
    
    public int trace(String key, String template){
        int counter = 1;
        String input = key + counter;
        String hash = getHash(input);

        while (!isValid(hash, template)){
            counter++;
            input = key + counter;
            hash = getHash(input);
            if (counter > maxCounter){
                System.out.println("No number is found up to " + maxCounter);
                return -1;
            }
            
        }
        return counter;
        
       
    }
    
    public String getHash(String key){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
                return sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("algoritm is not found: " + ex.getMessage());
        }
        return null;
    }
    
    
    /**
     * Returns true if the first string contains at the beginning the second one.
     * @param str
     * @param start
     * @return 
     */
    public boolean isValid(String str, String start){
        int startLen  = start.length();
        return (str.length() >= startLen && str.substring(0, startLen).equals(start));
    
    }
    
}
