package cryptocomclient;

import RemoteObject.CryptoComManager;
import java.rmi.RemoteException;
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
        //Encryption should be done here
        
        
        return new Message(memo, sender, recipient);
        
    }
    
    // Returns a message from the recived arrayList at the specified index.
    public Message openMessage(int index) {
        
        return receivedMessageList.get(index);
        
    }
    
    // Takes in a message and sends the message to the remote object
    public void sendMessage(Message message) throws RemoteException {
        
        ccm.sendMessageToServer(message);
        
    }
    
    // Calls the remote object to get the stored messages then adds them to the
    // clients receivedMessageList
    public void getReceivedMessages() throws RemoteException {
        
        ArrayList<Message> receivedList = ccm.receiveMessagesFromServer(userName);
        
        for(Message message: receivedList) {
            receivedMessageList.add(message);
        }
      
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
