package cryptocomclient;

import Crypto.CryptoAES;
import Crypto.KeyManager;
import Crypto.CryptoRSA;
import Crypto.KeyGeneratorAES;
import RemoteObject.Message;
import RemoteObject.CryptoComManager;
import java.io.IOException;
import java.rmi.RemoteException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class CryptoComClient {
    
    private List<Message> receivedMessageList = new ArrayList<>();
    private String userName;
    private CryptoComManager ccm;
    
    // Constructor that takes in a reference to the remote object.
    public CryptoComClient(CryptoComManager ccm) {
        this.ccm = ccm;
    }
    //Constructor that takes no remote object reference (for testing)
    public CryptoComClient(){
        
    }
    
    // Creates a new instance of Message and returns it.
    public Message createNewMessage(String memo, String sender, String recipient) throws RemoteException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        
        // Gets the encoded key and creates a public key from it.
        byte[] encodedPublicKey = ccm.getUser(recipient).getEncodedPublicKey();
        PublicKey publicKey = KeyManager.getPublicKeyFromBytes(encodedPublicKey);
        
        // Creates a secretKey
        SecretKey secretKey = KeyGeneratorAES.generateSecretKey();
        
        // Encrypt memo with the secret key
        byte[] encryptedMemo = CryptoAES.encrypt(memo, secretKey);
        
        // Encrypt the secret key with the public key
        byte[] encryptedSecretKey = CryptoRSA.encryptKey(secretKey, publicKey);
        
        // Attach encryptedSecretKey to message
        return new Message(encryptedMemo, sender, recipient, encryptedSecretKey);
        
    }
    
    // Returns a message from the recived arrayList at the specified index.
    public Message openMessage(int index) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        
        if (receivedMessageList.size() == 0) {
            return null;
        }
        
        Message openMessage = receivedMessageList.get(index);
        receivedMessageList.remove(index);
        
        // Get encrypted memo and secret key
        byte[] encryptedMemo = openMessage.getEncryptedMemo();
        byte[] encryptedSecretKey = openMessage.getEncrytpedSecretKey();
        
        // Get private key to decrypt the secret key
        PrivateKey privateKey = KeyManager.getPrivateKeyFromFile("RSA/privateKey");
        
        // Decrypt the secret key using your own private key.
        SecretKey decryptedSecretKey = CryptoRSA.decryptKey(encryptedSecretKey, privateKey);
        
        // Decrypt the memo using the secret key.
        String memo = CryptoAES.decrypt(encryptedMemo, decryptedSecretKey);
        
        openMessage.setMemo(memo);
        
        return openMessage;
        
    }
    
    // Takes in a message and sends the message to the remote object
    public void sendMessage(Message message) throws RemoteException {
        
        ccm.sendMessageToServer(message);
        
    }
    
    
    // Calls the remote object to get the stored messages then adds them to the
    // clients receivedMessageList
    public void getReceivedMessages() throws RemoteException {
        
        List<Message> receivedList = ccm.receiveMessagesFromServer(userName);
        
        for(Message message: receivedList) {
            receivedMessageList.add(message);
        }
        System.out.println("RECEIVED MESSAGE SIZE:" + receivedMessageList.size());
      
    }
    
    // Removes a message from the received message arrayList
    public void removeReceivedMessage(int i) {
        
        receivedMessageList.remove(i);
        
    }
    
    public List<String> getListofRegisteredUsers() throws RemoteException {
        return ccm.getListOfUsernames();
    }
    
    
    
    // Getters and setters for fields listed at the top
    public List<Message> getRecievedMessageList() {return receivedMessageList;}
    public void setReceivedMessageList(List<Message> recievedMessageList) {this.receivedMessageList = recievedMessageList;} 
    
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    
    public CryptoComManager getCCM() {return ccm;}
    public void setCCM(CryptoComManager ccm) {this.ccm = ccm;}
    
}
