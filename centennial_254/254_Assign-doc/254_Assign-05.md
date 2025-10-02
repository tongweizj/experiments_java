Due Date:     Friday, Week 10

## Purpose
The purpose of this Lab assignment is to:
- Design algorithms that describe operations on ADT Trees and priority queues.设计描述 ADT 树和优先级队列上的作的算法。
- Implement and test appropriate methods in Java or Python


## References

Read the course’s text chapter 8, 9 and the lecture slides. 
This material provides the necessary information that you need to complete the exercises.

Be sure to read the following general instructions carefully:
- This assignment must be completed individually by all the students.
- See the naming and submission rules at the end of this document

- 设计描述 ADT 树和优先![[module-info.java]]级队列上的作的算法。
	- 在 Java 或 Python 中实现和测试适当的方法
- 参考资料：阅读课程文本第 8、9 章和讲座幻灯片。本材料提供了完成练习所需的必要信息。
- 请务必仔细阅读以下一般说明：
	- 此作业必须由所有学生单独完成。
	- 请参阅本文档末尾的命名和提交规则


## Exercise 1

**If your first name starts with a letter from K-Z inclusively:**

Design the algorithm and method **following operations** for a binary tree T:

- inorderNext(p): 
Return the position visited after p in an inorder traversal of T (or null if p is the last node visited).
返回 T 的中序遍历中 p 之后访问的位置（如果 p 是访问的最后一个节点，则返回 null）。

- postorderNext(p): 
Return the position visited after p in a postorder traversal of T (or null if p is the last node visited).



1. 为二叉树 T 设计算法和方法 **后续作** ：

·      inorderNext（p）：返回 T 的中序遍历中 p 之后访问的位置（如果 p 是访问的最后一个节点，则返回 null）。

·      postorderNext（p）：返回在 T 的后序遍历中 p 之后访问的位置（如果 p 是最后一个访问的节点，则返回 null）。
Write a Java/Python to test your solution.

What are the worst-case running times of your algorithms?



### 解体思路

1. 首先要复习什么是  inorder traversal 和  postorder traversal


## **Exercise 2

Give an efficient algorithm that computes and prints, for every position p of a tree T, the element of p followed by the height of p’s subtree. 

Write a Java/Python to test your solution.

给出一个高效的算法，对于树 T 的每个位置 p，计算并打印 p 的元素，后跟 p 的子树的高度。

编写 Java/Python 来测试您的解决方案。

**Hint**: Use a postorder traversal to find the height of each subtree. The height for a subtree at p will be 0 if p is a leaf and otherwise one more than the height of the max child. Print out the element at p and its computed height during the postorder visit.

**提示**：使用 postorder 遍历来查找每个子树的高度。如果 p 是叶子，则 p 处的子树的高度将为 0，否则比最大子树的高度大 1。在 postorder 访问期间打印出 p 处的元素及其计算的高度。

## **Exercise 3**


**If your first name starts with a letter from K-Z inclusively:**

Reimplement the SortedPriorityQueue using java array. Make sure to maintain removeMin’s O(1) performance.


使用 java 数组重新实现 SortedPriorityQueue。确保保持 removeMin 的 O（1） 性能。


要基于用本周的example code 来写
`SortedPriorityQueue`


---

### 1. 中文翻译

**实验作业 #5 —— 使用树和优先队列**

**截止日期**：第10周周五  

**目的**：本次实验作业的目的是：  
- 设计描述ADT树和优先队列操作的算法。  
- 用Java或Python实现并测试相应的方法。  

**参考资料**：阅读教材第8、9章及课程幻灯片。这些资料提供了完成练习所需的信息。  

请仔细阅读以下通用说明：  
- 所有学生必须独立完成本作业。  
- 命名和提交规则见文档末尾。  

**[练习1]**  
**如果你的名字首字母在A-J之间（包含A和J）：**  
为二叉树T设计以下操作的算法和方法：  
- `preorderNext(p)`：返回在T的前序遍历中p之后访问的位置（如果p是最后一个节点，则返回null）。  
- `inorderNext(p)`：返回在T的中序遍历中p之后访问的位置（如果p是最后一个节点，则返回null）。  
用Java/Python编写代码测试你的解决方案。  
你的算法的最坏时间复杂度是多少？  

