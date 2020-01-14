package labFour;

import javax.ws.rs.core.Response;

public interface LocalRegistration {
    Response registration(UserDTO user);
    String login(UserDTO user);
}
