import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String name;
    private List<String> followers;

    public User(String name) {
        this.name = name;
        followers = new ArrayList<String>();
    }

    // users adds follower
    public void addFollower(String user) {
        for (String f : followers) {
            if (f.equals(user) || user.equals(name)) {
                return;
            }

        }
        this.followers.add(user);
    }

    public String getName() {
        return name;
    }

    public List<String> getFollowers() {
        return followers;
    }
}
