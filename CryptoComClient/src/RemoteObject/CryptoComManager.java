package RemoteObject;

import cryptocomclient.Message;
import java.rmi.*;

public interface CryptoComManager extends Remote{
    
    public final static String LOOKUPNAME = "CryptoComManager";
    public void sendMessageToServer(Message message) throws RemoteException;
    public Message receiveMessagesFromServer() throws RemoteException;
}
