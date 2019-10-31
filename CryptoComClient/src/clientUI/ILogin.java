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
public interface ILogin {
    String getUserNameText();
    String getPasswordText();
    void setVisibility(boolean setVis);
    void setUserNameText(String userName);
    void setPasswordText(String password);
}
