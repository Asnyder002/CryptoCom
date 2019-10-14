/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import cryptocomclient.CryptoComClient;
import cryptocomclient.Message;
import java.rmi.RemoteException;

/**
 *
 * @author codbo
 */
public class ClientPresenter {
    CryptoComClient clientModel;
    IClient clientView;
    
    public ClientPresenter(CryptoComClient clientModel, IClient clientView) {
        this.clientView = clientView;
        this.clientModel = clientModel;
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
        clientModel.setUserName(clientView.getLoginText());
    }
    
    public void clear() {
        myUI.setMessageText("");
    }
}
