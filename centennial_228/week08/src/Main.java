import javax.sound.midi.SysexMessage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//        testExceptions();
//        System.out.printf("\nEnd of testExceptions!");
//        try{
//            processArray(10);
//        } catch (Exception e) {
//            // throw new RuntimeException(e);
//            System.out.println("Something went wrong");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//            //java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
//            //	at Main.processArray(Main.java:54)
//            //	at Main.main(Main.java:11)
//
//        }

//        noCatch(10,0);

//        tryCatchFinally(10,0);
//        try{
//            throwExample2(100,100);
//        }catch (Exception ex){
//            System.out.println("Exception ex = " + ex.getMessage());
//        }

        //throwExample2(100,100);
        withdraw(100);
        withdraw(-100);
        withdraw(7000);



    }

    static void testExceptions(){
        divide(8,2);
        divide(8,0);
    }

    static void divide(int a, int b ){
        int result = 0;
        try {
            System.out.println("\na= " + a + ", b = "+ b);
            // statement block
            result = a / b;

            System.out.println("result= " + result);
        } catch (ArithmeticException e) {
            // take any necessary actions to manage the exception or to repond to it
            System.out.println("result = infinity");
            //throw new RuntimeException(e);
            System.out.println(e);
            // java.lang.ArithmeticException: / by zero
        }

        System.out.printf("Divide complete!");

    }

    static void processArray(int index){

        int[] numbers = {5,323,323,424,564};
        int sum = 0;
        for(int i =0; i<index;i++){

                sum += numbers[i];

        }
        System.out.println("Sum of numbers : " + sum);
    }

    static void noCatch(int a, int b){
        System.out.println("\nnoCatch()...");
        System.out.println("\na = " + a + " b = " + b);

        int result = 0;
        try{
            result = a / b;
        }finally{
            // 无论 try block li 的代码如何运行，finally block 是一定运行的
            System.out.println("finally block executed!");
            System.out.println("result : " + result);
        }
    }


    static void tryCatchFinally(int a, int b){
        System.out.println("\ntryCatchFinallyh()...");
        System.out.println("\na = " + a + " b = " + b);

        int result = 0;
        try{
            result = a / b;
        }catch(Exception ex){
            System.out.println("Exception occurred, " + ex.getMessage());

        }
        finally{
            // 无论 try block li 的代码如何运行，finally block 是一定运行的
            System.out.println("finally block executed!");
            System.out.println("result : " + result);
        }
    }

    // multiple catch
    // use more than one catch()
    static void multipleCatch(){
        System.out.println("\nTrying multiple catch...");

        try{
             divide(9,8);
             processArray(7);
        }catch(ArithmeticException ex){

        }catch(ArrayIndexOutOfBoundsException ex){

        }catch(Exception ex){

        }
    }

    // throw - to create and instance of exception and generate it
    // throws - to indicate the method could throw exception which must be managed when calling it
    static void throwExample1(int a, int b) throws ArithmeticException{
        int result = a + b;
        if(result > 100){
            //generate exception

            throw new ArithmeticException("Result more than 100 is not allowed for further process.");
        }
    }

    // must manage Exception when calling thmod
    static void throwExample2(int a, int b) throws Exception{
        int result = a + b;
        if(result > 100){
            //generate exception

           throw new ArithmeticException("Result more than 100 is not allowed for further process.");

            //throw new Exception("Exception error");
            // not working when write Exception in the method
        }

        int r = result / b;
        System.out.println("result / b = " + r);

        if(r > 2){
            processArray(r);
        }
    }

    static  void withdraw(int amount){
        double balance = 5000;
        try {
            if (amount < 0) {
                throw new NegativeValueException(); // 这里抛出错误
            } else if (balance < amount) {
                throw new InsufficientFundsException();
            } else {
                balance -= amount;
            }
        }
        catch(NegativeValueException ex){
            System.out.println(ex.getMessage()); // 这里接住错误
        }
        catch (InsufficientFundsException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println("running ...");
            System.out.println(ex.getMessage());
        }
    }
}