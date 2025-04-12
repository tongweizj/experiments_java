import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        testInheritance();
        testInterface();
    }


    static void testInheritance(){

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new PartTimeEmployee("Martin",32.0,25));
        employeeList.add(new PartTimeEmployee("Munan",25.0,30));

        employeeList.add(new FullTimeEmployee("Priya",8600000.0));

        for(Employee emp: employeeList){
            System.out.println(emp);
        }
    }

    static void testInterface(){
        Invoice iv1 = new Invoice("P101","Copper wire", 200, 0.99);
        System.out.println("iv1 : "  + iv1);
        System.out.println("Payable Amount : "  + iv1.getPayableAmount());
        System.out.println("Receivable Amount : "  + iv1.getReceivableAmount());

        Invoice iv2 = new Invoice("P102","Elbow Pipe", 15, 4.99);
        System.out.println("iv2 : "  + iv2);
        System.out.println("Payable Amount : "  + iv2.getPayableAmount());
        System.out.println("Receivable Amount : "  + iv2.getReceivableAmount());

        ContractEmployee ce1 = new ContractEmployee("Muna", 23456.0, 5);
        System.out.println("ce1: " + ce1);
        System.out.println("Amount for purchases : " + ce1.getReceivableAmount());
    }
}