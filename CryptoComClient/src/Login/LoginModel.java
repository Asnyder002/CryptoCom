package Login;

import Crypto.KeyGeneratorRSA;
import Crypto.KeyManager;
import RemoteObject.CryptoComManager;
import RemoteObject.User;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class LoginModel {
    
    private String username;
    private String password;
    private CryptoComManager ccm;
    
    public LoginModel(CryptoComManager ccm) {
        this.ccm = ccm;
    }
    
    public boolean validateCredentials() throws InvalidKeySpecException, RemoteException, NoSuchAlgorithmException{
        // Check username to see if it's registered on the remote object
        if(ccm.usernameTaken(username)) {
            // If it is, pull the salt and has from the remote object
            User user = ccm.getUser(username);
            byte[] salt = user.getSalt();
            // Take the entered password and hash it with the salt
            byte[] enteredPasswordHashed = PasswordManager.generateHash(password, salt);
            // Compare both hashes, if they are the same allow access.
            return PasswordManager.compareHash(user.getHashedPassword(), enteredPasswordHashed);
            // Otherwise inform that an in correct password was given.
        }

        return false;
    }
    
    public boolean createNewUser() throws NoSuchAlgorithmException, InvalidKeySpecException, RemoteException, IOException {
        // Generate random salt
        if(!ccm.usernameTaken(username)) {
            byte[] salt = PasswordManager.generateSalt();
            // Hash the password with the salt
            byte[] hashedPassword = PasswordManager.generateHash(password, salt);
            // Create new private/public key
            KeyGeneratorRSA keyGen = new KeyGeneratorRSA();
            byte[] encodedPublicKey = KeyManager.encodePublicKey(keyGen.getPublicKey());
            // Save privateKey to file
            byte[] encodedPrivateKey = KeyManager.encodePrivateKey(keyGen.getPrivateKey());
            KeyManager.saveKeyToFile("RSA/privateKey", encodedPrivateKey);
            // Create new user
            User user = new User(username, hashedPassword, salt, encodedPublicKey);
            // Store the username, salt, and hashed password on the remote object
            ccm.addNewUser(user);
            return true;
        }
        return false;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
