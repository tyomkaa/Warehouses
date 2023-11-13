import java.time.LocalDate;
import java.util.*;

public class Warehouse {
    int id;
    double storageVolume;
    double occupiedVolume;
    ArrayList<Item> itemArrayList = new ArrayList<>();

    public String DisplayItemList(){
        return (itemArrayList.toString());
    }

    public int compareTo(Object object){
        Warehouse warehouse = (Warehouse)object;
        return (int)(warehouse.storageVolume - this.storageVolume);
    }

    public void add(Item item) throws TooManyThingsException{
        if(occupiedVolume + item.getVolume() > storageVolume){
            throw new TooManyThingsException("Old items should be removed in order to insert new one.");
        }else {
            itemArrayList.add(item);
            System.out.println(item.getName() + " was added");
        }
    }

    public void remove(Item item){
        itemArrayList.remove(item);
    }

}
