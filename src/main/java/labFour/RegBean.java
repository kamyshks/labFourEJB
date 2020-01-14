package labFour;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("reg")
@Stateless
public class RegBean implements LocalRegistration {

//    @Inject
    private ManagerBean mb;

    @PUT
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registration(UserDTO user) {
        return Response.ok("USER EXIST").build();

//        System.out.println("reg");
//        if (mb.hasUser(user.getLogin())){
//            return Response.ok("USER EXIST").build();
//        } else {
//            mb.addUser(user.getEmail(), user.getLogin(), user.getPassword());
//            NewCookie cookie1 = new NewCookie("login", user.getLogin());
//            NewCookie cookie2 = new NewCookie("password", user.getPassword());
//            return Response.ok("SUCCESS").cookie(cookie1, cookie2).build();
//        }
    }


    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
    public String login(UserDTO user) {
        System.out.println(user.toString());
        return "ok";
//
//        if (mb.checkUser(user.getLogin(), user.getPassword())) {
//            NewCookie cookie1 = new NewCookie("login", user.getLogin());
//            NewCookie cookie2 = new NewCookie("password", user.getPassword());
//            return Response.ok("OK").cookie(cookie1, cookie2).build();
//        } else {
//            return Response.ok("NO MATCH OR NO USER").build();
//
//        }
    }
}
