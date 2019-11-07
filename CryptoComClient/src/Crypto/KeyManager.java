package Crypto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyManager {

    
    // Saves encoded keys to file, currently saves as "RSA/privateKey"
    public static void saveKeyToFile(String path, byte[] key) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(key);
        outputStream.flush();
        outputStream.close();
    }
    
    // Generates a public key from encoded bytes saved to file
    public static PublicKey getPublicKeyFromFile(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
	return getPublicKeyFromBytes(keyBytes);
    }
    
    // Generates a private key from encded bytes save to file
    public static PrivateKey getPrivateKeyFromFile(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
	return getPrivateKeyFromBytes(keyBytes);
    }
    
    // Returns public key from bytes
    public static PublicKey getPublicKeyFromBytes(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
	KeyFactory kf = KeyFactory.getInstance("RSA");
	return kf.generatePublic(spec);
    }
    
    // Returns private key from bytes
    public static PrivateKey getPrivateKeyFromBytes(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
	KeyFactory kf = KeyFactory.getInstance("RSA");
	return kf.generatePrivate(spec);
    }
    
    // wrapper for getEncoded
    public static byte[] encodePublicKey(PublicKey publicKey) {
        return publicKey.getEncoded();
    }
    
    // wrapper for getEncoded
    public  static byte[] encodePrivateKey(PrivateKey privateKey) {
        return privateKey.getEncoded();
    }
    
}
