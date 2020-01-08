package labFour;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@Path("ejb")
public class ExampleEJB implements LocalEJB {

    @Override
    public String getImage() {
        return "<img src=\"https://imgfon.ru/Images/Details_img_880px/Animals/glaza-usatyy-lapki-kotik-lezhit.png\" />";
    }
}
