import java.util.StringJoiner;

public abstract class ProvincialPark {
    static String Address="Silent Lake Provincial Park";
    static int AvailableSites=25;

    abstract int getReservationCost();

    @Override
    public String toString() {
        return "ProvincialPark{" +
                "site address= '" + Address  + "'" +
                "availableSites: " + AvailableSites +
                "}";
    }
}
