import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TwitterBean implements TwitterAppRemoteService {

    //messages store list
    private List<Message> messages;

    // users store list
    private List<User> users;

    public TwitterBean() {
        this.messages = new ArrayList<Message>();
        this.users = new ArrayList<User>();
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    // user - follower adds another user to follow - following
    public void addFollower(String follower, String following) {
        for (User u : users) {
            System.out.println("iterating: " + u.getName() + " : " + following);
            if (u.getName().equals(follower)) {
                for (String f : u.getFollowers()) {

                    if (f.equals(following)) {
                        System.out.println("ENDDDDD");
                        return;
                    }
                }
                System.out.println("adding follower!!!!!!!!");
                getUser(follower).addFollower(following);
            }
        }
    }

    //getting user by user name
    public User getUser(String userName) {
        for (User u : users) {
            if (u.getName().equals(userName)) {
                return u;
            }

        }
        return null;
    }

    //adding messages up to 140 chars
    public void addMessage(Message m) {
        if (m.getContent().length() <= 140) {
            this.messages.add(m);
        }
    }

    public void addUser(User u) {
        this.users.add(u);
    }

    public List<User> getUsers() {
        return users;
    }

    //get user followers messages
    public List<Message> getUserFollowersMessages(String userName) {
        List<Message> followerMessages = new ArrayList<Message>();

        if (getUser(userName) != null) {
            for (Message message : messages) {
                for (String u : getUser(userName).getFollowers()) {
                    if (message.getUserName().equals(u)) {
                        followerMessages.add(message);
                    }
                }
            }
        }

        return followerMessages;
    }

}
