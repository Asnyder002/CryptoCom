package RemoteObject;

import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable{
    
    String sender,
           recipient;
    
    byte[] encryptedMemo;
    
    public Message(byte[] encrytpedMemo, String sender, String recipient) {
        this.encryptedMemo = encryptedMemo;
        this.sender = sender;
        this.recipient = recipient;
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
    
    public byte[] getMemo() {return encryptedMemo;}
    public void setMemo(byte[] encryptedMemo) {this.encryptedMemo = encryptedMemo;}
    
    public String getSender() {return sender;}
    public void setSender(String sender) {this.sender = sender;}
    
    public String getRecipient() {return recipient;}
    public void setRecipent(String recipient) {this.recipient = recipient;}
    
}
