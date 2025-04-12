public class CampsiteReservation extends ProvincialPark{
    public int GroupSize;
    public int RequestedNumberSites;
    public int NumberOfDays;

    public CampsiteReservation(int groupSize, int requestedNumberSites, int numberOfDays) {
        if(AvailableSites >= requestedNumberSites && requestedNumberSites <=3 && groupSize / requestedNumberSites <= 6&&numberOfDays<=6){
            GroupSize = groupSize;
            RequestedNumberSites = requestedNumberSites;
            NumberOfDays = numberOfDays;
            AvailableSites -= this.RequestedNumberSites;
            System.out.println("Thank you, we have recived your reservation"+'\n' + "We still have " + AvailableSites + " sites.");
        }else{
            String errorInfo = "";
            errorInfo += (AvailableSites < requestedNumberSites) ? "camp do not have enough site.'\'":"";
            errorInfo += (requestedNumberSites > 3) ? "Requested Number Sites can not more than 3 sites.'\' ":"";
            errorInfo += ((groupSize / requestedNumberSites) > 6) ? "Maximum of each group size's 6 people.'\' ":"";
            errorInfo += (numberOfDays > 6) ? "Reservation day can not more than 6.'\' ":"";
            System.out.println("Sorry, this Camp site can not take your reservation, because: " + '\''  + errorInfo);
            GroupSize = 0;
            RequestedNumberSites = 0;
            NumberOfDays = 0;
        }

    }

    @Override
    int getReservationCost() {
        return this.NumberOfDays > 3 ? this.NumberOfDays * 45 :this.NumberOfDays * 40;
    }

    @Override
    public String toString() {
        return  super.toString() + '\n'+
                "Trying to book " + RequestedNumberSites +
                "for " + GroupSize + " people for " +
                NumberOfDays + " days." +
                " ReservationCost = $" + getReservationCost() +
                "Sites Remaining: " +AvailableSites + " ReservationCost = " + getReservationCost() + '\'';
    }
}
