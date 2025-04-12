/*
 * Name: Wei Tong"
 * Student ID: 301034450
 */
public class Account {

    // The account class contains owner name and balance properties.
    // All the accounts by default get 1000$ as balance.
    public String name;
    public double balance = 1000;

    //  The constructor of the Account class will allow to initialize only the owner’s name.
    public Account(String name){
        this.name = name;
    }

    // Create a toString function to display account details.

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    // Create a synchronized function named as performTransaction().
    // This function will accept the transaction type and amount for the transaction as parameter.
    // The function is supposed to withdraw or deposit the amount based on the transaction type.
    public synchronized void performTransaction(TransactionType type, double amount){


        String s = (type.equals(TransactionType.DEPOSIT)) ? " to " : " from ";
        System.out.println("Trying to " + type.toString().toLowerCase() + " $" + amount + s  + this.name + "'s account");

        switch (type) {
            case DEPOSIT:
                this.balance += amount;
                System.out.println("successfully deposited " + amount + "$ to " + this.name +"'s account");
                break;
            case WITHDRAW:
                if(this.balance > amount) {
                    this.balance -= amount;
                    System.out.println("successfully withdrawn  " + amount + "$ from " + this.name +"'s account");
                }else{
                    System.out.println("Insufficient balance for withdrawal of $" + amount);
                }
                break;
            default:
                System.out.println("Invalid transaction type");
        }
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(toString());
    }
}
