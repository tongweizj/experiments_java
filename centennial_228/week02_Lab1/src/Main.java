//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\nName: Wei Tong");
        System.out.println("Student ID: 301034450\n");
        testHiker();

    }

    static void testHiker(){
        Hiker oneHiker = new Hiker();
        System.out.println(oneHiker);

        oneHiker.setHikerID(10000);
        oneHiker.setAge(16);
        oneHiker.setName("Peter");
        oneHiker.setAddress("Markham");
        oneHiker.setParticipatedNumber(1);
        System.out.println(oneHiker);

        Hiker twoHiker = new Hiker("Sadan");
        System.out.println(twoHiker);

        Hiker threeHiker = new Hiker("Ivvian","Vangh",95);
        System.out.println(threeHiker);

        Hiker fourHiker = new Hiker("Susan",44);
        System.out.println(fourHiker);

    }
}