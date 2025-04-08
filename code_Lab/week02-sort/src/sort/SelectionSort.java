/**
 * write by Max 
 */
package sort;

import java.util.Arrays;

public class SelectionSort {
   
    public static void reSort(int[] inputArray) {
    	int arrayLength = inputArray.length;
    	for(int i = 0; i< arrayLength - 1; i++)
    	{
    		int minIndex = i;
    		for(int j = i+1; j < arrayLength; j++  )
    		{
    			minIndex = inputArray[minIndex] <=inputArray[j]?minIndex:j;
    		}
    		if(minIndex != i)
    		{
    			int temp = inputArray[i];
    			inputArray[i] = inputArray[minIndex];
    			inputArray[minIndex] = temp;
    		}
    	}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This a simple selection sort mathod to deal with int array!");
		int[] array = {4,5,2,9};
		reSort(array);
		System.out.println(Arrays.toString(array));
	}
}
