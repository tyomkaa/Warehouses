

public class Rent {
    int id;
    double cost;
    Person person;
    Rentable rentable;
    Date startDate;
    Date finishDate;

    public Rent(int id, double cost, Person person, Rentable rentable, Date startDate, Date finishDate) {
        this.id = id;
        this.cost = cost;
        this.person = person;
        this.rentable = rentable;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", cost=" + cost +
                ", person=" + person +
                ", rentable=" + rentable +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
