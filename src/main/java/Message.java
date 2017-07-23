/**
 * Created by admin on 23.07.2017.
 */
public class Message {
    String content;
    String userName;

    public Message(String content, String userName) {
        this.content = content;
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
