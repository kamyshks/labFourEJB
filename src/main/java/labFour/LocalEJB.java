package labFour;

import javax.ejb.Local;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Local
public interface LocalEJB {
    @GET
    @Produces(MediaType.TEXT_HTML)
    String getImage();
}
