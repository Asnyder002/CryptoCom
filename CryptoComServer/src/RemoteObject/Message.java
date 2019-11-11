package RemoteObject;

import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable{
    
    String memo,
           sender,
           recipient;
    
    byte[] encryptedMemo;
    byte[] encryptedSecretKey;
    
    public Message(byte[] encryptedMemo, String sender, String recipient, byte[] encryptedSecretKey) {
        this.encryptedMemo = encryptedMemo;
        this.sender = sender;
        this.recipient = recipient;
        this.encryptedSecretKey = encryptedSecretKey;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if(o == this) {return true;}
        
        if(!(o instanceof Message)) {return false;}
        
        Message otherMessage = (Message)o;
        
        if(this.encryptedMemo == otherMessage.encryptedMemo &&
           this.sender == otherMessage.sender &&
           this.recipient == otherMessage.recipient) 
        {
            return true;
        }
        
        return false;
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.encryptedMemo);
        hash = 41 * hash + Objects.hashCode(this.sender);
        hash = 41 * hash + Objects.hashCode(this.recipient);
        return hash;
    }
    
    public String getMemo() {return memo;}
    public void setMemo(String memo) {this.memo = memo;}
    
    public byte[] getEncryptedMemo() {return encryptedMemo;}
    public void setEncryptedMemo(byte[] encryptedMemo) {this.encryptedMemo = encryptedMemo;}
    
    public String getSender() {return sender;}
    public void setSender(String sender) {this.sender = sender;}
    
    public String getRecipient() {return recipient;}
    public void setRecipent(String recipient) {this.recipient = recipient;}
    
    public byte[] getEncrytpedSecretKey() {return encryptedSecretKey;}
    public void setEncrytpedSecretKey(byte[] encryptedSecretKey) {this.encryptedSecretKey = encryptedSecretKey;}
    
}
