import java.io.Serializable;

public class Message implements Serializable {
    String content;
    String userName;
    String date;
    String hour;

    public Message(String content, String userName, String date, String hour) {
        this.content = content;
        this.userName = userName;
        this.date = date;
        this.hour = hour;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }

}
