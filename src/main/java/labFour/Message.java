package labFour;

public class Message {
    public Message(){}
    public Message(String message, int code){
        this.message = message;
        this.code = code;
    }
    private String message;
    private int code;
        // ... getters and setters
    public void setCode(int code) {
        this.code = code;
    }
}
