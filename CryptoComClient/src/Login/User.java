package Login;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class User {
    
    private String username;
    private String password;
    private byte[] salt;
    private byte[] hashedPassword;
    private final int iteration = 65536;
    private final int keyLength = 128;
    private final String algorithm = "PBKDF2WithHmacSHA1";
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public byte[] generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
    public byte[] generateHash(String pass) throws NoSuchAlgorithmException, InvalidKeySpecException{
        KeySpec spec = new PBEKeySpec(pass.toCharArray(), salt, iteration, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return hash;
    }
    
    
    
    
    
}
