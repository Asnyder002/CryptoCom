package cryptocomserver;

import java.rmi.*;
import RemoteObject.*;

public class CryptoComServer {
    
    public static void main(String[] args) {
        
        System.out.println("CryptoComServer starting...");
        System.setSecurityManager(new SecurityManager());
        System.out.println("Security Manager installed, Setting up service");
        
        try {
            CryptoComManagerImpl ccm = new CryptoComManagerImpl();
            
            System.out.println("Publishing CryptoComServer...");
            
            Naming.rebind(CryptoComManager.LOOKUPNAME, ccm);
            
            System.out.println("CryptoComServer ready.");
        }
        catch (Exception e) {
            System.err.println(e);
            System.exit(1);
            
        }
        
    }
    
}
