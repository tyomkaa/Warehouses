import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Functions {

    static Person ChoosePerson(HashMap<Person, ArrayList<Rent>> listHashMap ){
        System.out.println("Choose person: ");
        for (Person person : listHashMap.keySet()){
            System.out.println(person.ID + ": " + person.name + " " + person.surname);
        }
        while (true){
            System.out.println("\nEnter the number: ");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            for (Person person : listHashMap.keySet()) {
                if (person.ID == i){
                    System.out.println("Current user: " + person.name + " " + person.surname + "\n");
                    return person;
                }
            }
        }
    }

    /////////////////////////////////////////////////////

    static void InfoOfUser(Person currentUser, HashMap<Person, ArrayList<Rent>> listHashMap){
        System.out.println(currentUser + "\n" + listHashMap.get(currentUser));
    }

    /////////////////////////////////////////////////////////

    static void AvailableWarehouses(ArrayList<Service> services){
        int i = 0;
        for (Service service : services) {
            for (ConsumerWarehouse consumerWarehouse : service.consumerWarehouses) {
                if (!consumerWarehouse.occupied){
                    System.out.println(consumerWarehouse);
                }
            }
        }
    }

    //////////////////////////////////////////////////////////

    static void Rent(Person currentUser, ArrayList<Service> services, HashMap<Person, ArrayList<Rent>> hashMap, Date today) throws ProblematicTenantException{
        int i = 0;
        if (currentUser.tenantAlerts.size() > 3){
            double costs = 0;
            String alert = currentUser.name + " " + currentUser.surname + " has already rented a warehouse: ";
            for (TenantAlert tenantAlert : currentUser.tenantAlerts) {
                alert = alert + " " + tenantAlert.rent.rentable + ", ";
                costs = costs + tenantAlert.rent.cost;
            }

            alert = alert + " - cost: " + costs;
            throw new ProblematicTenantException(alert);
        }else {
            double costs = 0;
            for (Rent rent : hashMap.get(currentUser)) {
                costs = costs + rent.cost;
            }

            if (costs < 1250){
                for (Service service : services) {
                    System.out.println("ID: " + i + " - " + service.name + ": \n");
                    for (ConsumerWarehouse consumerWarehouse : service.consumerWarehouses) {
                        if (!consumerWarehouse.occupied){
                            System.out.println(consumerWarehouse.id + " - " + consumerWarehouse);
                        }
                    }
                    System.out.println("\nEnter the number of service: ");
                    Scanner scanner = new Scanner(System.in);
                    int serv = scanner.nextInt();
                    System.out.println("\nEnter the number of warehouse: ");
                    int warehouse = scanner.nextInt();

                    for (ConsumerWarehouse consumerWarehouse : services.get(serv).consumerWarehouses) {
                        if (warehouse == consumerWarehouse.id){
                            hashMap.get(currentUser).add(new Rent(1, 200, currentUser, consumerWarehouse, today, today.plusDays(today, 30)));
                        }
                    }
                }
            }else {
                System.out.println("You can't rent so many warehouses.");
            }
        }
    }

    ////////////////////////////////////////////////////////

    static void ChooseWarehouse(Person currentUser, HashMap<Person, ArrayList<Rent>> hashMap){
        System.out.println("Choose a warehouse which details you want to see: ");
        for (Rent rent : hashMap.get(currentUser)) {
            System.out.println(rent.id + " " + rent.rentable);
        }
        Scanner scanner = new Scanner(System.in);
        int o = scanner.nextInt();
        for (Rent rent : hashMap.get(currentUser)) {
            if (o == rent.id){
                System.out.println(rent.rentable.DisplayItemList());
            }
        }
    }

    ////////////////////////////////////////////////////////

    static void AddItem(Person currentUser, ArrayList<Service> services, HashMap<Person, ArrayList<Rent>> hashMap, ArrayList<Item> items, ArrayList<Vehicle> vehicles){

        System.out.println("Enter the number of service: ");
        Scanner scanner = new Scanner(System.in);
        int service = scanner.nextInt();

        System.out.println("Where do you want to put your item?");
        System.out.println("Consumer warehouse - 0");
        System.out.println("Service warehouse - 1");
        System.out.println("Parking space - 2");

        int input = scanner.nextInt();

        if (input == 0){
            System.out.println("Choose the warehouse: ");
            for (ConsumerWarehouse consumerWarehouse : services.get(service).consumerWarehouses) {
                System.out.println(consumerWarehouse.id + " " + consumerWarehouse);
            }
            int warehouse = scanner.nextInt();

            ConsumerWarehouse cm = null;
            for (ConsumerWarehouse consumerWarehouse : services.get(service).consumerWarehouses) {
                if (warehouse == consumerWarehouse.id){
                    cm = consumerWarehouse;
                }
            }

            boolean permission = true;

            for (Rent rent : hashMap.get(currentUser)) {
                if (rent.rentable == cm){
                    permission = true;
                }
            }
            if (!permission){
                for (Person person : cm.personArrayList) {
                    if (person == currentUser){
                        permission = true;
                    }
                }
            }

            if (permission){
                System.out.println("Choose the item which you want to add: ");
                for (Item item : items) {
                    System.out.println(item.id + " " + item.name + "  volume: " + item.volume);
                }
                int it = scanner.nextInt();
                for (Item item : items) {
                    if (item.id == it){
                        try{
                            cm.add(item);
                        }catch (TooManyThingsException e){
                            e.printStackTrace();
                        }
                    }
                }
            }else {
                System.out.println("You do not have permission.");
            }
        }else if(input == 1){
            System.out.println("Choose the warehouse: ");
            for (ServiceWarehouse serviceWarehouse : services.get(service).serviceWarehouses) {
                System.out.println(serviceWarehouse.id + " " + serviceWarehouse);
            }
            int warehouse = scanner.nextInt();
            ServiceWarehouse cm = null;
            for (ServiceWarehouse serviceWarehouse : services.get(service).serviceWarehouses) {
                 if (warehouse == serviceWarehouse.id){
                     cm = serviceWarehouse;
                 }
            }
            System.out.println("Choose the item you want to add: ");
            for (Item item : items) {
                System.out.println(item.id + " " + item.name + "  volume: " + item.volume);
            }
            int it = scanner.nextInt();
            for (Item item : items) {
                if (item.id == it){
                    try{
                        cm.add(item);
                    }catch (TooManyThingsException e){
                        e.printStackTrace();
                    }
                }
            }
        }else if(input == 2){
            System.out.println("Choose the parking space: ");
            for (ParkingSpace parkingSpace : services.get(service).parkingSpaces) {
                if (parkingSpace.parking == null){
                    System.out.println(parkingSpace.id + " " + parkingSpace);
                }
            }
            int parkingspace = scanner.nextInt();

            ParkingSpace cm = null;
            for (ParkingSpace parkingSpace : services.get(service).parkingSpaces) {
                if (parkingspace == parkingSpace.id){
                    cm = parkingSpace;
                }
            }
            boolean permission = true;
            for (Rent rent : hashMap.get(currentUser)) {
                if (rent.rentable == cm){
                    permission = true;
                }
            }
            if(!permission){
                for (Person person : cm.personArrayList) {
                    if(person == currentUser){
                        permission = true;
                    }
                }
            }

            if (permission){
                System.out.println("Choose the vehicle you want to park: ");
                for (Vehicle vehicle : vehicles) {
                    System.out.println(vehicle.id + " " + vehicle.name + " " + vehicle.square);
                }
                int veh = scanner.nextInt();
                for (Vehicle vehicle : vehicles) {
                    if (veh == vehicle.id){
                        cm.parking = vehicle;
                    }
                }
            }
        }

    }

    /////////////////////////////////////////////////////

    static void RemoveItem(Person currentUser, ArrayList<Service> services, HashMap<Person, ArrayList<Rent>> hashMap){

        System.out.println("Enter the number of service: ");
        Scanner scanner = new Scanner(System.in);
        int service = scanner.nextInt();

        System.out.println("Where do you want to remove your item?");
        System.out.println("Consumer warehouse - 0");
        System.out.println("Service warehouse - 1");
        System.out.println("Parking space - 2");

        int input = scanner.nextInt();

        if (input == 0){
            System.out.println("Choose the warehouse: ");
            for (ConsumerWarehouse consumerWarehouse : services.get(service).consumerWarehouses) {
                System.out.println(consumerWarehouse.id + " " + consumerWarehouse);
            }
            int warehouse = scanner.nextInt();

            ConsumerWarehouse cm = null;
            for (ConsumerWarehouse consumerWarehouse : services.get(service).consumerWarehouses) {
                if (warehouse == consumerWarehouse.id){
                    cm = consumerWarehouse;
                }
            }

            boolean permission = true;

            for (Rent rent : hashMap.get(currentUser)) {
                if (rent.rentable == cm){
                    permission = true;
                }
            }
            if (!permission){
                for (Person person : cm.personArrayList) {
                    if (person == currentUser){
                        permission = true;
                    }
                }
            }

            if (permission){
                System.out.println("Choose the item which you want to remove: ");
                for (Item item : cm.itemArrayList) {
                    System.out.println(item.id + " " + item.name + "  volume: " + item.volume);
                }
                int it = scanner.nextInt();
                for (Item item : cm.itemArrayList) {
                    if (item.id == it){
                        cm.remove(item);
                    }
                }
            }else {
                System.out.println("You do not have permission.");
            }
        }else if(input == 1){
            System.out.println("Choose the warehouse: ");
            for (ServiceWarehouse serviceWarehouse : services.get(service).serviceWarehouses) {
                System.out.println(serviceWarehouse.id + " " + serviceWarehouse);
            }
            int warehouse = scanner.nextInt();
            ServiceWarehouse cm = null;
            for (ServiceWarehouse serviceWarehouse : services.get(service).serviceWarehouses) {
                if (warehouse == serviceWarehouse.id){
                    cm = serviceWarehouse;
                }
            }
            System.out.println("Choose the item you want to remove: ");
            for (Item item : cm.itemArrayList) {
                System.out.println(item.id + " " + item.name + "  volume: " + item.volume);
            }
            int it = scanner.nextInt();
            for (Item item : cm.itemArrayList) {
                if (item.id == it){
                    cm.remove(item);
                }
            }
        }else if (input == 2){
            System.out.println("Choose the parking space: ");
            for (ParkingSpace parkingSpace : services.get(service).parkingSpaces) {
                if (parkingSpace != null){
                    System.out.println(parkingSpace.id + " " + parkingSpace);
                }
            }
            int parkingspace = scanner.nextInt();

            ParkingSpace cm = null;
            for (ParkingSpace parkingSpace : services.get(service).parkingSpaces) {
                if (parkingspace == parkingSpace.id){
                    cm = parkingSpace;
                }
            }
            boolean permission = true;
            for (Rent rent : hashMap.get(currentUser)) {
                if (rent.rentable == cm){
                    permission = true;
                }
            }
            if(!permission){
                for (Person person : cm.personArrayList) {
                    if(person == currentUser){
                        permission = true;
                    }
                }
            }

            if (permission){
                cm.parking = null;
            }
        }

    }

    static void Save(ArrayList<Service> services, ArrayList<CarRepair> queue, ArrayList<CarRepair> currentRepair, ArrayList<CarRepair> history){
        try {
            FileWriter fileWriter = new FileWriter("warehouse.txt");
            fileWriter.write("");
            for (Service service : services) {
                fileWriter.write(service.name + ":\n");
                service.consumerWarehouses.sort((o1, o2) -> (int)(o1.storageVolume - o2.storageVolume));
                fileWriter.write("\tConsumer warehouses:\n");
                for (ConsumerWarehouse consumerWarehouse : service.consumerWarehouses) {
                    consumerWarehouse.itemArrayList.sort((o1, o2) -> (int)(o1.volume + o2.volume));
                    fileWriter.write("\t" + consumerWarehouse.toString() + "\n");
                }
                fileWriter.write("\tService warehouses:\n");
                service.serviceWarehouses.sort((o1, o2) -> (int)(o1.storageVolume - o2.storageVolume));
                for (ServiceWarehouse serviceWarehouse : service.serviceWarehouses) {
                    serviceWarehouse.itemArrayList.sort((o1, o2) -> (int)(o1.volume + o2.volume));
                    fileWriter.write("\t" + serviceWarehouse.toString() + "\n");
                }
            }
            fileWriter.flush();

            FileWriter fileWriter1 = new FileWriter("services.txt");

            fileWriter1.write("Queue repair: \n");
            for (CarRepair carRepair : queue) {
                 fileWriter1.write("\t" + carRepair.toString() + "\n");
            }

            fileWriter1.write("\nCurrent repair: \n");
            for (CarRepair carRepair : currentRepair) {
                fileWriter1.write("\t" + carRepair.toString() + "\n");
            }

            fileWriter1.write("\nRepair history: \n");
            for (CarRepair carRepair : history) {
                fileWriter1.write("\t" + carRepair.toString() + "\n");
            }

            fileWriter1.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
