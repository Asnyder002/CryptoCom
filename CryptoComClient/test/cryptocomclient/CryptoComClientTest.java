package cryptocomclient;

import RemoteObject.CryptoComManager;
import RemoteObject.CryptoComManagerImpl;
import java.rmi.RemoteException;
import org.junit.Test;
import static org.junit.Assert.*;

public class CryptoComClientTest {
    
    public CryptoComClientTest() {
    }

    /**
     * Test of createNewMessage method, of class CryptoComClient.
     */
    @Test
    public void testCreateNewMessage() throws RemoteException {
        
        CryptoComManager ccm = new CryptoComManagerImpl();
        CryptoComClient ccc = new CryptoComClient(ccm);
        
        Message expected = new Message("Hello sir!", "Adam", "Bob");
        Message actual = ccc.createNewMessage("Hello sir!", "Adam", "Bob");
        
        assertEquals(expected, actual);
        
    }

    /**
     * Test of openMessage method, of class CryptoComClient.
     */
    @Test
    public void testOpenMessage() {
    }

    /**
     * Test of sendMessage method, of class CryptoComClient.
     */
    @Test
    public void testSendMessage() throws Exception {
    }

    /**
     * Test of getReceivedMessages method, of class CryptoComClient.
     */
    @Test
    public void testGetReceivedMessages() throws Exception {
    }

    /**
     * Test of removeReceivedMessage method, of class CryptoComClient.
     */
    @Test
    public void testRemoveReceivedMessage() {
    }

    /**
     * Test of getRecievedMessageList method, of class CryptoComClient.
     */
    @Test
    public void testGetRecievedMessageList() {
    }

    /**
     * Test of getUserName method, of class CryptoComClient.
     */
    @Test
    public void testGetUserName() {
    }

    /**
     * Test of setUserName method, of class CryptoComClient.
     */
    @Test
    public void testSetUserName() {
    }

    /**
     * Test of getCCM method, of class CryptoComClient.
     */
    @Test
    public void testGetCCM() {
    }

    /**
     * Test of setCCM method, of class CryptoComClient.
     */
    @Test
    public void testSetCCM() {
    }
    
}
