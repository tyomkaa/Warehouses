
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Functions {

    public static void main(String[] args) throws Exception {
	    Main();
    }

    public static void menu(){
        System.out.println("0 - to return to main menu");
        System.out.println("1 - to change user");
        System.out.println("2 - to see your data");
        System.out.println("3 - to see available warehouses");
        System.out.println("4 - to rent");
        System.out.println("5 - to choose your place and see info");
        System.out.println("6 - to park or add a new item to warehouse");
        System.out.println("7 - to remove the item from warehouse");
        System.out.println("8 - to save data");
        System.out.println("9 - to close the program");
    }

    public static void Main() throws Exception{

        Date today = new Date(14,11,2022);

        ArrayList<Service> services = new ArrayList<>();
        HashMap<Person, ArrayList<Rent>> hashMap = new HashMap<>();
        ArrayList<Item> itemArrayList = new ArrayList<>();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<CarRepair> queue = new ArrayList<>();
        ArrayList<CarRepair> current = new ArrayList<>();
        ArrayList<CarRepair> history = new ArrayList<>();
        ArrayList<Rent> rentHistory = new ArrayList<>();

        services.add(new Service("Servis 1"));

        services.get(0).carServiceSpots.add(new CarServiceSpot(1, 100));
        services.get(0).carServiceSpots.add(new CarServiceSpot(2, 200));
        services.get(0).carServiceSpots.add(new CarServiceSpot(3, 150));
        services.get(0).carServiceSpots.add(new CarServiceSpot(4, 175));
        services.get(0).carServiceSpots.add(new CarServiceSpot(5, 222));

        services.get(0).independentCarServices.add(new IndependentCarService(1, 100));
        services.get(0).independentCarServices.add(new IndependentCarService(2, 120));
        services.get(0).independentCarServices.add(new IndependentCarService(3, 140));
        services.get(0).independentCarServices.add(new IndependentCarService(4, 160));
        services.get(0).independentCarServices.add(new IndependentCarService(5, 180));

        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(1, 8));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(2, 16));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(3, 14));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(4, 12));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(5,20));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(6, 25));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(7, 11));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(8, 9));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(9, 41));
        services.get(0).consumerWarehouses.add(new ConsumerWarehouse(10, 28));

        services.get(0).serviceWarehouses.add(new ServiceWarehouse(1, 21));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(2, 56));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(3, 17));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(4, 11));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(5, 64));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(6, 33));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(7, 44));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(8, 51));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(9, 18));
        services.get(0).serviceWarehouses.add(new ServiceWarehouse(10, 72));

        services.get(0).parkingSpaces.add(new ParkingSpace(1, 70));
        services.get(0).parkingSpaces.add(new ParkingSpace(2, 120));
        services.get(0).parkingSpaces.add(new ParkingSpace(3, 100));
        services.get(0).parkingSpaces.add(new ParkingSpace(4, 20));
        services.get(0).parkingSpaces.add(new ParkingSpace(5, 50));


        Person person1 = (new Person(1,"Artem","Honcharenko"));
        Person person2 = (new Person(2,  "Rafal","Konieczka"));
        Person person3 = (new Person(3,  "Bartosz","Kowalski"));
        Person person4 = (new Person(4,  "Michal","Szymanczak"));
        Person person5 = (new Person(5, "Pawel" ,"Lenkiewicz"));

        hashMap.put(person1, new ArrayList<>());
        hashMap.put(person2, new ArrayList<>());
        hashMap.put(person3, new ArrayList<>());
        hashMap.put(person4, new ArrayList<>());
        hashMap.put(person5, new ArrayList<>());

        Person currentUser = person1;

        itemArrayList.add(new Item(1, "Herbata", 12));
        itemArrayList.add(new Item(2, "Laptop", 25));
        itemArrayList.add(new Item(3, "Rower", 50));
        itemArrayList.add(new Item(4, "Woda", 3));
        itemArrayList.add(new Item(5, "Komputer", 30));


        vehicles.add(new Motorbike(6, "Suzuki",  3.6, 2.5));
        vehicles.add(new Motorbike(7, "Harley-Davidson",  4.2, 3.5));
        vehicles.add(new Motorbike(8, "Kawasaki",  2.1, 1.5));
        vehicles.add(new Motorbike(9, "Ducati",  5.3, 2.3));
        vehicles.add(new Motorbike(10, "Yamaha",  4.8, 1.7));

        vehicles.add(new OffroadCar(11, "Chevrolet",  10.6, "Gasoline"));
        vehicles.add(new OffroadCar(12, "DARTZ MOTORS",  11.6, "Diesel"));
        vehicles.add(new OffroadCar(13, "FORD",  8.88, "Gasoline"));
        vehicles.add(new OffroadCar(14, "HAVAL",  9.35, "Gasoline"));
        vehicles.add(new OffroadCar(15, "HUMMER",  9.006, "Gasoline"));

        vehicles.add(new UrbanCar(16, "LAMBORGHINI",  7.83, 5.2));
        vehicles.add(new UrbanCar(17, "BUGATTI",  8.9, 8));
        vehicles.add(new UrbanCar(18, "FERRARI",  9.4, 6));
        vehicles.add(new UrbanCar(19, "ASTON MARTIN",  9.2, 7.3));
        vehicles.add(new UrbanCar(20, "MERCEDES-BENZ",  9.3, 3.5));

        vehicles.add(new Amfibia(21, "Rinspeed sQuba",  7.5, 120));


        current.add(new CarRepair(2, services.get(0).carServiceSpots.get(1), vehicles.get(3), today, person4, services.get(0).parkingSpaces.get(1)));
        current.add(new CarRepair(1, services.get(0).carServiceSpots.get(2), vehicles.get(1), today, person2, services.get(0).parkingSpaces.get(2)));

        hashMap.get(person1).add(new Rent(1, 300,  person1, services.get(0).consumerWarehouses.get(2), today, today.plusDays(today, 30)));
        services.get(0).consumerWarehouses.get(2).occupied=true;
        hashMap.get(person2).add(new Rent(2, 250,  person2, services.get(0).parkingSpaces.get(1), today, today.plusDays(today, 30)));
        services.get(0).parkingSpaces.get(1).parking=vehicles.get(1);
        hashMap.get(person3).add(new Rent(3, 505,  person3, services.get(0).parkingSpaces.get(3), today, today.plusDays(today, 30)));
        services.get(0).consumerWarehouses.get(3).occupied=true;
        hashMap.get(person4).add(new Rent(4, 190,  person4, services.get(0).consumerWarehouses.get(3), today, today.plusDays(today, 30)));
        services.get(0).parkingSpaces.get(3).parking=vehicles.get(5);
        hashMap.get(person5).add(new Rent(5, 160,  person5, services.get(0).consumerWarehouses.get(0), today, today.plusDays(today, 30)));
        services.get(0).consumerWarehouses.get(0).occupied=true;



        menu();

        String choise;
        Scanner scanner = new Scanner(System.in);

        do {
            choise = scanner.nextLine();
            switch (choise){
                case "0":{
                    menu();
                    break;
                }
                case "1":{
                    currentUser = ChoosePerson(hashMap);
                    menu();
                    break;
                }
                case "2":{
                    InfoOfUser(currentUser,hashMap);
                    menu();
                    break;
                }
                case "3":{
                    AvailableWarehouses(services);
                    menu();
                    break;
                }
                case "4":{
                    try {
                        Rent(currentUser,services,hashMap,today);
                    }catch (ProblematicTenantException e){
                        e.printStackTrace();
                    }
                    menu();
                    break;
                    }
                case "5":{
                    ChooseWarehouse(currentUser,hashMap);
                    menu();
                    break;
                }
                case "6":{
                    AddItem(currentUser, services, hashMap, itemArrayList, vehicles);
                    menu();
                    break;
                }
                case "7":{
                    RemoveItem(currentUser, services,hashMap);
                    menu();
                    break;
                }
                case "8":{
                    Save(services,queue,current,history);
                    menu();
                    break;
                }
            }
        }while (!choise.equals("9"));

    }
}
