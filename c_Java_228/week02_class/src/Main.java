//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Week 2 - classes");
        testAccount();
    } //main() method

    static void testAccount(){
        /*
        object
        name must be a noun, lower camelCase
         */
        Account demoAccount = new Account("demo", 400.00); // keyword: new, create memory for
        System.out.println("\ndemo account info: \n");
        System.out.println("account id:"+ demoAccount.accountNumber);
        System.out.println("account name:"+ demoAccount.ownerName);
//        System.out.println("account balance:"+ demoAccount.balanceAmount);

        demoAccount.accountNumber = 123;
        demoAccount.ownerName = "Max";
//        demoAccount.balanceAmount= 1000000;
        demoAccount.setBalanceAmount(100000.00);

        Account jaffeAccount = new Account("demo",  3000.00); // 灰色的关键字不用输入，自动生成的
        System.out.println("\ndemo account info: \n");
        System.out.println("account id:"+ demoAccount.accountNumber);
        System.out.println("account name:"+ demoAccount.ownerName);
//        System.out.println("account balance:"+ demoAccount.balanceAmount);

        demoAccount.withdrawAmount();
        jaffeAccount.toString();
        System.out.println(jaffeAccount);
    }
}// Main class