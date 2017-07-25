import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//class for post message json
@XmlRootElement
public class MessageBody {
    @XmlElement
    String userName;
    @XmlElement
    String content;
    @XmlElement
    String date;
    @XmlElement
    String hour;
}
