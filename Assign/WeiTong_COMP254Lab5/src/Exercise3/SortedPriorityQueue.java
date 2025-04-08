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
package Exercise3;

import java.util.Comparator;

import lab.Position;
import lab.AbstractBinaryTree;
import lab.AbstractPriorityQueue;
import lab.AbstractTree;
import lab.Entry;
import lab.Tree;

/**Entry.javaEntry.javaEntry.java
 * An implementation of a priority queue with a sorted list.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

  private PQEntry<K, V>[] list;
  private int size = 0;


  public SortedPriorityQueue(int capacity) { 
	  super(); 
	  list =  (PQEntry<K, V>[]) new PQEntry[capacity];
  }


  /**
   * Inserts a key-value pair and returns the entry created.
   * @param key     the key of the new entry
   * @param value   the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  @Override
  public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
	  
    checkKey(key);    // auxiliary key-checking method (could throw exception)
    PQEntry<K, V> newest = new PQEntry<>(key, value);
    int i = size - 1;

    // 找到插入位置（从后往前移动，比新元素小的往后移）
    while (i >= 0 && compare(newest, list[i]) > 0) {
    	list[i + 1] = list[i];
        i--;
    }
    list[i + 1] = newest;
    size++;
    return newest;
  }

  /**
   * Returns (but does not remove) an entry with minimal key.
   * @return entry having a minimal key (or null if empty)
   */
  @Override
  public Entry<K,V> min() {
    if (list[0]==null ) return null;
    return list[size-1];
  }

  /**
   * Removes and returns an entry with minimal key.
   * @return the removed entry (or null if empty)
   */
  @Override
  public Entry<K,V> removeMin() {
	if (list[0]==null ) return null;
	PQEntry<K,V> min = list[size-1];
	list[size-1] = null;
	size --;
    return min;
  }

  /**
   * Returns the number of items in the priority queue.
   * @return number of items
   */
  @Override
  public int size() { return size; }
  
	    public static void main(String[] args) {
	        // 创建一个容量为10的优先队列，key 是 Integer（优先级），value 是 String（任务名）
	        SortedPriorityQueue<Integer, String> pq = new SortedPriorityQueue<>(10);

	        // 插入元素
	        pq.insert(5, "Email");
	        pq.insert(2, "Call Mom");
	        pq.insert(8, "Study");
	        pq.insert(1, "Do Homework");
	        pq.insert(3, "Cook");

	        System.out.println("Current size: " + pq.size());

	        // 查看当前最小值（应该是 key=1 的 "Do Homework"）
	        System.out.println("Min entry: " + entryToString(pq.min()));

	        // 删除最小值，重复执行直到队列为空
	        while (pq.size() > 0) {
	            Entry<Integer, String> removed = pq.removeMin();
	            System.out.println("Removed: " + entryToString(removed));
	        }

	        System.out.println("Queue empty? " + (pq.size() == 0));
	    }

	    // 小工具方法：将 entry 打印为字符串
	    private static <K, V> String entryToString(Entry<K, V> entry) {
	        if (entry == null) return "null";
	        return "(" + entry.getKey() + ", " + entry.getValue() + ")";
	    }
}
