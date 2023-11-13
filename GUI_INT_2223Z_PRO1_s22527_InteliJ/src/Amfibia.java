public class Amfibia extends Vehicle {

    double capacity;

    public Amfibia(int id, String name, double square, double capacity) {
        super(id, name, square);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Amfibia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", square=" + square +
                ", capacity=" + capacity +
                '}';
    }
}
