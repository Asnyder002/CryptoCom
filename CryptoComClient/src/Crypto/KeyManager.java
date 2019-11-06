/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author Adam
 */
public class KeyManager {
    
    public static void saveKeyToFile(String path, byte[] key) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(key);
        outputStream.flush();
        outputStream.close();
    }
    
    public static PublicKey getPublicKeyFromFile(String base64PublicKey) {
        PublicKey publicKey = null;
        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch(InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }
    
    
}
