package cryptocomclient;

import RemoteObject.Message;
import RemoteObject.CryptoComManager;
import RemoteObject.CryptoComManagerImpl;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
        
        ArrayList<Message> testArrayList = new ArrayList<>();
        testArrayList.add(new Message("Hello sir!", "Adam", "Bob"));
        testArrayList.add(new Message("Hello dude!", "Adam", "Bob"));
        testArrayList.add(new Message("Hello man!", "Adam", "Bob"));
        
        CryptoComClient ccc = new CryptoComClient();
        
        Message expected = testArrayList.get(2);
        ccc.setReceivedMessageList(testArrayList);
        Message actual = ccc.openMessage(2);
        
        assertEquals(expected, actual);
    }

    /**
     * Test of sendMessage method, of class CryptoComClient.
     */
    @Test
    public void testSendMessage() throws Exception {
        
        CryptoComManager ccm = new CryptoComManagerImpl();
        CryptoComClient ccc = new CryptoComClient(ccm);
        
        Message expected = new Message("Hello Sir!", "Adam", "Bob");
        
        ccc.sendMessage(expected);
        ccc.setUserName("Bob");
        ccc.getReceivedMessages();
        Message actual = ccc.openMessage(0);
        
        assertEquals(expected, actual);
        
        
    }

    /**
     * Test of getReceivedMessages method, of class CryptoComClient.
     */
    @Test
    public void testGetReceivedMessages() throws Exception {
        
        CryptoComManager ccm = new CryptoComManagerImpl();
        CryptoComClient ccc = new CryptoComClient(ccm);
        
        ArrayList<Message> testArrayList = new ArrayList<>();
        testArrayList.add(new Message("Hello sir!", "Adam", "Bob"));
        testArrayList.add(new Message("Hello dude!", "Adam", "Bob"));
        testArrayList.add(new Message("Hello man!", "Adam", "Bob"));
        
        ccc.setUserName("Bob");
        
        ArrayList<Message> expected = testArrayList;
        
        for(Message message: testArrayList) {
            ccc.sendMessage(message);
        }
        
        ccc.getReceivedMessages();
        
        ArrayList<Message> actual = ccc.getRecievedMessageList();
        
        assertEquals(expected, actual);
        
        
        
    }

    /**
     * Test of removeReceivedMessage method, of class CryptoComClient.
     */
    @Test
    public void testRemoveReceivedMessage() {
        
        CryptoComClient ccc = new CryptoComClient();
        
        ArrayList<Message> testList = new ArrayList<>();
        Message testMessage = new Message("hello", "bob", "Adam");
        testList.add(testMessage);
        
        ccc.setReceivedMessageList(testList);
        ccc.removeReceivedMessage(testMessage);
        
        Message expected = null;
        Message actual = ccc.openMessage(0);
        
        assertEquals(expected, actual);
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
