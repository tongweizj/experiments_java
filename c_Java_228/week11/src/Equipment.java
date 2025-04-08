public class Equipment implements Runnable {
    private final int startDataValue;
    private final DataCollector sharedDataCollector;
    private final int sleepTime;


    public Equipment(int startDataValue, DataCollector sharedDataCollector, int sleepTime) {
        this.startDataValue = startDataValue;
        this.sharedDataCollector = sharedDataCollector;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            for (int i = startDataValue; i < startDataValue + 5; i++) {
                System.out.println(Thread.currentThread().getName() + "Collecting data " + i);
                this.sharedDataCollector.collectData(i);
                Thread.sleep(this.sleepTime);
            }

        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + "interrupted." + ex);
        } catch (Exception ex) {
            System.out.println("Something went wrong while executing " +
                    Thread.currentThread().getName() + " thread :" + ex);
        }

    }
}
