/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import cryptocomclient.CryptoComClient;
import Login.LoginModel;
import RemoteObject.Message;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author codbo
 */
public class LoginPresenter {
    CryptoComClient clientModel;
    LoginModel loginModel;
    ILogin loginView;
    ClientPresenter clientPresenter;
    
    public LoginPresenter (CryptoComClient clientModel, LoginModel loginModel, ILogin loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        this.clientModel = clientModel;
    }

    public void setClientPresenter(ClientPresenter presenter) {
        this.clientPresenter = presenter;
    }
   
    public void setClientVisible() {
        clientPresenter.clientView.setVisibility();
    }
    
    public void clear() {
        loginView.setUserNameText("");
        loginView.setUserNameText("");
    }
    
    public void loginButtonClicked() throws RemoteException {
        loginModel.setUsername(loginView.getUserNameText());
        loginModel.setPassword(loginView.getPasswordText());
        try {
            if (loginModel.validateCredentials()) {
                setClientVisible();
                clientModel.setUserName(loginView.getUserNameText());
                clientPresenter.clientView.setLoginText(loginModel.getUsername());
                loginView.setVisibility(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid username/password");
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(LoginPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void signUpButtonClicked() throws RemoteException, IOException {
    loginModel.setUsername(loginView.getUserNameText());
    loginModel.setPassword(loginView.getPasswordText());
        try {
            if (loginModel.createNewUser()) {
                clientModel.setUserName(loginView.getUserNameText());
                clientPresenter.clientView.setLoginText(loginModel.getUsername());
                setClientVisible();
                loginView.setVisibility(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Username unavailable");
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(LoginPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
