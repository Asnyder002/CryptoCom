/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.util.Scanner;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;



public class AESEncryption {
    
      private static SecretKeySpec secretKey;
public static void main(String[] args) throws NoSuchAlgorithmException
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
     
    //Printing Ingo
    System.out.println("Encoding algorithm "+secretKey.getAlgorithm());
    System.out.println("Original String "+usrInput);
    System.out.println("Encrypted String "+Encrypted);
    System.out.println("Decrypted String "+Decrypted);
}


    
}
