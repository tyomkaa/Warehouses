
public class TenantAlert {
    int id;
    Rent rent;
    Date finishDate;

    public TenantAlert(int id, Rent rent) {
        this.id = id;
        this.rent = rent;
        finishDate = rent.finishDate.plusDays(rent.finishDate, 30);
    }

    @Override
    public String toString() {
        return "TenantAlert{" +
                "id=" + id +
                ", rent=" + rent +
                ", finishDate=" + finishDate +
                '}';
    }
}
