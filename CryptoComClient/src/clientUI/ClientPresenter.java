/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import cryptocomclient.CryptoComClient;
import cryptocomclient.Message;
import java.rmi.RemoteException;
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
    
    public void displayListOfUnreadMessages() {
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
    }
    
    // Calls clientView.getLoginText() to get the username in the textfield
    // then calls the clients setUserName() to take that text and set it to the
    // client
    public void login() {
        String input = loginView.getLoginText();
        if (input.trim().length() > 0) {
        clientModel.setUserName(input);    
        loginView.setVisibility();
        clientView.setVisibility();
        clientView.setLoginText(clientModel.getUserName());        
        }
        else {
            javax.swing.JOptionPane.showMessageDialog(null, "Please ensure username field is populated", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void clear() {
        clientView.setMessageText("");
        clientView.getJTable().setValueAt("Test", 0, 0);
        
    }
    
    
}