**如果你的名字首字母在K-Z之间（包含K和Z）：**  
为二叉树T设计以下操作的算法和方法：  
- `inorderNext(p)`：返回在T的中序遍历中p之后访问的位置（如果p是最后一个节点，则返回null）。  
- `postorderNext(p)`：返回在T的后序遍历中p之后访问的位置（如果p是最后一个节点，则返回null）。  
用Java/Python编写代码测试你的解决方案。  
你的算法的最坏时间复杂度是多少？  
（5分）  

**[练习2]**  
给出一个高效算法，计算并打印树T中每个位置p的元素及其子树的高度。用Java/Python编写代码测试你的解决方案。  
**提示**：使用后序遍历计算每个子树的高度。如果p是叶子节点，则高度为0；否则，高度为子节点最大高度加1。在后序遍历访问时打印p的元素及其高度。  
（3分）  

**[练习3]**  
**如果你的名字首字母在A-J之间（包含A和J）：**  
给出HeapPriorityQueue的`upheap`方法的递归实现（不使用循环）。  
**提示**：执行一次向上交换，然后递归调用（如果需要）。  

**如果你的名字首字母在K-Z之间（包含K和Z）：**  
使用Java数组重新实现SortedPriorityQueue，确保`removeMin`的时间复杂度为O(1)。  
（2分）  

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
- Eclipse项目命名格式：`YourFullname_COMP254Labnumber`（例如：`JohnSmith_COMP254Lab1`）。  
- 包名格式：`com.exercisenumber.yourfirstname.yourlastname`（例如：`com.exercise1.john.smith`）。  
- 在每个练习的main方法顶部注释中提供学号和全名。  
- 将项目压缩为zip文件，命名格式：`YourFullname_COMP254Labnumber.zip`（例如：`JohnSmith_COMP254Lab1.zip`）。  
- 通过eCentennial的作业链接上传zip文件。  

---

### 2. 解题思路  

#### **练习1**  
**目标**：实现二叉树中指定遍历顺序的下一个节点查找方法。  

**思路**：  
1. **前序遍历（Preorder）**：根→左→右。  
   - 如果p有左子节点，下一个节点是左子节点。  
   - 如果没有左子节点但有右子节点，下一个节点是右子节点。  
   - 如果没有子节点，需回溯到最近的祖先节点，其右子树未被遍历。  

2. **中序遍历（Inorder）**：左→根→右。  
   - 如果p有右子节点，下一个节点是右子树的最左节点。  
   - 如果没有右子节点，需回溯到最近的祖先节点，且p是该祖先的左子节点。  

3. **后序遍历（Postorder）**：左→右→根。  
   - 如果p是父节点的右子节点或父节点无右子节点，下一个节点是父节点。  
   - 如果p是父节点的左子节点且父节点有右子节点，下一个节点是右子树的最左叶子节点。  

**时间复杂度**：  
- 最坏情况下需遍历整棵树，时间复杂度为O(n)。  

**实现步骤**：  
- 定义二叉树节点类（包含左、右子节点和父节点指针）。  
- 实现遍历方法，根据遍历顺序查找下一个节点。  

---

#### **练习2**  
**目标**：计算并打印树中每个节点的元素及其子树高度。  

**思路**：  
1. **后序遍历**：适合计算子树高度，因为需要先处理子节点再处理父节点。  
2. **递归计算高度**：  
   - 叶子节点高度为0。  
   - 非叶子节点高度为子节点最大高度加1。  
3. **打印信息**：在后序遍历访问节点时打印节点元素和高度。  

**实现步骤**：  
- 定义树的节点结构。  
- 实现后序遍历方法，在访问节点时计算并打印高度。  

---

#### **练习3**  
**目标A（首字母A-J）**：递归实现`upheap`方法。  
- **思路**：  
  - 比较当前节点与父节点，若违反堆性质则交换。  
  - 递归调用`upheap`，直到根节点或无需交换为止。  

**目标B（首字母K-Z）**：用Java数组实现SortedPriorityQueue，保持`removeMin`为O(1)。  
- **思路**：  
  - 使用有序数组存储元素，最小值在数组首部。  
  - `insert`操作需维护有序性（O(n)时间），`removeMin`直接删除首元素（O(1)时间）。  

**实现步骤**：  
- 定义优先队列类，使用数组存储元素。  
- 实现插入时排序逻辑和删除时直接移除首元素。  

--- 

以上思路结合代码实现即可完成作业。