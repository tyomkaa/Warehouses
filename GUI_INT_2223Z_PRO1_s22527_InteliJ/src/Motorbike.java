public class Motorbike extends Vehicle {
    double sizeOfWheel;

    public Motorbike(int id, String name, double square, double sizeOfWheel) {
        super(id, name, square);
        this.sizeOfWheel = sizeOfWheel;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", square=" + square +
                ", sizeOfWheel=" + sizeOfWheel +
                '}';
    }
}
