package RemoteObject;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CryptoComManagerImpl extends UnicastRemoteObject implements CryptoComManager{

    ArrayList<String> stringList = new ArrayList<>();
    
    public CryptoComManagerImpl() throws RemoteException{
        super();
    }
    
    @Override
    public void sendString(String message) throws RemoteException {
        stringList.add(message);
    }

    @Override
    public String receiveString() throws RemoteException {
        return stringList.remove(0);
    }
    
    
}
