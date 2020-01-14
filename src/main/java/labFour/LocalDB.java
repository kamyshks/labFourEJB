package labFour;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LocalDB {
    List<DotDTO> get(String l, String p);
    String  addDot(DotDTO point);
    void delete(String l, String p);
}
