package labFour;

import labFour.dto.DotDTO;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LocalDB {
    List<DotDTO> get(String l, String p);
    Message addDot(String login, String p, DotDTO point);
    void delete(String l, String p);
}
