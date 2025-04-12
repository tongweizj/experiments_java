import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to COMP228!");
        System.out.println("Hello and welcome to COMP228!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        System.out.println("Wei Tong");
        // variables
        int v1=10;
        float v2=89.8f;
        double v3=12.333322233;
        boolean v4=true;
        char v5= 'h';
        String v6 = "Happy";

        System.out.println("v1 : " + v1);
        System.out.println("v2 : "+v2);
        System.out.println("v3 : "+v3);
        System.out.println("v2 + v3 : "+(v2+v3));
        System.out.println("v4 : "+v4);
        System.out.println("v5 : "+v5);
        System.out.println("v6 : "+v6);

        // take input from user using the Scanner class

        //1. create the o
        Scanner inputer =new Scanner(System.in);

        //2.display the prompt to inform the user waht they should input
        System.out.println("Please enter inter number: ");

        // 3.take integer input using nextInt()
        v1 = inputer.nextInt();
        System.out.println("v1 from user: " + v1);

        System.out.println("Please enter value for V3(Double): ");
        v3 = inputer.nextDouble();
        System.out.println("v3 from user: " + v3);

        System.out.println("Please enter message: ");
        v6 = inputer.next(); // string input gned
        System.out.println("v6 from user: " + v6);

        System.out.println("Please enter message: ");
        v6 = inputer.nextLine(); // string input
        System.out.println("v6 from user: " + v6);
    }
}