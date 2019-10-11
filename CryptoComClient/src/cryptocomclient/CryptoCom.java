package cryptocomclient;

import RemoteObject.CryptoComManager;
import java.rmi.*;

public class CryptoCom {
    
    public static void main(String[] args) {
        
        // Gets the remote object reference from RemoteObjectConnection
        RemoteObjectConnection netConn = new RemoteObjectConnection();
        CryptoComManager ccm = netConn.getCCM();
        
        // Passes the remote object into the client for use
        CryptoComClient client = new CryptoComClient(ccm);
        
        // Create the presenter and pass in the client
        
        // Create the GUI form and pass in the presenter
        
    }
    
}
