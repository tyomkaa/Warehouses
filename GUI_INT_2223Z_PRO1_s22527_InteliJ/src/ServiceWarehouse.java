import java.util.ArrayList;

public class ServiceWarehouse extends Warehouse implements Comparable {
    double occupiedVolume = 0;
    ArrayList<Item> itemArrayList = new ArrayList<>();

    public ServiceWarehouse(int id, double storageVolume) {
        this.id = id;
        this.storageVolume = storageVolume;
    }

    @Override
    public String toString() {
        return "ServiceWarehouse{" +
                "id='" + id + '\'' +
                ", storageVolume=" + storageVolume +
                ", occupiedVolume=" + occupiedVolume +
                ", itemArrayList=" + itemArrayList +
                '}';
    }
}
