
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface TwitterAppRemoteService {
    //adding messages
    void addMessage(Message m);

    List getMessages();

    // user - follower adds another user to follow - following
    void addFollower(String follower, String following);

    //getting user by user name
    void addUser(User user);

    List getUsers();

    User getUser(String user);

    //get user followers messages
    List<Message> getUserFollowersMessages(String userName);
}
