package cryptocomclient;

import RemoteObject.CryptoComManager;
import java.util.ArrayList;

public class CryptoComClient {
    
    ArrayList<Message> receivedMessageList = new ArrayList<>();
    String userName;
    CryptoComManager ccm;
    
    public CryptoComClient(CryptoComManager ccm) {
        this.ccm = ccm;
    }
    
    public Message createNewMessage(String memo, String sender, String recipient) {
        
        return new Message(memo, sender, recipient);
        
    }
    
    public Message openMessage(int num) {
        
        return receivedMessageList.get(num);
        
    }
    
    public void addReceivedMessage(Message message) {
        
        receivedMessageList.add(message);
        
    }
    
    public void removeRecivedMessage() {
        
    }
    
    public ArrayList<Message> getRecievedMessageList() {return receivedMessageList;}
    
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    
    public CryptoComManager getCCM() {return ccm;}
    public void setCCM(CryptoComManager ccm) {this.ccm = ccm;}
    
}
