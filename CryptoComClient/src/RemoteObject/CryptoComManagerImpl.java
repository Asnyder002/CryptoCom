package RemoteObject;

import cryptocomclient.Message;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class CryptoComManagerImpl extends UnicastRemoteObject implements CryptoComManager{

    HashMap<String, ArrayList<Message>> messageMap = new HashMap<>();
    
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
    public ArrayList<Message> receiveMessagesFromServer() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
}
