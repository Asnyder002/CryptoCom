package cryptocomclient;

import RemoteObject.CryptoComManager;
import java.rmi.*;

public class CryptoCom {
    
    protected static CryptoComManager netConn = null;
    
    public static void main(String[] args) {
        
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
