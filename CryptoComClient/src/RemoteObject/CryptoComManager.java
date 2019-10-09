package RemoteObject;

import cryptocomclient.Message;
import java.rmi.*;
import java.util.ArrayList;

public interface CryptoComManager extends Remote{
    
    public final static String LOOKUPNAME = "CryptoComManager";
    public void sendMessageToServer(Message message) throws RemoteException;
    public ArrayList<Message> receiveMessagesFromServer(String userName) throws RemoteException;
}
