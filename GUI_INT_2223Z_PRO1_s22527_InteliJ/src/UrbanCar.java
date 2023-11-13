public class UrbanCar extends Vehicle {
    double volumeOfEngine;

    public UrbanCar(int id, String name, double square, double volumeOfEngine) {
        super(id, name, square);
        this.volumeOfEngine = volumeOfEngine;
    }

    @Override
    public String toString() {
        return "UrbanCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", square=" + square +
                ", volumeOfEngine=" + volumeOfEngine +
                '}';
    }
}
