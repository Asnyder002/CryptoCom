package RemoteObject;

import java.rmi.*;

public interface CryptoComManager extends Remote{
    
    public void sendString() throws RemoteException;
    public String receiveString() throws RemoteException;
}
