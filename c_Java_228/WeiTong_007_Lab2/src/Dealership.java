/*
 Name: Wei Tong
 Student ID: 301034450
 */
import java.util.ArrayList;

public class Dealership {
    private ArrayList<Car> carList = new ArrayList<>();
    private String id;
    private String name;
    private String address;

    public Dealership(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;

    }

    @Override
    public String toString() {
        String outPut= "\nDealership information\n id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                "\nCar List: \n";
        for(Car car : carList ){
            outPut += car.toString() +"\n";
        }

        return outPut;
    }

    public void addCar(String manufacturer, int make, String model, double basePrice, CarType type){
        Car car = new Car(manufacturer, make, model,basePrice,type);
        carList.add(car);
    }

    public void showCars(String manufacturer){
        System.out.println("\nCar List: " + manufacturer);
        boolean isFind = false;
        for(Car car : carList){
            if(car.getManufacturer().equalsIgnoreCase(manufacturer)){
                System.out.println(car);
                isFind = true;
            }
        }
        if(!isFind){
            System.out.println("Sorry, no can to show!");
        }
    }

    public void showCars(String manufacturer,int make){
        System.out.println("\nCar List: manufacturer: " + manufacturer+" make: " + make);
        boolean isFind = false;
        for(Car car : carList){
            if(car.getManufacturer().equalsIgnoreCase(manufacturer) &&
                    car.getMake() >= make){
                System.out.println(car);
                isFind = true;
            }
        }
        if(!isFind){
            System.out.println("Sorry, no can to show!");
        }
    }


    public void showCars(String manufacturer,int make, double basePrice){
        System.out.println("\nShow Car, dealer: " + name + " manufacturer: " + manufacturer + " make: " + make + " basePrice: " + basePrice);
        boolean isFind = false;
        for(Car car : carList){
            if(car.getManufacturer().equalsIgnoreCase(manufacturer) &&
                    car.getMake() >= make &&
            car.getBasePrice() <= basePrice){
                System.out.println(car);
                isFind = true;
            }
        }
        if(!isFind){
            System.out.println("Sorry, no can to show!");
        }
    }
}
