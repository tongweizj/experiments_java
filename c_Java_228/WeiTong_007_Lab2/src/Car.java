/*
 Name: Wei Tong
 Student ID: 301034450
 */
public class Car {
    private String manufacturer;
    private int make;
    private String model;
    private static int VI_NUMBER = 1001;
    private int VIN;
    private double basePrice;
    private CarType type;

    public Car(String manufacturer, int make, String model, double basePrice, CarType type) {
        this.manufacturer = manufacturer;
        this.make = make;
        this.model = model;
        this.VIN = VI_NUMBER + 10;
        this.basePrice = basePrice;
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", make=" + make +
                ", model='" + model + '\'' +
                ", VIN=" + VIN +
                ", basePrice=" + basePrice +
                ", type=" + type +
                ", VI_NUMBER=" + VI_NUMBER +
                '}';
    }
}
