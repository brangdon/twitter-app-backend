import com.google.gson.Gson;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RestService {
    private static final Logger LOGGER = Logger.getLogger(RestService.class);
    @Inject
    HelloService helloService;

    @GET
    @Path("/json5")
    @Produces({ "application/json" })
    public String getHelloWorldJSON2() {
        return "{\"result\":\"" + helloService.createHelloMessage("World354") + "\"}";
    }


    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
        LOGGER.info("GET json");
        return "{\"result\":\"" + helloService.createHelloMessage("World") + "\"}";
    }
    @GET
    @Path("/xml")
    @Produces({ "application/xml" })
    public String getHelloWorldXML() {
        return "<xml><result>" + helloService.createHelloMessage("World") + "</result></xml>";
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void postMessage(MessageBody messageBody) {
        System.out.println(messageBody.hello);
        System.out.println(messageBody.foo);
        System.out.println(messageBody.count);

        LOGGER.info("POST json with post");
        LOGGER.info(messageBody.hello);
        LOGGER.info(messageBody.foo);
        LOGGER.info(messageBody.count);
    }

    @GET
    @Path("/map")
    @Produces({"application/json"})
    public String getMap(){
//        Gson gson = new Gson();
//        String json = gson.toJson(helloService.getValues());
        return String.valueOf(helloService.getValues());
    }

}