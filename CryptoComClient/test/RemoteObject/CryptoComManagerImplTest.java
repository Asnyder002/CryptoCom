package RemoteObject;

import cryptocomclient.Message;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class CryptoComManagerImplTest {
    
    public CryptoComManagerImplTest() {
    }

    /**
     * Test of sendMessageToServer method, of class CryptoComManagerImpl.
     */
    @Test
    public void testSendMessageToServer() throws Exception {
        
        // Creates ccmImpl accesed by interface
        // New message created and passed to the ccm method
        CryptoComManager ccm = new CryptoComManagerImpl();
        Message message = new Message("Testing", "Adam", "Bob");
        ccm.sendMessageToServer(message);
        
        // cast from interface to impl object for gethashmap use
        // get hashmap, get arraylist, get message
        CryptoComManagerImpl ccmImpl = (CryptoComManagerImpl)ccm;
        HashMap<String, ArrayList<Message>> hashMap = ccmImpl.getHashMap();
        ArrayList<Message> messageList = hashMap.get("Bob");
        
        Message expected = message;
        Message actual = messageList.get(0);
        
        assertEquals(expected, actual);
    }

    /**
     * Test of receiveMessagesFromServer method, of class CryptoComManagerImpl.
     */
    @Test
    public void testReceiveMessagesFromServer() throws Exception {
        
        
        
    }
    
}
