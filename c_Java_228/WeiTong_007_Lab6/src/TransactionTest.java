/*
 * Name: Wei Tong"
 * Student ID: 301034450
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionTest {
    public static void main() {
        System.out.println("Performing transactions");
        System.out.println("-----------------------------------------------------------------------------------");

        Account sharedAccount = new Account("John");
        Transaction t1 = new Transaction(sharedAccount, TransactionType.WITHDRAW, 200);
        Transaction t2 = new Transaction(sharedAccount, TransactionType.DEPOSIT, 1000);
        Transaction t3 = new Transaction(sharedAccount, TransactionType.DEPOSIT, 500);
        Transaction t4 = new Transaction(sharedAccount, TransactionType.WITHDRAW, 100);
        System.out.println(sharedAccount);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
        executor.execute(t4);
        // Shutdown executor after tasks complete
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to complete
        }
        System.out.println("sharedAccount " + sharedAccount);

    }
}
