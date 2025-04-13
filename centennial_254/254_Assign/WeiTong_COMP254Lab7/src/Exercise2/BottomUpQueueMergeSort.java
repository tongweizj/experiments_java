package Exercise2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 自底向上队列归并排序 / Bottom-up queue merge sort
 * 使用队列实现非递归的归并排序算法 / Implement non-recursive merge sort using queues
 */
public class BottomUpQueueMergeSort {

    /**
     * 合并两个已排序的队列 / Merge two sorted queues
     * @param left  第一个有序队列 / First sorted queue
     * @param right 第二个有序队列 / Second sorted queue
     * @param <T>   可比较类型 / Comparable type
     * @return 合并后的有序队列 / Merged sorted queue
     */
    private static <T extends Comparable<T>> Queue<T> merge(Queue<T> left, Queue<T> right) {
        Queue<T> result = new LinkedList<>(); // 合并结果队列 / Result queue
        
        // 两个队列都有元素时比较头部 
        // While both queues have elements
        while (!left.isEmpty() && !right.isEmpty()) {
            // 取较小元素加入结果 / Take the smaller element and add to result
            if (left.peek().compareTo(right.peek()) <= 0) {
                result.add(left.poll());  // 左边更小取左边 / Take from left if smaller
            } else {
                result.add(right.poll()); // 右边更小取右边 / Take from right if smaller
            }
        }
        
        // 添加剩余元素 / Add remaining elements
        result.addAll(left);   // 左边剩余 / Left remaining
        result.addAll(right);  // 右边剩余 / Right remaining
        return result;
    }

    /**
     * 队列实现的归并排序 / Merge sort implemented with queues
     * @param items 待排序队列 / Queue to be sorted
     * @param <T>   可比较类型 / Comparable type
     * @return 排序后的队列 / Sorted queue
     */
    public static <T extends Comparable<T>> Queue<T> mergeSort(Queue<T> items) {
        // 边界条件处理 / 
    	// Edge cases handling
        if (items == null || items.size() <= 1) {
            return items; // Return if empty or single element
        }

        /* 初始化阶段：创建单元素队列集合 
         * Initialization: 
         * create single-element queues */
        Queue<Queue<T>> queueOfQueues = new LinkedList<>(); // Queue of queues
        for (T item : items) {
            Queue<T> singleItemQueue = new LinkedList<>(); // Create single-element queue
            singleItemQueue.add(item);                     // Add element
            queueOfQueues.add(singleItemQueue);            // Add to main queue
        }

        /* 合并阶段：两两合并直到只剩一个队列 / 
         * Merge phase: 
         * pairwise merging until one queue remains */
        while (queueOfQueues.size() > 1) {
            Queue<T> left = queueOfQueues.poll();  // Take first queue
            Queue<T> right = queueOfQueues.poll(); // Take second queue
            queueOfQueues.add(merge(left, right)); // Merge and add back
        }

        // Return final sorted queue
        return queueOfQueues.poll();
    }

    /**
     * 测试方法 / Test method
     */
    public static void main(String[] args) {
        // Create test data
        Queue<Integer> nums = new LinkedList<>();
        nums.add(3); 
        nums.add(1); 
        nums.add(4); 
        nums.add(1); 
        nums.add(5); 
        nums.add(9);

        // Print original
        System.out.println("Original: " + nums);
        
        // Perform sorting
        Queue<Integer> sorted = mergeSort(nums);
        
        // Print result
        System.out.println("Sorted: " + sorted);
        
        /* Expected output:
           Original 原始: [3, 1, 4, 1, 5, 9]
           Sorted 排序后: [1, 1, 3, 4, 5, 9] 
        */
    }
}
