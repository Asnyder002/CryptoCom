/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import RemoteObject.CryptoComManager;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import cryptocomclient.CryptoComClient;
import cryptocomclient.Message;
import java.rmi.RemoteException;

import cryptocomclient.CryptoCom;
import cryptocomclient.RemoteObjectConnection;


/**
 *
 * @author codbo
 */
public class ClientPresentertest {
    
    public ClientPresentertest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testDisplayListOfUnreadMessages() {
        
        
        
        
        CryptoComClient client = new CryptoComClient();
        
        LoginGui loginGui = new LoginGui();
        clientGui clientGui = new clientGui();
        
        
        ClientPresenter presenter = new ClientPresenter(client, clientGui, loginGui);
        clientGui.setPresenter(presenter);
        
        Message testMessage = new Message("Hello there!","Alex","Joe");
        client.getRecievedMessageList().add(testMessage);
        presenter.displayListOfUnreadMessages();
        String name = (String) presenter.clientView.getJTable().getValueAt(0,0);
        
        assertEquals(testMessage.getSender(),name);
        
    }

    @Test
    public void testDisplayCertainMessage() {
        CryptoComClient client = new CryptoComClient();
        
        LoginGui loginGui = new LoginGui();
        clientGui clientGui = new clientGui();
        
        
        ClientPresenter presenter = new ClientPresenter(client, clientGui, loginGui);
        clientGui.setPresenter(presenter);
        
        Message testMessage = new Message("Hello there!","Alex","Joe");
        client.getRecievedMessageList().add(testMessage);
        presenter.displayCertainMessage(0);
        String memo = presenter.clientView.getMessageText();
        assertEquals(testMessage.getMemo(),memo);
    }

    @Test
    public void testSend() throws Exception {
    }

    @Test
    public void testLogin() {
        CryptoComClient client = new CryptoComClient();
        
        LoginGui loginGui = new LoginGui();
        clientGui clientGui = new clientGui();
        
        
        ClientPresenter presenter = new ClientPresenter(client, clientGui, loginGui);
        clientGui.setPresenter(presenter);
        
        presenter.loginView.setLoginText("Alex");
        presenter.login();
        String username = presenter.clientView.getLoginLabelText();
        assertEquals(("Currently logged in as:" + "Alex"),username);
        
    }

    @Test
    public void testClear() {
        CryptoComClient client = new CryptoComClient();
        
        LoginGui loginGui = new LoginGui();
        clientGui clientGui = new clientGui();
        
        
        ClientPresenter presenter = new ClientPresenter(client, clientGui, loginGui);
        clientGui.setPresenter(presenter);
        
        presenter.clientView.setMessageText("Lorem ipsum");
        presenter.clear();
        String memo = presenter.clientView.getMessageText();
        assertEquals("", memo);
    }
    
}
