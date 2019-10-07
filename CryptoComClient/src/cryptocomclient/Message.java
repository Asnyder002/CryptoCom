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
    
}
