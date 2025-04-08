package Exercise1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import lab.Entry;
import lab.Map;


public class exercise {

	  
	  public static Set<String> buildRandomKeySets(int size, int keyLength) {
	        Set<String> keySet = new HashSet<>();
	        Random random = new Random();
	
	        while (keySet.size() < size) {
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < keyLength; i++) {
	                char c = (char) ('a' + random.nextInt(26)); // generate a-z letter
	                sb.append(c);
	            }
	            keySet.add(sb.toString());
	        }
	
	        return keySet;
	    } 
	  
	    // Returns the elapsed time in nanoseconds since the given start time.
	  public static long elapsedNanos(long startTime) {
	        return System.nanoTime() - startTime;
	    }
	  
	  public static void testPut(String testName, Set<String> testData, Map<String,String> testMap)
	  {
		    long startTime = elapsedNanos(0);
			// 1. 1000 times input
	        for (String key : testData) {
	            //System.out.println(key);
	        	testMap.put(key,key);
	        }
	        
	        long endTime = elapsedNanos(startTime);
	        System.out.println(testName + " Running time: " + endTime/ 1_000_000.0);
	  }

	  public static void testGet(String testName, Set<String> testData, Map<String,String> testMap)
	  {
		    long startTime = elapsedNanos(0);
			// 1. 1000 times get out
	        for (String key : testData) {
	        	testMap.get(key);
	        }
	        long endTime = elapsedNanos(startTime);
	        System.out.println(testName + " Running time: " + endTime/ 1_000_000.0);
	  }
	  
	  public static void testRemove(String testName, Set<String> testData, Map<String,String> testMap)
	   
	  {
		    long startTime = elapsedNanos(0);
			// 1. 1000 times get out
	        for (String key : testData) {
	        	testMap.remove(key);
	        }
	        long endTime = elapsedNanos(startTime);
	        System.out.println(testName + " Running time: " + endTime/ 1_000_000.0);
	  }
	  
	  public static void main(String[] args) {
	      // Setup phase
		  // 1. random key sets
		  int initialCapacity = 17; 
		  int prime = 109345121;   
		  System.out.println("\n=== Test buildRandomKeySets(100000, 20) ==\n");
		  Set<String> keys = buildRandomKeySets(50000, 20); // 生成10个6位字符串
	      	        
		  // test1
		    Map<String,String>  testMap1 = new  ChainHashMap<>(initialCapacity,prime,0.1);
		    Map<String,String>  testMap3 = new  ChainHashMap<>(initialCapacity,prime,0.3);
		    Map<String,String>  testMap5 = new  ChainHashMap<>(initialCapacity,prime,0.5);
		    Map<String,String>  testMap7 = new  ChainHashMap<>(initialCapacity,prime,0.7);
		    Map<String,String>  testMap9 = new  ChainHashMap<>(initialCapacity,prime,0.9);
		    ProbeHashMap<String, String> testMap10 = new ProbeHashMap<>();
		    
		    System.out.println("\n=== Test Put to Map ==\n");
		    testPut("ChainHashMap PutTestCase, loadFactor:10%", keys, testMap1);
		    testPut("ChainHashMap PutTestCase, loadFactor:30%", keys, testMap3);
		    testPut("ChainHashMap PutTestCase, loadFactor:50% =>", keys, testMap5);

		    testPut("ProbeHashMap PutTestCase, loadFactor:50% =>", keys, testMap10);
		    testPut("ChainHashMap PutTestCase, loadFactor:70%", keys, testMap7);
		    testPut("ChainHashMap PutTestCase, loadFactor:90%", keys, testMap9);
		    
		    System.out.println("\n=== Test Get From Map ==\n");
		    testGet("ChainHashMap GetTestCase, loadFactor:10%", keys, testMap1);
		    testGet("ChainHashMap GetTestCase, loadFactor:30%", keys, testMap3);
		    testGet("ChainHashMap GetTestCase, loadFactor:50% =>", keys, testMap5);

		    testGet("ProbeHashMap GetTestCase, loadFactor:50% =>", keys, testMap10);
		    testGet("ChainHashMap GetTestCase, loadFactor:70%", keys, testMap7);
		    testGet("ChainHashMap GetTestCase, loadFactor:90%", keys, testMap9);
		    
		    System.out.println("\n== Test Remove From Map===\n");
		    
		    testRemove("ChainHashMap RemoveTestCase, loadFactor:10%", keys, testMap1);
		    testRemove("ChainHashMap RemoveTestCase, loadFactor:30%", keys, testMap3);
		    testRemove("ChainHashMap RemoveTestCase, loadFactor:50% =>", keys, testMap5);

		    testRemove("ProbeHashMap RemoveTestCase, loadFactor:50% =>", keys, testMap10);
		    testRemove("ChainHashMap RemoveTestCase, loadFactor:70%", keys, testMap7);
		    testRemove("ChainHashMap RemoveTestCase, loadFactor:90%", keys, testMap9);	    

	
		    
		    
	  

	    }

	   
}
