package cryptocomclient;

public class Message {
    
    String memo,
           sender,
           recipient;
    
    public Message(String memo, String sender, String recipient) {
        this.memo = memo;
        this.sender = sender;
        this.recipient = recipient;
    }
    
    public String getMemo() {return memo;}
    public void setMemo(String memo) {this.memo = memo;}
    
    public String getSender() {return sender;}
    public void setSender(String sender) {this.sender = sender;}
    
    public String getRecipient() {return recipient;}
    public void setRecipent(String recipient) {this.recipient = recipient;}
    
}
