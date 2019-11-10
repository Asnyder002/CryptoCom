/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import cryptocomclient.CryptoComClient;
import RemoteObject.Message;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
        
        DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
        renderCenter.setHorizontalAlignment(SwingConstants.CENTER);
        clientView.getJTable().getColumnModel().getColumn(0).setCellRenderer(renderCenter); 
        
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
        if(number != -1) {
            DefaultTableModel model = (DefaultTableModel) clientView.getJTable().getModel();
            model.removeRow(number);
            try {
                clientView.setMessageText(clientModel.openMessage(number).getMemo());
            } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(ClientPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void send() throws RemoteException, NoSuchAlgorithmException{
        try {
            Message message = clientModel.createNewMessage(clientView.getMessageText(),clientModel.getUserName(), (String) clientView.getComboBox().getSelectedItem());
            clientModel.sendMessage(message);
            this.clear();
        } catch (InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(ClientPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populateComboBox() throws RemoteException {
        DefaultComboBoxModel model = (DefaultComboBoxModel) clientView.getComboBox().getModel();
        List<String> usernames = clientModel.getListofRegisteredUsers();
        
        model.removeAllElements();
        
        for(int i=0; i < usernames.size(); i++) {
            model.addElement(usernames.get(i));
        }
    }
    
    
    
    
    public void clear() {
        clientView.setMessageText("");
        
        
    }
    
}