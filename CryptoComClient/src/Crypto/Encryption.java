/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;


import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Humble Foundations
 */
public class Encryption {
     public static String encrypt(String strToEncrypt,SecretKey secretKey)
    {
        try
        {
            /* instantiate the cipher object as AEs cipher with ECB mode of operation and PKCS5 padding scheme
            
            */
            Cipher Encrypt= Cipher.getInstance("AES/ECB/PKCS5Padding");
            
            //Encrypting the text with the secret key
            Encrypt.init(Cipher.ENCRYPT_MODE, secretKey);
            
            
            
            
            String encrypted = Base64.getEncoder().encodeToString(Encrypt.doFinal(strToEncrypt.getBytes("UTF-8")));
           
            return (encrypted);
            
        }
        catch (Exception e)
        {
            System.out.println("Error cannot encrypt because: " + e.toString());
        }
        return null;
    }

 
    
     
}
