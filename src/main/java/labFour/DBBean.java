package labFour;

import domain.User;
import labFour.dto.DotDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("api")
@Stateless
public class DBBean implements LocalDB {

    @Inject
    private ManagerBean mb;

//    @PostConstruct
//    public void init() {
//        if (mb == null) {
//            mb = new ManagerBean();
//        }
//    }

    @EJB
    private AreaValidator av;

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON) //отправляемый тип данных
    public List<DotDTO> get(@CookieParam("login") String login, @CookieParam("password") String password) {
        User user = mb.getUserIdByLogin(login);
        System.out.println(mb);
        return mb.getAll(user);
//        return "ok";
    }


    // принимает запросы с json
    /*
    {
        x:double,
        y:double,
        r:double
    }
     */
    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON) //принимаемый тип данных
    @Produces(MediaType.APPLICATION_JSON) //отправляемый тип данных
    public Message addDot(@CookieParam("login") String login, @CookieParam("password") String password, DotDTO point) {
        try {
            double r = point.getR();
            double x = point.getX();
            double y = point.getY();
            mb.addDot(x, y, r, av.checkArea(x,y,r));
            return new Message("kaef", 200);
        } catch (NumberFormatException e) {
            return new Message("otstoi", 500);
        }
    }

    @DELETE
    @Override
    public void delete(@CookieParam("login") String login, @CookieParam("password") String password) {
        User user = mb.getUserIdByLogin(login);
        if (mb != null)
            mb.deleteAll(user);
    }
}
