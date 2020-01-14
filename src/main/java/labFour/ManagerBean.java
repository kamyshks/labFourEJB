package labFour;

import domain.Dot;
import domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Singleton
@Path("test")
public class ManagerBean implements ManagerBeanInterface{

//    @GET
//    public String mockGet() { return  ""; }

    private EntityManager em;

    @PostConstruct
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dots");
        em = emf.createEntityManager();
    }


    public List<DotDTO> getAll(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Dot> dots = em.createQuery("SELECT dot FROM Dot dot WHERE user_id = " + user.getId(), Dot.class).getResultList();
        System.out.println(dots);


        tx.commit();

        List<DotDTO> points = new ArrayList<>();
        dots.forEach(dot -> points.add(new DotDTO(dot.getX(), dot.getY(), dot.getR(), dot.getResult())));

        return points;
    }

    public void deleteAll(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.createQuery("DELETE FROM Dot dot WHERE dot.user_id = " + user.getId()).executeUpdate();

        tx.commit();
    }

    public void addDot(double x, double y, double r, String result, User user) {

        Dot dot = new Dot(x, y, r, result, user.getId() );
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(dot);

        tx.commit();
    }

    public User getUserIdByLogin(String login) {
        User user;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        user = em.createQuery("SELECT user FROM User user WHERE login= " + login, User.class).getSingleResult();

        tx.commit();
        return user;
    }

    @GET
    public String  getUser(){
        String log = "a";
        User user;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        user = em.createQuery("SELECT User FROM User user WHERE login= " + log, User.class).getSingleResult();

        tx.commit();

        int a = user.getId();
        String b = String.valueOf(a);

        return b;
    }

    public boolean checkUser(String login, String password){
        try {
            User user = getUserIdByLogin(login);
            return password.equals(user.getPassword());
        } catch (Exception ex){
            return false;
        }
    }

    public boolean hasUser(String login){
        return getUserIdByLogin(login) != null;
    }

    public void addUser(String email,String login, String password){
        User user = new User(email,login,password);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
    }

    //@GET
    public String getDot() {
       // User us ;
//        addDot(2,4,5,"true", us);
       // addUser("2","a","a");
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        List<Dot> dots = em.createQuery("SELECT dot FROM Dot dot", Dot.class).getResultList();
//        System.out.println(dots);
        List<User> us = em.createQuery("SELECT  us FROM User us", User.class).getResultList();

        tx.commit();


        return us.toString();
    }
}
