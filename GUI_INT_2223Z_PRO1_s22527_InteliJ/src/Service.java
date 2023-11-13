import java.util.ArrayList;

public class Service {
    String name;

    ArrayList<CarServiceSpot> carServiceSpots = new ArrayList<>();
    ArrayList<IndependentCarService> independentCarServices = new ArrayList<>();
    ArrayList<ServiceWarehouse> serviceWarehouses = new ArrayList<>();
    ArrayList<ConsumerWarehouse> consumerWarehouses = new ArrayList<>();
    ArrayList<ParkingSpace> parkingSpaces = new ArrayList<>();

    Service(String name){
        this.name = name;
    }
}
