package Crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyGenerator {
    
    private PublicKey publicKey;
    private PrivateKey privateKey;
    
    // Creates RSA 1024 encrypted keys and saves them to the private fields
    public KeyGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair keyPair = keyGen.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }
    
    public PublicKey getPublicKey() {
        return this.publicKey;
    }
    
    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }
    
}
