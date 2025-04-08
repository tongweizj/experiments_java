import java.util.Arrays;

public class DataCollector {
    private final int[] dataArray;
    private  int writeIndex = 0;

    public DataCollector(int size){
        this.dataArray = new int[size+1];
    }

    public synchronized void collectData(int data){
        System.out.println("Writing " + data + " at index " + writeIndex);
        this.dataArray[writeIndex] = data;

        ++ writeIndex;
    }

    @Override
    public String toString() {
        return "DataCollector{" +
                "dataArray=" + Arrays.toString(dataArray) +
                ", writeIndex=" + writeIndex +
                '}';
    }
}
