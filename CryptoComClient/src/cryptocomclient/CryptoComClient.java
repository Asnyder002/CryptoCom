package cryptocomclient;

import RemoteObject.CryptoComManager;
import RemoteObject.CryptoComManagerImpl;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class CryptoComClient {
    
    protected static CryptoComManager netConn = null;
    
    private static clientGUI gui;
    public static void main(String[] args) {
        
        gui = new clientGUI();
        gui.pack();
        gui.setVisible(true);
        
        
        
        try {
            System.out.println("CryptoComClient starting look up...");
            netConn = (CryptoComManager)Naming.lookup(CryptoComManager.LOOKUPNAME);
            netConn.sendString("TEST STRING");
            String test = netConn.receiveString();
            System.out.println("Recieved from remote object: " + test);
        }
        catch (Exception e) {
            System.err.println("CrytpoComCilent: CryptoComManager exception: " + e.getMessage());
        }
        
    }
    
}
