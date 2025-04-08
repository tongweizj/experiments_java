import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("week11- Hello and welcome!");
        System.out.println("\nThread name : " + Thread.currentThread().getName() +
                "\nThread state: " + Thread.currentThread().getState() +
                "\nThread priority :" + Thread.currentThread().getPriority());

//        testDepartmentThread();
        testEquipmentThread();

    }
    static void testDepartmentThread(){
        DepartmentThread aviation = new DepartmentThread("Aviation");
        DepartmentThread healthCare = new DepartmentThread("HealthCare");
        DepartmentThread software = new DepartmentThread("Software");

        aviation.setPriority(Thread.MIN_PRIORITY);   //1
        healthCare.setPriority(Thread.MAX_PRIORITY); //10
        software.setPriority(Thread.NORM_PRIORITY);  //5

        System.out.println("\nThread states Before starting...");
        System.out.println("Aviation :" + Thread.currentThread().getName());
        System.out.println("Aviation :" + aviation.getState() + "priority : " + aviation.getPriority());
        System.out.println("healthCare :" + healthCare.getState());
        System.out.println("software :" + software.getState());

        aviation.start();
        healthCare.start();
        software.start();

        System.out.println("\nThread states After starting...");
        System.out.println("Aviation :" + aviation.getState());
        System.out.println("healthCare :" + healthCare.getState());
        System.out.println("software :" + software.getState());

        while(aviation.isAlive() || healthCare.isAlive() || software.isAlive()){
            System.out.println("\nThread states After starting...");
            System.out.println("Aviation :" + aviation.getState());
            System.out.println("healthCare :" + healthCare.getState());
            System.out.println("software :" + software.getState());

            try{
                Thread.sleep(1000);

            }catch(InterruptedException ex){
                System.out.println(ex);
            }
        }
    }

    static void testEquipmentThread(){
        DataCollector collector = new DataCollector(50);
        Equipment eq1 = new Equipment(20,collector,2000);
        Equipment eq2 = new Equipment(80,collector,4000);
        Equipment eq3 = new Equipment(-20,collector,6000);
        Equipment eq4 = new Equipment(120,collector,10000);

        // 运行方法： 原始，每一个任务都是同步，需要等待前者完成
//        eq1.run();
//        eq2.run();
//        eq3.run();
//        eq4.run();

        // 运行方法 2：增加 Thread Pool，开始平行，异步完成任务
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(eq1);
        executorService.execute(eq2);
        executorService.execute(eq3);
        executorService.execute(eq4);

        executorService.shutdown();
        System.out.println("Collected data :" );
        System.out.println(collector);



    }


}