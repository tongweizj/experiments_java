public class SavingsAccount extends Account{
    private double balance;

    public SavingsAccount(String id, String name, int accountNum, double balance) {
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
        double tempBalance = this.balance - amount;
        if(tempBalance < 0.00){
            System.out.println("Alarm: your donot have enough balance! Your balance = " + this.balance);
        } else if (tempBalance < 3000.00) {
            this.balance = this.balance - amount;
            System.out.println("Alarm: your balance is less than $3000! Your balance = " + this.balance);
        }else {
            this.balance = this.balance - amount;
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
        return "SavingsAccount { " +
                "balance = " + balance +
                " " + super.toString() +
                " } "
        ;
    }
}
