package Login;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class User {
    
    private String username;
    private byte[] salt;
    private byte[] hashedPassword;
    
    public User(String username, byte[] hashedPassword, byte[] salt) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public byte[] getSalt() {
        return this.salt;
    }
    
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
    
    public byte[] getHashedPassword() {
        return this.hashedPassword;
    }
    
    public void setHashedPassword(byte[] hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    
    
    
    
    
}