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
import java.util.List;
import javax.swing.table.DefaultTableModel;

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
    
    public void displayListOfUnreadMessages() throws RemoteException {

        clientModel.getReceivedMessages();
        
        DefaultTableModel model = (DefaultTableModel) clientView.getJTable().getModel();
        
        if(model.getRowCount() > 0) {
            for(int i = model.getRowCount() -1; i > -1; i--) {
                model.removeRow(i);
            }
        }

        Object rowData[] = new Object[1];
        
        for(int i = 0; i < clientModel.getRecievedMessageList().size(); i++) {
            rowData[0] = clientModel.getRecievedMessageList().get(i).getSender();
            model.addRow(rowData);
        }
    }
    
    public void displayCertainMessage(int number){
        DefaultTableModel model = (DefaultTableModel) clientView.getJTable().getModel();
        model.removeRow(number);
        clientView.setMessageText(clientModel.openMessage(number).getMemo());
    }
    
    public void send() throws RemoteException{
        Message message = clientModel.createNewMessage(clientView.getMessageText(),clientModel.getUserName(),clientView.getRecipientText());
        clientModel.sendMessage(message);
        this.clear();
    }
    
    
    
    
    public void clear() {
        clientView.setMessageText("");
        clientView.setRecipientText("");
        
    }
    
}