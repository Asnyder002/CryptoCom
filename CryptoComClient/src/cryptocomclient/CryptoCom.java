package cryptocomclient;

import RemoteObject.CryptoComManager;
import clientUI.clientGui;
import clientUI.ClientPresenter;
import clientUI.LoginPresenter;
import clientUI.loginGui;
import Login.LoginModel;
import java.rmi.*;


public class CryptoCom {
    
    
    public static void main(String[] args) throws RemoteException{
        
        // Gets the remote object reference from RemoteObjectConnection
        RemoteObjectConnection netConn = new RemoteObjectConnection();
        CryptoComManager ccm = netConn.getCCM();
        
        // Passes the remote object into the client and login for use
        CryptoComClient client = new CryptoComClient(ccm);
        LoginModel loginModel = new LoginModel(ccm);
        
        // Creates the form for client and login
        clientGui clientGui = new clientGui();
        loginGui loginGui = new loginGui();
        
        // Presenter creations and injetions
        ClientPresenter presenter = new ClientPresenter(client, clientGui );
        LoginPresenter lPresenter = new LoginPresenter(client, loginModel, loginGui);
        clientGui.setPresenter(presenter);
        loginGui.setPresenter(lPresenter);
        lPresenter.setClientPresenter(presenter);
        
        loginGui.setVisibility(true);
        System.out.println("All systems good to go!");
        
    }
    
}
