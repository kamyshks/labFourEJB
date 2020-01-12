package labFour;

public class DotDTO {
    private Double x;
    private Double y;
    private Double r;
    private String result;

    public DotDTO(){}

    public DotDTO(Double x, Double y, Double r, String result){
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }


    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DotDTO{" +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result='" + result + '\'' +
                '}';
    }
}
