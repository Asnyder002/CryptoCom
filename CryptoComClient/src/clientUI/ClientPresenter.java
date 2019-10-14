/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

/**
 *
 * @author codbo
 */
public class ClientPresenter {
    clientGUI myUI = new clientGUI(this);
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
        String message = myUI.getMessageText();
        String recipient = myUI.getRecipientText();
    }
    
    public void login() {
        String input;
        input = myUI.getLoginText();
        myUI.setLoginText(input);
    }
    
    public void clear() {
        myUI.setMessageText("");
    }
}
