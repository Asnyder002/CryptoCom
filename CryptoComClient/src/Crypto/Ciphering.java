/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author youngking
 */
public class Ciphering 
{
    
//Research in progress
    
//    public static void keystore()
//    {
//    }
    
// Generating a random key to be used for the ciphering process
    private static SecretKeySpec secretKey;
    public static SecretKey generate() throws NoSuchAlgorithmException
{
    
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom secureRandom = new SecureRandom();
    int keyBitSize = 256;

    keyGenerator.init(keyBitSize, secureRandom);

    
    
    SecretKey key = keyGenerator.generateKey();
    return key;
    
}
 // This class tests the AES encryption proces
    public static void /*main*/test(String[] args) throws NoSuchAlgorithmException
{
  
    
    
    // Getting the user input to encrypt it
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter text to encrypt ");
    String usrInput = userInput.nextLine() ;

   // Generating a random key to go along with the unencrypted text
    secretKey = (SecretKeySpec) keyGenerator.generate();
            
           
           
        
       
      
    // Sending the  text and the secret key to be encrypted
     String Encrypted = Encryption.encrypt(usrInput, secretKey);
     
     // Calling the encrypted text and then sending it with the secret key to be decrypted
     String Decrypted = Decryption.decrypt(Encrypted, secretKey);
     
    //Printing Info
    System.out.println("Encoding algorithm "+secretKey.getAlgorithm());
    System.out.println("Original String "+usrInput);
    System.out.println("Encrypted String "+Encrypted);
    System.out.println("Decrypted String "+Decrypted);
}
    
    
     public static String encrypt(String strToEncrypt,SecretKey secretKey)
    {
        try
        {
           // Instantiate the cipher object as AES cipher with ECB mode of operation and PKCS5 padding scheme
            Cipher Encrypt= Cipher.getInstance("AES/ECB/PKCS5Padding");
            
            //Encrypting the text with the secret key
            Encrypt.init(Cipher.ENCRYPT_MODE, secretKey);
            
            
            
            // Returning an encrypted message
            String encrypted = Base64.getEncoder().encodeToString(Encrypt.doFinal(strToEncrypt.getBytes("UTF-8")));
           
            return (encrypted);
            
        }
        catch (Exception e)
        {
            System.out.println("Error cannot encrypt because: " + e.toString());
        }
        return null;
    }

     
    public static String decrypt(String strToDecrypt, SecretKey secretKey)
    {
        try
        {
            //getting the instance of the key to be used, deciphering the message and returning the message
            Cipher decrypt = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            decrypt.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(decrypt.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

 
    
     
}

