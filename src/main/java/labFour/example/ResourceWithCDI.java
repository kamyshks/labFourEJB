package labFour.example;

import labFour.example.ExampleEJB;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cdi")
public class ResourceWithCDI {
    @Inject
    private ExampleEJB ejb;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get(){
        return ejb.getImage();
    }
}
