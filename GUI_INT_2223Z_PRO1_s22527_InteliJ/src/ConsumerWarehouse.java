import java.util.ArrayList;

public class ConsumerWarehouse extends Warehouse implements Rentable, Comparable {
    boolean occupied = false;
    ArrayList<Person> personArrayList = new ArrayList<>();

    public ConsumerWarehouse(int id, double storageVolume) {
        this.id = id;
        this.storageVolume = storageVolume;
    }

    @Override
    public String toString() {
        return "ConsumerWarehouse{" +
                "occupied=" + occupied +
                ", personArrayList=" + personArrayList +
                ", id='" + id + '\'' +
                ", storageVolume=" + storageVolume +
                ", occupiedVolume=" + occupiedVolume +
                ", itemArrayList=" + itemArrayList +
                '}';
    }
}
