public class DailyVehiclePermit extends ProvincialPark{
    public int NumberOfVehicles;
    public int NumberOfHours;

    public DailyVehiclePermit(int numberOfVehicles, int numberOfHours) {
        if(AvailableSites > 0 && numberOfVehicles <= 5 && numberOfHours <= 6 && numberOfHours >= 3){
            NumberOfVehicles = numberOfVehicles;
            NumberOfHours = numberOfHours;
            AvailableSites -= 1;
            System.out.println("Thank you, we have recived your reservation"+'\''+
                    "We still have " + AvailableSites + " sites.");
        }else{
            String errorInfo = "";
            errorInfo += (AvailableSites == 0) ? "camp do not have enough site.'\'":"";
            errorInfo += (numberOfVehicles > 5) ? "Requested Number of vehicles can not more than 5.'\' ":"";
            errorInfo += (numberOfHours < 3  || numberOfHours > 6) ? "Requested can not less than 3 or more than 6 hours.'\' ":"";
            System.out.println(errorInfo  + '\''  + "Booking cannot be made.");
            NumberOfVehicles = 0;
            NumberOfHours = 0;
        }
    }

    @Override
    int getReservationCost() {
        return NumberOfVehicles * 20;
    }

    @Override
    public String toString() {
        return super.toString() + '\n'+
                "Trying to book daily vehicle permit for " +
                 NumberOfVehicles + "vehicles for " +
                NumberOfHours + "hours." + " ReservationCost = " + getReservationCost() + '\''
                ;
    }
}
