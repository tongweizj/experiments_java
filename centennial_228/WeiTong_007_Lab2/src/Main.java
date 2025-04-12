/*
 Name: Wei Tong
 Student ID: 301034450
 */

enum CarType {
    SUV,
    Hatchback,
    Sedan,
    Truck
}
public class Main {
    public static void main(String[] args) {
        System.out.println("\nName: Wei Tong");
        System.out.println("Student ID: 301034450\n");
        testCars();
    }

    static void testCars(){
//TEST
        //Car car1 = new Car("Honda",2019,"suv",1000.0,CarType.Truck);
        //System.out.println(car1);

        // TEST for class Dealership
        Dealership deal1 = new Dealership("1","A Dealer","17 Markham Road");
        deal1.addCar("Honda",2019,"CR-V",1000.0,CarType.SUV);
        deal1.addCar("Ford",2024,"F-150",1500.0,CarType.Truck);
        deal1.addCar("BMW",2016,"2Series",1000.0,CarType.Sedan);

        Dealership deal2 = new Dealership("2","B Dealer","17 Markham Road");
        deal2.addCar("Toyota",2018,"4Runner",1000.0,CarType.SUV);
        deal2.addCar("Nissan",2012,"Kicks",1000.0,CarType.SUV);
        deal2.addCar("Tesla",2023,"Model S",2000.0,CarType.SUV);

        deal1.showCars("Honda");
        deal1.showCars("Audi");
        deal1.showCars("Honda",2019);
        deal1.showCars("Honda",2023);

        deal2.showCars("Tesla",2023,2100);
        deal2.showCars("Tesla",2030,2100);
        deal2.showCars("Tesla",2010,2100);
        deal2.showCars("Tesla",2023,900);
        deal2.showCars("Tesla",2023,3000);
        deal2.showCars("Tesla",2013,1000);
        deal2.showCars("Tesla",2030,3000);
        deal1.showCars("Tesla",2023,2100);


        System.out.println(deal1);
    }
}