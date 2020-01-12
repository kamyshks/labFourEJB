package labFour;

import labFour.dto.UserDTO;

import javax.ws.rs.core.Response;

public interface LocalRegistration {
    Response registration(UserDTO user);
    Response login(UserDTO user);
}
