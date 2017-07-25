import com.google.gson.Gson;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/")
public class TwitterRestService {

    private static final Logger LOGGER = Logger.getLogger(TwitterRestService.class);

    @EJB
    TwitterAppRemoteService twitterBean;

    // rest method to add messages
    @POST
    @Path("/post-message")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postMessage(MessageBody messageBody) {

        LOGGER.info("POST json with post");
        LOGGER.info(twitterBean.getMessages().size());
        LOGGER.info(messageBody.userName);
        LOGGER.info(messageBody.content);
        LOGGER.info(messageBody.date);
        LOGGER.info(messageBody.hour);

        if (messageBody.userName == "") {
            String randomUsername = UUID.randomUUID().toString().substring(0, 8);
            this.twitterBean.addUser(new User(randomUsername));
            this.twitterBean.addMessage(new Message(messageBody.content, randomUsername, messageBody.date, messageBody.hour));
            LOGGER.info(twitterBean.getUsers().size());
            LOGGER.info(randomUsername);

            return randomUsername;
        } else {
            this.twitterBean.addMessage(new Message(messageBody.content, messageBody.userName, messageBody.date, messageBody.hour));
            LOGGER.info(twitterBean.getUsers().size());
            LOGGER.info(messageBody.userName);
        }

        return "";
    }

    // rest method to add follower by user
    @POST
    @Path("/add-follower")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addFollower(FollowBody followBody) {
        LOGGER.info("POST json with follower");
        LOGGER.info(followBody.follower);
        LOGGER.info(followBody.following);

        LOGGER.info("followers of: " + followBody.follower);
        twitterBean.addFollower(followBody.follower, followBody.following);
        if (twitterBean.getUser(followBody.follower).getFollowers() != null)
            LOGGER.info(twitterBean.getUser(followBody.follower).getFollowers());
    }

    // rest method to get all messages for wall
    @GET
    @Path("/messages")
    @Produces({"application/json"})
    public String getMessages() {
        Gson gson = new Gson();

        String json = gson.toJson(twitterBean.getMessages());
        return json;
    }

    // rest method to get messages for timeline - user followers
    @GET
    @Path("/follower-messages/{user}")
    @Produces({"application/json"})
    public String getFollowerMessages(@PathParam("user") String user) {
        Gson gson = new Gson();
        String json = gson.toJson(twitterBean.getUserFollowersMessages(user));

        return json;
    }

}