package cryptocomclient;

import RemoteObject.CryptoComManager;
import clientUI.ClientGui;
import clientUI.ClientPresenter;
import java.rmi.*;

public class CryptoCom {
    
    
    public static void main(String[] args) {
        
        // Gets the remote object reference from RemoteObjectConnection
        RemoteObjectConnection netConn = new RemoteObjectConnection();
        CryptoComManager ccm = netConn.getCCM();
        
        // Passes the remote object into the client for use
        CryptoComClient client = new CryptoComClient(ccm);
        

        ClientGui clientGui = new ClientGui();
        ClientPresenter presenter = new ClientPresenter(client, clientGui);
        clientGui.setPresenter(presenter);
        clientGui.setVisible(true);
        

        
        
    }
    
}
