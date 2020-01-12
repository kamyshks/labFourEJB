package labFour;

import domain.User;
import labFour.dto.DotDTO;

import java.util.List;

public interface LocalManager {
    List<DotDTO> getAll(User user);
    void deleteAll(User user);
    void addDot(double x, double y, double r, String result);
    User getUserIdByLogin(String login);
    void addUser(String email,String login, String password);
}
