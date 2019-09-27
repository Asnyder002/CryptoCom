package RemoteObject;

import java.rmi.*;

public interface CryptoComManager extends Remote{
    
    public void sendString(String message) throws RemoteException;
    public String receiveString() throws RemoteException;
}
