package RemoteObject;

import java.rmi.*;
import java.util.ArrayList;
import java.util.List;

public interface CryptoComManager extends Remote{
    
    public final static String LOOKUPNAME = "CryptoComManager";
    public void sendMessageToServer(Message message) throws RemoteException;
    public List<Message> receiveMessagesFromServer(String userName) throws RemoteException;
    public void addNewUser(User user) throws RemoteException;
    public boolean usernameTaken(String username) throws RemoteException;
    public User getUser(String username) throws RemoteException;
    public List<String> getListOfUsernames() throws RemoteException;
}
