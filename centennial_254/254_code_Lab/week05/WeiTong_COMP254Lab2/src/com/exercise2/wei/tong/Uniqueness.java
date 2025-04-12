/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.exercise2.wei.tong;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
      for (int k=j+1; k < n; k++)
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }
  
  
  static long TIME_LIMIT = 60 * 1000; // 60 seconds in milliseconds
  static long deviation = 1000;  // 1s
  static int unique = 0;
  public static int findMaxN(int maxN) {

	  int prevMax = 0;
	  long timeTaken = 0;
	  while (true) {
		  System.out.println("maxN= "+maxN);
          timeTaken = runAlgorithm(maxN);
          System.out.println("timeTaken= " + timeTaken);
          
          if (timeTaken >= TIME_LIMIT - deviation && timeTaken <= TIME_LIMIT + deviation) {
              break;
          } else if(timeTaken < TIME_LIMIT - deviation){
        	  prevMax = maxN;
        	  maxN *=2;
          }else {
        	  maxN = binarySearch(prevMax, maxN);
        	  break;
          }
      }

      return maxN;
  }
  
  public static int binarySearch(int low, int high) {

	  int mid = 0;
	  System.out.println(" low= "+low + ", high= " + high);
	  while (low <= high) {
		  mid = low + (high - low) / 2;
		  System.out.println("mid= "+mid);
          long timeTaken = runAlgorithm(mid);
          System.out.println("timeTaken= " + timeTaken);
          
          if (timeTaken >= TIME_LIMIT - deviation && timeTaken <= TIME_LIMIT + deviation) {
              return mid;
          } else if(timeTaken < TIME_LIMIT - deviation){
        	  low = mid + 1; 
          }else {
        	  high = mid -1;
          }
      }

      return -1; 
	  
  }
  public static long runAlgorithm(int n) {
      int[] testArray = buildArray(n);
      boolean result = false;
      long startTime = System.currentTimeMillis();
      if(unique==1) {
    	  result = unique1(testArray);
      }else {
    	  result = unique2(testArray);
      }
      
      long endTime = System.currentTimeMillis();
      
      return endTime - startTime; 
  }
  
  public static int[] buildArray(int amount) {
	  int[] array = new int[amount];
	  for(int i = 0; i<amount;i++) {
		  array[i] = i;
	  }
	  return array;
  }
  
  public static void main(String[] args) {
	  int maxN = 0;
	  unique = 1;
	  maxN = findMaxN(512000);
      System.out.println("Maximum n of unique1 that runs in 1 minute or less: " + maxN);
	  unique = 2;
      maxN = findMaxN(512000);
      System.out.println("Maximum n of unique2 that runs in 1 minute or less: " + maxN);
  }
}
