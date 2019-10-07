package cryptocomclient;

import RemoteObject.CryptoComManager;
import java.util.ArrayList;

public class CryptoComClient {
    
    ArrayList<Message> receivedMessageList = new ArrayList<>();
    String userName;
    CryptoComManager ccm;
    
    // Constructor that takes in a reference to the remote object.
    public CryptoComClient(CryptoComManager ccm) {
        this.ccm = ccm;
    }
    
    // Creates a new instance of Message and returns it.
    public Message createNewMessage(String memo, String sender, String recipient) {
        
        return new Message(memo, sender, recipient);
        
    }
    
    // Returns a message from the recived arrayList at the specified index.
    public Message openMessage(int num) {
        
        return receivedMessageList.get(num);
        
    }
    
    // Adds a message to the received message arrayList
    public void addReceivedMessage(Message message) {
        
        receivedMessageList.add(message);
        
    }
    
    // Removes a message from the received message arrayList
    public void removeReceivedMessage(Message message) {
        
        receivedMessageList.remove(message);
        
    }
    
    
    // Getters and setters for fields listed at the top
    public ArrayList<Message> getRecievedMessageList() {return receivedMessageList;}
    
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    
    public CryptoComManager getCCM() {return ccm;}
    public void setCCM(CryptoComManager ccm) {this.ccm = ccm;}
    
}
