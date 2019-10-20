package RemoteObject;

import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable{
    
    String memo,
           sender,
           recipient;
    
    public Message(String memo, String sender, String recipient) {
        this.memo = memo;
        this.sender = sender;
        this.recipient = recipient;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if(o == this) {return true;}
        
        if(!(o instanceof Message)) {return false;}
        
        Message otherMessage = (Message)o;
        
        if(this.memo == otherMessage.memo &&
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
        hash = 41 * hash + Objects.hashCode(this.memo);
        hash = 41 * hash + Objects.hashCode(this.sender);
        hash = 41 * hash + Objects.hashCode(this.recipient);
        return hash;
    }
    
    public String getMemo() {return memo;}
    public void setMemo(String memo) {this.memo = memo;}
    
    public String getSender() {return sender;}
    public void setSender(String sender) {this.sender = sender;}
    
    public String getRecipient() {return recipient;}
    public void setRecipent(String recipient) {this.recipient = recipient;}
    
}
