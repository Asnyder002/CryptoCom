/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



/**
 *
 * @author youngking
 */
public class keyGenerator 
{
public static SecretKey generate() throws NoSuchAlgorithmException
{
    
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom secureRandom = new SecureRandom();
    int keyBitSize = 256;

    keyGenerator.init(keyBitSize, secureRandom);

    
    
    SecretKey key = keyGenerator.generateKey();
    return key;
    
}








}
