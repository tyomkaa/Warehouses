public class Item {
    int id;
    String name;
    double volume;

    public Item(int id, String name, double volume) {
        this.id = id;
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", square=" + volume +
                '}';
    }
}
