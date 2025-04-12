package com.exercise3.wei.tong;

public class main {
	public static int max(int []arr){
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>temp) {
                    temp = arr[i];
            }
        }
        return temp;
    }
	  public static int[] buildArray(int amount) {
		  int[] array = new int[amount];
		  for(int i = 0; i<amount;i++) {
			  array[i] = i;
		  }
		  return array;
	  }
	  public static void main(String[] args) {
		  int[] array = buildArray(20);
		  int max = max(array);
		  System.out.println("Finding an integer that cannot be formed as the sum of two integers in array ：" + max*2);
	  }

}
