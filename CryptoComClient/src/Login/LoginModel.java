package Login;

import RemoteObject.CryptoComManager;

public class LoginModel {
    
    private String username;
    private String password;
    private CryptoComManager ccm;
    
    public LoginModel(CryptoComManager ccm) {
        this.ccm = ccm;
    }
    
    public boolean validateCredentials(){
        // Check username to see if it's registered on the remote object
        // If it is, pull the salt and has from the remote object
        // Take the entered password and hash it with the salt
        // Compare both hashes, if they are the same allow access.
        // Otherwise inform that an in correct password was given.
        return true;
    }
    
    public void createNewUser() {
        // Generate random salt
        // Hash the password with the salt
        // Store the username, salt, and hashed password on the remote object
        
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String setPassword() {
        return this.password;
    }
    
    public void getPassword(String password) {
        this.password = password;
    }
}
