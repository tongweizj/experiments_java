question1 
用treesearch
在老师的example code 里面找一下

question2
模仿example 代码写


## **Lab Assignment #7 – Search Trees and Sorting**

Due Date:     Friday, Week 13

### Purpose:    
The purpose of this Lab assignment is to:
·      Design algorithms that describe operations on **Binary Search trees**
·      Design algorithms that implement Sorting operation
·      Implement and test appropriate methods in Java or Python

### References:     
Read the course’s text chapter 11, 12 and the lecture slides. 
This material provides the necessary information that you need to complete the exercises.

Be sure to read the following general instructions carefully:
- This assignment must be completed individually by all the students.
- See the naming and submission rules at the end of this document
- You will have to provide a **demonstration video for your solution** and upload the video together with the solution on **eCentennial** through the assignment link. See the **video recording instructions** at the end of this document.

## **Exercise 1**

### Q1
**If your first name starts with a letter from A-J inclusively:**

Our implementation of the _treeSearch_ utility, from Code Fragment 11.3, relies on recursion. For a large unbalanced tree, it is possible that Java’s call stack will reach its limit due to the recursive depth. Give an alternative implementation of that method that does not rely on the use of recursion.

**Hint** Use a **loop** to express the repetition.

Write a Java/Python application to test your solution with tree of fig 11.1 from textbook .

### Q2
**If your first name starts with a letter from K-Z inclusively:**

Our implementation of the _treeSearch_ utility, from **Code Fragment 11.3**, relies on recursion. For a large unbalanced tree, it is possible that Java’s call stack will reach its limit due to the recursive depth. Give an alternative implementation of that method that does not rely on the use of recursion.
我们对 _treeSearch_ 实用程序的实现（来自代码片段 11.3）依赖于递归。
对于大型不平衡树，由于递归深度，Java 的调用堆栈可能会达到其极限。
请给出该方法的另一种不依赖于递归的实现。

