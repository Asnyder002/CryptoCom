package Crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KeyManager {
    
    private PublicKey publicKey;
    private PrivateKey privateKey;
    
    public KeyManager() {
        
    }
    
    public void generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair keyPair = keyGen.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }
    
    public void saveKeyToFile(String path, byte[] key) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(key);
        outputStream.flush();
        outputStream.close();
    }
    
    public static PublicKey getPublicKeyFromFile(String base64PublicKey) {
        
        // Needs to take in a file
        // Open and pull base64Public key from file
        
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
    
    public PublicKey getPublicKey() {
        return this.publicKey;
    }
    
    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }
    
}
