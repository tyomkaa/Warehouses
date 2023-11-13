public class CarServiceSpot extends ServiceSpot {


    public CarServiceSpot(int id, double space) {
        super(id, space);
    }

    @Override
    public String toString() {
        return "CarServiceSpot{" +
                "id=" + id +
                ", space=" + space +
                '}';
    }
}
