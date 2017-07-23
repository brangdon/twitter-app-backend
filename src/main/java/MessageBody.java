import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageBody {
    @XmlElement
    String hello;
    @XmlElement String foo;
    @XmlElement Integer count;
}
