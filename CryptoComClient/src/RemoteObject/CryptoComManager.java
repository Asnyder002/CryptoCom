package RemoteObject;

import java.rmi.*;
import java.util.ArrayList;
import java.util.List;

public interface CryptoComManager extends Remote{
    
    public final static String LOOKUPNAME = "CryptoComManager";
    public void sendMessageToServer(Message message) throws RemoteException;
    public List<Message> receiveMessagesFromServer(String userName) throws RemoteException;
    public void addNewUser(User user);
    public boolean usernameTaken(String username);
    public User getUser(String username);
}
