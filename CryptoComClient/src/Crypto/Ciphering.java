package Crypto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;




/* to generate a new secret key use: secretKey = (SecretKeySpec) generateKey();
    
    to encrypt and decrypt call the textEncryption method with the the secret key as the second parameter:
    
    String Encrypted = textEncryption(usrInput, secretKey);
    String Decrypted = textDecryption(Encrypted, secretKey);
    
    */


public class Ciphering 
{
    
// Generating a random key to be used for the ciphering process
    private static SecretKeySpec secretKey;
    
    public static SecretKey generateKey() throws NoSuchAlgorithmException
{
    
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    SecureRandom secureRandom = new SecureRandom();
    final int keyBitSize = 256;

    keyGenerator.init(keyBitSize, secureRandom);

    
    
    SecretKey key = keyGenerator.generateKey();
    return key;
    
}
    

     public static String textEncryption(String strToEncrypt,SecretKey secretKey)
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

     
    public static String textDecryption(String strToDecrypt, SecretKey secretKey)
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

 
    
       /*
 // This class tests the AES encryption process
    public static void main(String[] args) throws NoSuchAlgorithmException
{
  
    
    
    // Getting the user input to encrypt it
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter text to encrypt ");
    String usrInput = userInput.nextLine() ;

   // Generating a random key to go along with the unencrypted text
    secretKey = (SecretKeySpec) generateKey();
            
           
           
        
       
      
    // Sending the  text and the secret key to be encrypted
     String Encrypted = textEncryption(usrInput, secretKey);
     
     // Calling the encrypted text and then sending it with the secret key to be decrypted
     String Decrypted = textDecryption(Encrypted, secretKey);
     
    //Printing Info
    System.out.println("Encoding algorithm "+secretKey.getAlgorithm());
    System.out.println("Original String "+usrInput);
    System.out.println("Encrypted String "+Encrypted);
    System.out.println("Decrypted String "+Decrypted);
}
    
   */ 
}

