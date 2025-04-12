//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\nName: Wei Tong");
        System.out.println("Student ID: 301034450\n");
        testBank();
    }
    public static void testBank(){
        Bank bank1= new Bank();
        Bank bank2= new Bank();
        System.out.println("\nDisplay all account from Bank");
                for(Account item:Bank.accountList){
            System.out.println(item);
        }


        System.out.println("\nDisplay all special cases of Chequing Account");
        // deposit method test case
        System.out.println(Bank.accountList.get(3));

        System.out.println("\nTC1：deposit method : -20000.87");
        Bank.accountList.get(3).deposit(-20000.87);
        System.out.println("\nTC2：deposit method test case: 20000.87");
        Bank.accountList.get(3).deposit(20000.87);

        // withdraw method test case
        System.out.println("\n"+Bank.accountList.get(4));
//
        System.out.println("\nTC3：withdraw method: (43988.00 + 20000.00)");
        Bank.accountList.get(4).withdraw((43988.00 + 20000.00));
        System.out.println("\nTC4：withdraw method: 20000.00");
        Bank.accountList.get(4).withdraw(20000.00);

//        System.out.println("\n"+Bank.accountList.get(4));

        System.out.println("\nDisplay all special cases of Savings Account");
        // deposit method test case
        System.out.println("\nTC5：deposit method : -20000.00");
        Bank.accountList.get(1).deposit(-20000.00);
        System.out.println("\nTC6：deposit method : 20000.00");
        Bank.accountList.get(1).deposit(20000.77);

        // deposit method test case
        System.out.println("\n"+Bank.accountList.get(2));
        System.out.println("\nTC7：withdraw method: (0 > 8273.45-8274.00)");
        Bank.accountList.get(2).withdraw(8274.00);
        System.out.println("\nTC8：withdraw method: (8274.00-4000.00 > 3000.00)");
        Bank.accountList.get(2).withdraw(4000);
        System.out.println("\nTC9：withdraw method: (0 < 4274.00-3000.00 < 3000.00)");
        Bank.accountList.get(2).withdraw(3000.00);



//        for(Account item:Bank.accountList){
//            System.out.println(item);
//        }

//        for(Account item:bank1.accountList){
//            System.out.println(item);
//            item.withdraw(3000);
//            item.deposit(100000);
//        }
//        for(Account item:bank2.accountList){
//            System.out.println(item);
//            item.withdraw(30000);
//            item.deposit(200000);
//        }
        // bank1
//        bank1.accountList.get(0).deposit(1000.00);
//        bank1.accountList.get(0).withdraw(1000.00);
//        bank1.accountList.get(1).deposit(2000.98);
//        bank1.accountList.get(1).withdraw(2000.78);
//        bank1.accountList.get(2).deposit(20000.76);
//        bank1.accountList.get(2).withdraw(20000.56);

//
//        for(Account item:bank1.accountList){
//            System.out.println(item);
//        }

    }
}