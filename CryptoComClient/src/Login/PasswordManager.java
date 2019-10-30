package Login;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordManager {
    
    private final static int iteration = 65536;
    private final static int keyLength = 128;
    private final static String algorithm = "PBKDF2WithHmacSHA1";
    
    public static byte[] generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
    public static byte[] generateHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iteration, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return hash;
    }
    
    public static boolean compareHash(byte[] storedPass, byte[] enteredPass) {
        return Arrays.equals(storedPass, enteredPass);
    }
    
}
