public class NegativeValueException extends Exception{
    public NegativeValueException(){
        super("Negative amount not allowed for transactions.");
    }
}
