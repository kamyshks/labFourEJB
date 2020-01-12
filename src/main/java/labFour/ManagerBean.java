package labFour;

import domain.Dot;
import domain.User;
import labFour.dto.DotDTO;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Local
@Singleton
public class ManagerBean implements  LocalManager{
    private EntityManager em;


    public ManagerBean() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dots");
        em = emf.createEntityManager();
    }

    public List<DotDTO> getAll(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Dot> dots = em.createQuery("SELECT dot FROM Dot dot WHERE user_id = " + user.getId(), Dot.class).getResultList();
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

    public void addDot(double x, double y, double r, String result) {
        Dot dot = new Dot(x, y, r, result);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(dot);
        tx.commit();
    }

    public User getUserIdByLogin(String login) {
        User user;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        user = em.createQuery("SELECT User FROM User user WHERE login= " + login, User.class).getSingleResult();
        tx.commit();
        return user;
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
}
