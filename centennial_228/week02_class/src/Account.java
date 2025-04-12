/*
*
* */
public class Account {
    /*
    attributes
    lower camelCase, must be a noun

    access specifier
    public, default
    private， only accessible within the class
    **/
    public int accountNumber;
    public String ownerName;
    private double balanceAmount;

    /*
    constructors
    */
    Account(){
        accountNumber = 00001;
        ownerName = "name";
        balanceAmount = 500.0;
    }
    Account(String name){
        accountNumber = (int)(Math.random()*30000);
        ownerName = name;
        balanceAmount = 500.00;
    }

    Account(String name, double amount){
        accountNumber = (int)(Math.random()*50000);
        ownerName = name;
        balanceAmount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", ownerName='" + ownerName + '\'' +
                ", balanceAmount=" + balanceAmount +
                '}';
    }

    /*
    * mutator or setter method
    * method to modify the value of private member
    * */

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    /*
    * accessor / getter method
    *
    * */

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    /*
    behavior/operations
    represented using functions/methods
    lower CamelCase, must be a verb
     */

    void withdrawAmount(){
        System.out.println("Performing withdraw");
    }

    void depositAmount(){
        System.out.println("Performing deposit");
    }




}
