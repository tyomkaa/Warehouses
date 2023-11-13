public class OffroadCar extends Vehicle {
    String typeOfEngine;

    public OffroadCar(int id, String name, double square, String typeOfEngine) {
        super(id, name, square);
        this.typeOfEngine = typeOfEngine;
    }

    @Override
    public String toString() {
        return "OffroadCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", square=" + square +
                ", typeOfEngine='" + typeOfEngine + '\'' +
                '}';
    }
}
