/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientUI;

import java.awt.Color;
import static java.awt.Color.white;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;


/**
 *
 * @author codbo
 */
public class clientGui extends javax.swing.JFrame implements IClient {

    /**
     * Creates new form clientGUI
     */
    public clientGui() {
        this.setUndecorated(true);
        initComponents();
        myInitComponents();
    }
    
    ClientPresenter presenter;
    
    
    
    @Override
    public String getLoginLabelText() {
        return loginStatusLabel.getText();
    }
    @Override
    public void setLoginText(String name){
        this.loginStatusLabel.setText("Currently logged in as: " + name); 
    }
    
    
    @Override
    public String getMessageText() {
        return this.messageTextArea.getText();
    }
    @Override
    public void setMessageText(String message) {
        this.messageTextArea.setText(message);
    }
    @Override
    public JTable getJTable() {
        return this.unreadMessagesTable;
    }
    
    @Override
    public JComboBox getComboBox() {
        return this.UsernameBox;
    }
    
    public void setPresenter(ClientPresenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void setVisibility() {
        this.setVisible(true);
    }
    
    public void myInitComponents() {
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Color background = new Color(34,34,34);
        this.unreadMessagesTable.getTableHeader().setBackground(background);
        this.unreadMessagesTable.getTableHeader().setForeground(white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        unreadMessagesTable = new javax.swing.JTable();
        UsernameBox = new javax.swing.JComboBox<>();
        sendButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        loginStatusLabel = new javax.swing.JLabel();
        displayMessageButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        loginStatusLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(34, 34, 34));

        unreadMessagesTable.setBackground(new java.awt.Color(40, 40, 40));
        unreadMessagesTable.setForeground(new java.awt.Color(0, 215, 0));
        unreadMessagesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        unreadMessagesTable.setColumnSelectionAllowed(true);
        unreadMessagesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        unreadMessagesTable.setFillsViewportHeight(true);
        unreadMessagesTable.setGridColor(new java.awt.Color(0, 215, 0));
        unreadMessagesTable.setName(""); // NOI18N
        unreadMessagesTable.setRowHeight(35);
        unreadMessagesTable.setSelectionForeground(new java.awt.Color(0, 215, 0));
        unreadMessagesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        unreadMessagesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(unreadMessagesTable);
        unreadMessagesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        UsernameBox.setBackground(new java.awt.Color(34, 34, 34));
        UsernameBox.setForeground(new java.awt.Color(0, 215, 0));
        UsernameBox.setBorder(null);
        UsernameBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UsernameBoxFocusGained(evt);
            }
        });

        sendButton.setBackground(new java.awt.Color(0, 215, 0));
        sendButton.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        sendButton.setForeground(new java.awt.Color(34, 34, 34));
        sendButton.setText("Send");
        sendButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendButton.setBorderPainted(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(0, 215, 0));
        clearButton.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(34, 34, 34));
        clearButton.setText("Clear");
        clearButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clearButton.setBorderPainted(false);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        loginStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loginStatusLabel.setForeground(new java.awt.Color(0, 215, 0));
        loginStatusLabel.setText("Not currently logged in.");

        displayMessageButton.setBackground(new java.awt.Color(0, 215, 0));
        displayMessageButton.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        displayMessageButton.setForeground(new java.awt.Color(34, 34, 34));
        displayMessageButton.setText("Display Message");
        displayMessageButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        displayMessageButton.setBorderPainted(false);
        displayMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayMessageButtonActionPerformed(evt);
            }
        });

        refreshButton.setBackground(new java.awt.Color(0, 215, 0));
        refreshButton.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(34, 34, 34));
        refreshButton.setText("Refresh");
        refreshButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refreshButton.setBorderPainted(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        messageTextArea.setBackground(new java.awt.Color(40, 40, 40));
        messageTextArea.setColumns(20);
        messageTextArea.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        messageTextArea.setForeground(new java.awt.Color(204, 255, 255));
        messageTextArea.setRows(5);
        messageTextArea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        messageTextArea.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(messageTextArea);

        jButton1.setBackground(new java.awt.Color(34, 34, 34));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/x-mark-16.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        loginStatusLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        loginStatusLabel1.setForeground(new java.awt.Color(0, 215, 0));
        loginStatusLabel1.setText("Recipient");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UsernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(loginStatusLabel1)))
                                .addGap(45, 45, 45)
                                .addComponent(sendButton)
                                .addGap(34, 34, 34)
                                .addComponent(clearButton))
                            .addComponent(loginStatusLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(displayMessageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(clearButton)
                    .addComponent(displayMessageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginStatusLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginStatusLabel)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsernameBoxFocusGained
        try {
            presenter.populateComboBox();
        } catch (RemoteException ex) {
            Logger.getLogger(clientGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UsernameBoxFocusGained

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        try {
            presenter.send();
        } catch (RemoteException ex) {
            Logger.getLogger(clientGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(clientGui.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_sendButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        presenter.clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void displayMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayMessageButtonActionPerformed
        presenter.displayCertainMessage(unreadMessagesTable.getSelectedRow());
    }//GEN-LAST:event_displayMessageButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        try {
            presenter.displayListOfUnreadMessages();
        } catch (RemoteException ex) {
            Logger.getLogger(clientGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton1MouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(clientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new clientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> UsernameBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton displayMessageButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loginStatusLabel;
    private javax.swing.JLabel loginStatusLabel1;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JTable unreadMessagesTable;
    // End of variables declaration//GEN-END:variables
}
