/*
 * Name: Wei Tong"
 * Student ID: 301034450
 */
public class Transaction implements Runnable {
    // Transaction class:
    // This is a thread (implements Runnable) that will use a shared account as a resource to perform transactions.
    // The class will have three properties; account, transaction type and amount.
    public  Account account;
    public TransactionType transaction;
    public double amount;

    // Initialize all the three properties through constructor.

    public Transaction(Account account, TransactionType transaction, double amount) {
        this.account = account;
        this.transaction = transaction;
        this.amount = amount;
    }


    // In the execution of this thread (run() method), call the performTransaction() method of the account class and then display the account details.
    // 在这个线程（run()方法）的执行中，调用account类的performTransaction()方法，然后显示account的详细信息。

    public void run() {
        this.account.performTransaction(this.transaction, this.amount);
    }

}
