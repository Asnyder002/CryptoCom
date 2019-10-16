package cryptocomclient;

import RemoteObject.CryptoComManager;
import clientUI.ClientGui;
import clientUI.ClientPresenter;
import clientUI.LoginGui;
import java.rmi.*;

public class CryptoCom {
    
    public static void main(String[] args) {
        
        // Gets the remote object reference from RemoteObjectConnection
        RemoteObjectConnection netConn = new RemoteObjectConnection();
        CryptoComManager ccm = netConn.getCCM();
        
        // Passes the remote object into the client for use
        CryptoComClient client = new CryptoComClient(ccm);
        
        LoginGui loginGui = new LoginGui();
        loginGui.setVisible(true);
        ClientGui clientGui = new ClientGui();
        
        
        ClientPresenter presenter = new ClientPresenter(client, clientGui, loginGui);
        clientGui.setPresenter(presenter);
        loginGui.setPresenter(presenter);
        

        
        
    }
    
}