写一个loop， 逻辑和递归的一样就可以
![Screenshot 2025-04-10 114244.png](https://raw.githubusercontent.com/tongweizj/Nodes_Images/main/notes/Screenshot%202025-04-10%20114244.png)


```java
/∗∗ An implementation of a sorted map using a binary search tree. ∗/  

public class TreeMap<K,V> extends AbstractSortedMap<K,V> { 
 // To represent the underlying tree structure, we use a specialized subclass of the  
 // LinkedBinaryTree class that we name BalanceableBinaryTree (see Section 11.2). 5 
 protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>( ); 
 
 //∗∗ Constructs an empty map using the natural ordering of keys. ∗/ 8 
 
 public TreeMap( ) {  
 super( ); // the AbstractSortedMap constructor 10 
 tree.addRoot(null); // create a sentinel leaf as root 11 
 }  
 /∗∗ Constructs an empty map using the given comparator to order keys. ∗/  public TreeMap(Comparator<K> comp) { 
  super(comp); // the AbstractSortedMap constructor 15 
  tree.addRoot(null); // create a sentinel leaf as root 16 } 17 /∗∗ Returns the number of entries in the map. ∗/ 18 public int size( ) { 19 return (tree.size( ) − 1) / 2; // only internal nodes have entries 20 } 21 /∗∗ Utility used when inserting a new entry at a leaf of the tree ∗/ 22 private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry) { 23 tree.set(p, entry); // store new entry at p 24 tree.addLeft(p, null); // add new sentinel leaves as children 25 tree.addRight(p, null); 26 } 27 28 // Omitted from this code fragment, but included in the online version of the code, 29 // are a series of protected methods that provide notational shorthands to wrap 30 // operations on the underlying linked binary tree. For example, we support the 31 // protected syntax root() as shorthand for tree.root() with the following utility: 32 protected Position<Entry<K,V>> root( ) { return tree.root( ); } 33 34 /∗∗ Returns the position in p's subtree having given key (or else the terminal leaf).∗/ 35 private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) { 36 if (isExternal(p)) 37 return p; // key not found; return the final leaf 38 int comp = compare(key, p.getElement( )); 39 if (comp == 0) 40 return p; // key found; return its position 41 else if (comp < 0) 42 return treeSearch(left(p), key); // search left subtree 43 else 44 return treeSearch(right(p), key); // search right subtree 45 } Code Fragment 11.3: Beginning of a TreeMap class based on a binary search t
```
**Hint** Use a **loop** to express the repetition.

Write a Java/Python application to test your solution with tree of fig 11.7 from textbook .

![Screenshot 2025-04-10 115146.png](https://raw.githubusercontent.com/tongweizj/Nodes_Images/main/notes/Screenshot%202025-04-10%20115146.png)



Exercise 2


Implement a bottom-up merge-sort for a collection of items by placing each item in its own queue, and then repeatedly merging pairs of queues until all items are sorted in ascending order within a single queue. Hint: A queue of queues can be very helpful.

Write a Java/Python application to test your solution.

#### 题目翻译：

**实现一个自底向上的归并排序算法**，要求将集合中的每个元素放入各自的队列中，然后反复合并队列对，直到所有元素按升序排列在单个队列中。提示：使用队列的队列（即队列中存储队列）会非常有帮助。

编写Java/Python应用程序来测试你的实现。

#### 题目分析：

1. **核心要求**：
    
    - 实现自底向上（非递归）的归并排序
        
    - 使用队列作为基本数据结构
        
    - 初始阶段：每个元素单独放入一个队列
        
    - 合并阶段：重复两两合并队列，直到只剩一个有序队列
        
2. **关键点**：
    
    - 需要实现队列的合并操作（合并两个已排序的队列）
        
    - 需要使用队列的队列（Queue of Queues）来管理中间过程
        
    - 时间复杂度应为O(n log n)，空间复杂度O(n)
        
3. **与标准归并排序的区别**：
    
    - 不使用数组分割，而使用队列
        
    - 自底向上方式避免了递归调用
        
    - 更适合链式数据结构的排序




---

### 1. 中文翻译  

**实验作业 #7 —— 搜索树与排序**  

**截止日期**：第13周周五  

**目的**：本次实验作业的目的是：  
- 设计二叉搜索树（Binary Search Trees）相关操作的算法。  
- 设计排序操作的算法。  
- 用Java或Python实现并测试相应的方法。  

**参考资料**：阅读教材第11、12章及课程幻灯片。这些资料提供了完成练习所需的信息。  

请仔细阅读以下通用说明：  
- 所有学生必须独立完成本作业。  
- 命名和提交规则见文档末尾。  
- 需为解决方案录制**演示视频**，并通过eCentennial的作业链接与代码一起提交。视频录制说明见文档末尾。  

**[练习1]**  
**如果你的名字首字母在A-J之间（包含A和J）：**  
教材代码片段11.3中的`treeSearch`工具方法使用了递归实现。对于大型不平衡树，递归深度可能导致Java调用栈溢出。请给出一个不依赖递归的替代实现。  
**提示**：使用**循环**替代递归。  
用Java/Python编写应用程序，并使用教材图11.1中的树测试你的解决方案。  

**如果你的名字首字母在K-Z之间（包含K和Z）：**  
教材代码片段11.3中的`treeSearch`工具方法使用了递归实现。对于大型不平衡树，递归深度可能导致Java调用栈溢出。请给出一个不依赖递归的替代实现。  
**提示**：使用**循环**替代递归。  
用Java/Python编写应用程序，并使用教材图11.7中的树测试你的解决方案。（5分）  

**[练习2]**  
实现一个自底向上的归并排序（bottom-up merge-sort），方法是将每个元素放入单独的队列中，然后反复合并队列对，直到所有元素在一个队列中按升序排列。  
**提示**：使用**队列的队列**（queue of queues）结构会很有帮助。  
用Java/Python编写应用程序测试你的解决方案。（5分）  

**评分标准**：  
- **功能实现**（70%）：  
  - 正确实现需求（10%）。  
  - 通过代码演示和简短视频解释（60%）。  
- **面向对象设计**（15%）：  
  - 正确设计类和方法（5%）。  
  - 正确使用泛型。  
  - 遵循命名规范。  
- **总分**：100%。  

**命名和提交规则**：  
- Eclipse项目命名格式：`YourFullname_COMP254Labnumber`（例如：`JohnSmith_COMP254Lab7`）。  
- 包名格式：`com.exercisenumber.yourfirstname.yourlastname`（例如：`com.exercise1.john.smith`）。  
- 在每个练习的main方法顶部注释中提供学号和全名。  
- 将项目压缩为zip文件，命名格式：`YourFullname_COMP254Labnumber.zip`（例如：`JohnSmith_COMP254Lab7.zip`）。  
- 通过eCentennial的作业链接上传zip文件和演示视频。  

---

### 2. 解题思路  

#### **练习1**  
**目标**：将递归实现的`treeSearch`方法改为迭代实现，避免栈溢出风险。  

**思路**：  
1. **递归问题分析**：  
   - 原递归方法通过不断调用自身遍历树，深度过大时会导致栈溢出。  
2. **迭代替代方案**：  
   - 使用循环和临时变量（如`current`节点）模拟递归过程。  
   - 从根节点开始，根据比较结果向左或向右移动，直到找到目标或到达叶子节点。  

**实现步骤**：  
- 定义树的节点结构（包含键、左子节点、右子节点）。  
- 实现迭代版`treeSearch`：  
  ```java
  Node treeSearch(Node root, int key) {
      Node current = root;
      while (current != null && current.key != key) {
          if (key < current.key) current = current.left;
          else current = current.right;
      }
      return current;
  }
  ```
- 测试：构建教材中的树（图11.1或11.7），验证搜索结果的正确性。  

**时间复杂度**：  
- 最坏情况下（树退化为链表）为O(n)，平均O(log n)。  

---

#### **练习2**  
**目标**：实现自底向上的归并排序，使用队列的队列结构。  

**思路**：  
1. **初始化阶段**：  
   - 将每个元素放入单独的队列中，形成“队列的队列”（如`List<Queue<T>>`）。  
2. **合并阶段**：  
   - 反复合并相邻的两个队列，直到只剩一个队列。  
   - 合并时，每次从两个队列头部取较小元素加入新队列。  

**实现步骤**：  
- 定义队列结构（可使用`LinkedList`）。  
- 实现合并逻辑：  
  ```java
  Queue<T> merge(Queue<T> q1, Queue<T> q2) {
      Queue<T> result = new LinkedList<>();
      while (!q1.isEmpty() && !q2.isEmpty()) {
          if (q1.peek().compareTo(q2.peek()) <= 0) result.add(q1.poll());
          else result.add(q2.poll());
      }
      while (!q1.isEmpty()) result.add(q1.poll());
      while (!q2.isEmpty()) result.add(q2.poll());
      return result;
  }
  ```
- 主排序逻辑：  
  ```java
  Queue<T> bottomUpMergeSort(List<T> items) {
      List<Queue<T>> queues = new ArrayList<>();
      for (T item : items) {
          Queue<T> q = new LinkedList<>();
          q.add(item);
          queues.add(q);
      }
      while (queues.size() > 1) {
          Queue<T> q1 = queues.remove(0);
          Queue<T> q2 = queues.remove(0);
          queues.add(merge(q1, q2));
      }
      return queues.get(0);
  }
  ```
- 测试：输入随机列表，验证输出是否有序。  

**时间复杂度**：  
- 每次合并操作O(n)，共log n层，总复杂度O(n log n)。  

---

**注意事项**：  
- 练习1需注意树的构建是否正确，尤其是测试用例的覆盖性。  
- 练习2中合并队列时需处理剩余元素，避免遗漏。  
- 演示视频需清晰展示代码逻辑和测试结果。