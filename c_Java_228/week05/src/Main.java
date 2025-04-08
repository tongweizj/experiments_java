//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        testInheritance();
    }

    static void testInheritance(){
        Employee e1 = new Employee();
        System.out.println("e1: "+e1);

        Employee e2 = new Employee( "Alex");
        System.out.println("e2: "+e2);

        ContractEmployee ce1 = new ContractEmployee("Last");
        System.out.println("c01: " + ce1);

        ce1.name = "Jeanne";
        System.out.println("c01: " + ce1);
        ce1.setPay(10000000.0);
        System.out.println("c01: " + ce1);


        ContractEmployee ce2 = new ContractEmployee(120000, 2);
        System.out.println("ce2:" + ce2);


        PartTimeEmployee pe1 = new PartTimeEmployee("Martin", 35,24);
        System.out.println("pe1 :" + pe1);


        CommissionedEmployee cme1 = new CommissionedEmployee("mona",100000.0,0.035);
        System.out.println("cme1: " + cme1);
    }
}