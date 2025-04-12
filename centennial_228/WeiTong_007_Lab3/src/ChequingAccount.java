public class ChequingAccount extends Account{
    private double balance;
    public ChequingAccount(String id, String name, int accountNum) {
        super(id, name, accountNum);
        this.balance = 0;
    }

    public ChequingAccount(String id, String name, int accountNum, double balance) {
        super(id, name, accountNum);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    void withdraw(double amount) {
        if(amount > this.balance + 2000){
            System.out.println("Alarm: your do not have enough balance!");
        } else {
            this.balance -= amount;
            System.out.println("Your balance = " + this.balance);
        }
    }

    @Override
    void deposit(double amount) {
        if(amount< 0){
            System.out.println("Alarm: your input amount is less than 0!");
        }else{
            this.balance += amount;
            System.out.println("Your balance = " + this.balance);
        }
    }

    @Override
    public String toString() {
        return "Chequing Account { " +
                "balance = " + balance +
                " " + super.toString() +
                " } "
        ;
    }
}
