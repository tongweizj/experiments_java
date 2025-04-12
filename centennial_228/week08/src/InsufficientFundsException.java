// create a custom user-defined exception by inheriting from Exception
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(){
        super("You don't have sufficient balance in your account.");
    }
}
