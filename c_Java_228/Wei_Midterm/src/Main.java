import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!" +  '\n');
        testReservations();
    }

    public static void  testReservations(){
        ArrayList<ProvincialPark> petList = new ArrayList<ProvincialPark>(){{
            add(new CampsiteReservation(15,2,5));
            add(new CampsiteReservation(12,3,9));
            add(new CampsiteReservation(12,2,4));

            add(new DailyVehiclePermit(5, 8));
            add(new DailyVehiclePermit(4, 5));

        }};
        for(ProvincialPark item : petList){
          item.toString();
        }
    }
}