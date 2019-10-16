/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import javax.swing.JTable;

/**
 *
 * @author codbo
 */
public interface IClient {
    String getLoginText();
    String getLoginLabelText();
    void setVisibility();
    void setLoginText(String name);
    String getRecipientText();
    void setRecipientText(String name);
    String getMessageText();
    void setMessageText(String message); 
    JTable getJTable();
}
