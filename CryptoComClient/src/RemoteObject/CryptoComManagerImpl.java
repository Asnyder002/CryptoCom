package RemoteObject;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptoComManagerImpl extends UnicastRemoteObject implements CryptoComManager{

    private Map<String, List<Message>> messageMap = new HashMap<>();
    private Map<String, User> userMap = new HashMap<>();
    
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
        List<Message> recipientArrayList = messageMap.get(message.getRecipient());
        recipientArrayList.add(message);
    }

    @Override
    public List<Message> receiveMessagesFromServer(String userName) throws RemoteException {
        if(messageMap.containsKey(userName)) {
            List<Message> arrayListToSendBack = messageMap.get(userName);
            messageMap.remove(userName);
            return arrayListToSendBack;
        }
        return new ArrayList<Message>();
        
    }
    
    @Override
    public void addNewUser(User newUser) throws RemoteException{
        userMap.put(newUser.getUsername(), newUser);
    }
    
    @Override
    public User getUser(String username) throws RemoteException{
        return userMap.get(username);
    }
    
    @Override
    public boolean usernameTaken(String username) throws RemoteException{
        return userMap.containsKey(username);
    }
    
    public Map<String, List<Message>> getHashMap() {return messageMap;}
    
}
