import java.util.ArrayList;

public class ParkingSpace implements Rentable {

    int id;
    double space;
    Vehicle parking;
    ArrayList<Person> personArrayList = new ArrayList<>();

    public ParkingSpace(int id, double space) {
        this.id = id;
        this.space = space;
    }

    @Override
    public String DisplayItemList() {
        if(parking != null){
            return parking.toString();
        }else {
            return "Parking space is empty.";
        }
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "id=" + id +
                ", space=" + space +
                ", parking=" + parking +
                ", personArrayList=" + personArrayList +
                '}';
    }
}
