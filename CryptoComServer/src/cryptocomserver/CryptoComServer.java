package cryptocomserver;

import java.rmi.*;
import RemoteObject.*;
import java.rmi.registry.LocateRegistry;

public class CryptoComServer {
    
    public static void main(String[] args) throws RemoteException {
        
        System.out.println("CryptoComServer starting...");
        
        System.out.println("Creating Registry...");
        
        // Creates and exports a Registry instance on the local host that
        // accepts request on port 1099
        LocateRegistry.createRegistry(1099);
        System.out.println("Registry created.");
        
        //System.setSecurityManager(new SecurityManager());
        //System.out.println("Security Manager installed, Setting up service");
        
        try {
            // Creates instance of CryptoComManagerImpl object
            CryptoComManagerImpl ccm = new CryptoComManagerImpl();
            System.out.println("Publishing CryptoComServer...");
            
            // Binds the object to the registry using the LOOKUPNAME
            Naming.rebind(CryptoComManager.LOOKUPNAME, ccm);
            
            System.out.println("CryptoComServer ready.");
        }
        catch (Exception e) {
            System.err.println(e);
            System.exit(1);
            
        }
        
    }
    
}
