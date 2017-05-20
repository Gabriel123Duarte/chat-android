package duarte.gabriel.chat;

/**
 * Created by gabriel on 20/05/17.
 */

public class Message {
    private User sender;
    private User receiver;
    private String text;
    private String photoUrl;

    public Message() {
    }

    public Message(User sender, User receiver, String text, String photoUrl) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.photoUrl = photoUrl;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
