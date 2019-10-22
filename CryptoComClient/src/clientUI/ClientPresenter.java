<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import cryptocomclient.CryptoComClient;
import RemoteObject.Message;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author codbo
 */
public class ClientPresenter {
    CryptoComClient clientModel;
    IClient clientView;
    LClient loginView;
    
    public ClientPresenter(CryptoComClient clientModel, IClient clientView, LClient loginView) {
        this.clientView = clientView;
        this.clientModel = clientModel;
        this.loginView = loginView;
        
    }
    
    public void displayListOfUnreadMessages() throws RemoteException {
        clientModel.getReceivedMessages();
        
        for (int i = 0; i < clientModel.getRecievedMessageList().size(); i++) {
            clientView.getJTable().setValueAt(clientModel.openMessage(i).getSender(), 0, i);
        }
    }
    
    public void displayCertainMessage(int number){
        clientView.setMessageText(clientModel.openMessage(number).getMemo());
        //clientView.setRecipientText(clientModel.openMessage(number).getSender());
    }
    
    public void send() throws RemoteException{
        Message message = clientModel.createNewMessage(clientView.getMessageText(),clientModel.getUserName(),clientView.getRecipientText());
        clientModel.sendMessage(message);
        this.clear();
    }
    
    // Calls clientView.getLoginText() to get the username in the textfield
    // then calls the clients setUserName() to take that text and set it to the
    // client
    public void login() throws RemoteException {
        String input = loginView.getLoginText();
        if (input.trim().length() > 0) {
        clientModel.setUserName(input);    
        loginView.setVisibility();
        clientView.setVisibility();
        //this.displayListOfUnreadMessages();
        clientView.setLoginText(clientModel.getUserName());        
        }
        else {
            javax.swing.JOptionPane.showMessageDialog(null, "Please ensure username field is populated", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void clear() {
        clientView.setMessageText("");
        clientView.setRecipientText("");
        
    }
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import cryptocomclient.CryptoComClient;
import RemoteObject.Message;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author codbo
 */
public class ClientPresenter {
    CryptoComClient clientModel;
    IClient clientView;
    LClient loginView;
    
    public ClientPresenter(CryptoComClient clientModel, IClient clientView, LClient loginView) {
        this.clientView = clientView;
        this.clientModel = clientModel;
        this.loginView = loginView;
        
    }
    
    public void displayListOfUnreadMessages() throws RemoteException {
        //Message testMessage1 = new Message("test1", "test2", "test3");
        //Message testMessage2 = new Message("test4", "test5", "test6");
        
        //ArrayList<Message> testMessageList = new ArrayList();
        //testMessageList.add(testMessage1);
        //testMessageList.add(testMessage2);
        //clientModel.setReceivedMessageList(testMessageList);
        //System.out.println(clientModel.getRecievedMessageList().get(0).getSender());
        clientModel.getReceivedMessages();
        
        for (int i = 0; i < clientModel.getRecievedMessageList().size(); i++) {
            clientView.getJTable().setValueAt(clientModel.getRecievedMessageList().get(i).getSender(), i, 0);
        }
        
    }
    
    public void displayCertainMessage(int number){
        clientView.setMessageText(clientModel.openMessage(number).getMemo());
        //clientView.setRecipientText(clientModel.openMessage(number).getSender());
    }
    
    public void send() throws RemoteException{
        Message message = clientModel.createNewMessage(clientView.getMessageText(),clientModel.getUserName(),clientView.getRecipientText());
        clientModel.sendMessage(message);
        this.clear();
    }
    
    // Calls clientView.getLoginText() to get the username in the textfield
    // then calls the clients setUserName() to take that text and set it to the
    // client
    public void login() throws RemoteException {
        String input = loginView.getLoginText();
        if (input.trim().length() > 0) {
        clientModel.setUserName(input);    
        loginView.setVisibility();
        clientView.setVisibility();
        this.displayListOfUnreadMessages();
        clientView.setLoginText(clientModel.getUserName());        
        }
        else {
            javax.swing.JOptionPane.showMessageDialog(null, "Please ensure username field is populated", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void clear() {
        clientView.setMessageText("");
        clientView.setRecipientText("");
        
        
    }
    
    
}
>>>>>>> d43d0ab68559cbe3fb65946aff344f7a1af1cb1a
