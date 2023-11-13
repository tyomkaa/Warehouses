
import java.util.ArrayList;


public class Person {
    String name;
    String surname;
    int ID;
    Date startDate;
    ArrayList<TenantAlert> information = new ArrayList<TenantAlert>();
    ArrayList<TenantAlert> tenantAlerts = new ArrayList<TenantAlert>();

    public Person( int ID, String name, String surname) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ID=" + ID +
                ", startDate=" + startDate +
                '}';
    }
}
