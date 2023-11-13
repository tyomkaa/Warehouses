

public class CarRepair {
    int id;
    int cost;
    ServiceSpot serviceSpot;
    Vehicle vehicle;
    Date startDate;
    Date finishDate;
    Person person;
    ParkingSpace parkingSpace;

    public CarRepair(int id, ServiceSpot serviceSpot, Vehicle vehicle, Date startDate, Person person, ParkingSpace parkingSpace) {
        int days = (int)(Math.random() * 5) + 1;
        this.id = id;
        this.cost = 30 * days;
        this.serviceSpot = serviceSpot;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.finishDate = (startDate.plusDays(startDate, (days)));
        this.person = person;
        this.parkingSpace = parkingSpace;
    }

    @Override
    public String toString() {
        return "CarRepair{" +
                "id=" + id +
                ", cost=" + cost +
                ", carServiceSpot=" + serviceSpot +
                ", vehicle=" + vehicle +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", person=" + person +
                ", parkingSpace=" + parkingSpace +
                '}';
    }
}
