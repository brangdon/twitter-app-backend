import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// class for post json user to follow
@XmlRootElement
public class FollowBody {
    @XmlElement
    String follower;
    @XmlElement
    String following;
}
