package labFour;

import javax.ejb.Local;
import javax.ws.rs.GET;

@Local
public interface LocalAreaValidator {
    String checkArea(double x, double y, double r);
    boolean checkRectangle(double x, double y, double r);
    boolean checkCircle(double x, double y, double r);
    boolean checkTriangle(double x, double y, double r);
}
