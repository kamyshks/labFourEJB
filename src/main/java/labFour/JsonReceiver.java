package labFour;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("json")
public class JsonReceiver {
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //принимаемый тип данных
    @Produces(MediaType.APPLICATION_JSON) //отправляемый тип данных
    public Message post (DotDTO point) {

        System.out.println("Received point : " + point.toString());

        return new Message("This is message from server", 200);

    }
}