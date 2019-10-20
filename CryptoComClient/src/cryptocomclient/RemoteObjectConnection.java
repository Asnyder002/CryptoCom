package cryptocomclient;

import RemoteObject.CryptoComManager;
import java.rmi.Naming;

public class RemoteObjectConnection {
    
    CryptoComManager ccm;
    
    RemoteObjectConnection() {
        pullFromRegistry();
    }
    
    // Will be used to pass the ccm to the client during dependancy injections
    // in the main method of the client app.
    public CryptoComManager getCCM() {return ccm;}
    
    // Looks up the name of the object in the registry and sets it's reference
    // to the ccm located here.
    private void pullFromRegistry() {
        try {
            ccm = (CryptoComManager)Naming.lookup(CryptoComManager.LOOKUPNAME);
            System.out.println("Remote object pulled from registry.");
        }
        catch (Exception e) {
            System.err.println("CrytpoComCilent: CryptoComManager exception: " + e.getMessage());
        }
        
    }
    
}
