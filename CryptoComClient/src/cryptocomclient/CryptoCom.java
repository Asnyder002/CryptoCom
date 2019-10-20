package cryptocomclient;

import RemoteObject.CryptoComManager;
import clientUI.clientGui;
import clientUI.ClientPresenter;
import clientUI.LoginGui;
import java.rmi.*;
import java.util.ArrayList;

public class CryptoCom {
    
    
    public static void main(String[] args) throws RemoteException {
        
        // Gets the remote object reference from RemoteObjectConnection
        RemoteObjectConnection netConn = new RemoteObjectConnection();
        CryptoComManager ccm = netConn.getCCM();
        
        // Passes the remote object into the client for use
        CryptoComClient client = new CryptoComClient(ccm);
        
        LoginGui loginGui = new LoginGui();
        loginGui.setVisible(true);
        clientGui clientGui = new clientGui();
        
        
        ClientPresenter presenter = new ClientPresenter(client, clientGui, loginGui);
        clientGui.setPresenter(presenter);
        loginGui.setPresenter(presenter);
        System.out.println("All systems good to go!");
        
        
        // Testing - Works
        System.out.println("Sending Test String...");
        ccm.sendTestString("TEST STRING!!!!");
        System.out.println("Test String Sent.");
        System.out.println("Getting Test String...");
        String string = ccm.getTestString();
        System.out.println("Got Test String!");
        System.out.println(string);
        
        // Different Test - Doesn't Work
        ccm.sendMessageToServer(new Message("MESSAGE TEST!!", "Adam", "Bob"));
        ArrayList<Message> testArrayList = ccm.receiveMessagesFromServer("Bob");
        System.out.println(testArrayList.get(0).memo);

        

        
        
    }
    
}
