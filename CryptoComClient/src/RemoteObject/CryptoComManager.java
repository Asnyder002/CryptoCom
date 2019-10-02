package RemoteObject;

import java.rmi.*;

public interface CryptoComManager extends Remote{
    
    public final static String LOOKUPNAME = "CryptoComManager";
    public void sendString(String message) throws RemoteException;
    public String receiveString() throws RemoteException;
}
