package labFour;

import labFour.dto.UserDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Stateless
public class RegBean implements LocalRegistration{

    @EJB
    private ManagerBean mb;

    @POST
    @Path("reg")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registration(UserDTO user) {
        if (mb.hasUser(user.getLogin())){
            return Response.ok("USER EXIST").build();
        } else {
            mb.addUser(user.getEmail(), user.getLogin(), user.getPassword());
            NewCookie cookie1 = new NewCookie("login", user.getLogin());
            NewCookie cookie2 = new NewCookie("password", user.getPassword());
            return Response.ok("SUCCESS").cookie(cookie1, cookie2).build();
        }
    }

    @POST
    @Path("login")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(UserDTO user) {
        if (mb.checkUser(user.getLogin(), user.getPassword())) {
            NewCookie cookie1 = new NewCookie("login", user.getLogin());
            NewCookie cookie2 = new NewCookie("password", user.getPassword());
            return Response.ok("OK").cookie(cookie1, cookie2).build();
        } else {
            return Response.ok("NO MATCH OR NO USER").build();

        }
    }
}
