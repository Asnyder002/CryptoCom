/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import cryptocomclient.CryptoComClient;

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
        
    }
    
    public void displayCertainMessage(int number){
        
    }
    
    public void send(){
        String message = clientView.getMessageText();
        String recipient = clientView.getRecipientText();
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
