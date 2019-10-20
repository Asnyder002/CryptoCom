package RemoteObject;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class CryptoComManagerImpl extends UnicastRemoteObject implements CryptoComManager{

    private HashMap<String, ArrayList<Message>> messageMap = new HashMap<>();
    
    public CryptoComManagerImpl() throws RemoteException{
        super();
    }

    @Override
    public void sendMessageToServer(Message message) throws RemoteException {
        
        // Checks to see if the recipient already has an arraylist
        // If it doesn't creates a new arraylist with the recipient as the key
        if(!messageMap.containsKey(message.getRecipient())){
            messageMap.put(message.getRecipient(), new ArrayList<Message>());
        }
        
        // Gets the recipients Arraylist and adds the new message
        ArrayList<Message> recipientArrayList = messageMap.get(message.getRecipient());
        recipientArrayList.add(message);
    }

    @Override
    public ArrayList<Message> receiveMessagesFromServer(String userName) throws RemoteException {
        
        ArrayList<Message> arrayListToSendBack = messageMap.get(userName);
        messageMap.remove(arrayListToSendBack);
        return arrayListToSendBack;
        
    }
    
    public HashMap<String, ArrayList<Message>> getHashMap() {return messageMap;}
    
}
