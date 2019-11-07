package RemoteObject;

import RemoteObject.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    
    private String username;
    private byte[] salt;
    private byte[] hashedPassword;
    private byte[] encodedPublicKey;
    private List<Message> messageList = new ArrayList<>();
    
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
    
    public byte[] getEncodedPublicKey() {
       return this.encodedPublicKey;
    }
    
    public void setEncodedPublicKey(byte[] encodedPublicKey) {
        this.encodedPublicKey = encodedPublicKey;
    }
    
    public List getMessageList() {
        return messageList;
    }
    
    public void setMessagesList(List messageList) {
        this.messageList = messageList;
    }
    
}
