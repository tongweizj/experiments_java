# 期末考试

1. 读题
   这是最重要的步骤
   要用翻译器，仔细读题！

2. 找出关键词：

原始数据结构
增加、修改什么功能
有什么特殊的要求

3. 找相同
读作业，找出类似的题目。
如果有，就找出作业的代码

4. 找不同
找出和原作业不同的地方， 这也就是要在原代码基础修改的地方



YourFullname_COMP254LabTest2. 

Example: JohnSmith_ COMP254LabTest2


WeiTong_COMP254LabTest2




## 第一题
下面给出中英文对照的翻译：

**English Original:**  
Write and test a linear-time Java/Python method for computing the sum of all leaf nodes/Positions of a tree T.  
Hint: Add the method to LinkedBinaryTree class and write the testing code in the main method.

**中文翻译：**  
编写并测试一个线性时间复杂度的 Java/Python 方法，用于计算树 T 中所有叶子节点（或叶子位置）的和。  
提示：将该方法添加到 LinkedBinaryTree 类中，并在 main 方法中编写测试代码。



Write and test a linear-time Java/Python method for computing the sum of all leaf nodes/Positions of a tree T. 

Hint: Add the method to LinkedBinaryTree class and write the testing code in the main method.

1. 把代码都搭建起来  LinkedBinaryTree
2. 写一个遍历，做sum
3. 测试
   1. 正常
   2. 创建一个tree
   3. 运用遍历得到和
   
   4. 异常
   5. 写一个空树，
   6. 运用遍历返回0




## Q2

The put(k,v) method is used to add an entry to a map. 
This method spends time to locate an existing item with the given key. Write an efficient version of this method, putOnlyIfNull(k,v), that adds the entry to the map only if there is null entry with a key k.

Provide Java/Python implementation of putOnlyIfNull(k,v) method for the SortedTableMap class. Write the testing code in the main method.

Hint: Your solution should make a single call to findIndex method, add the entry to the table if the key is null, otherwise return the existing value or say does not exist .

下面给出中英文对照翻译：

**English Original:**  
The put(k,v) method is used to add an entry to a map. This method spends time to locate an existing item with the given key. Write an efficient version of this method, putOnlyIfNull(k,v), that adds the entry to the map only if there is null entry with a key k.

Provide Java/Python implementation of putOnlyIfNull(k,v) method for the SortedTableMap class. Write the testing code in the main method.

Hint: Your solution should make a single call to findIndex method, add the entry to the table if the key is null, otherwise return the existing value or say does not exist.

**中文翻译：**  
put(k,v) 方法用于向Map中添加一个项。
该方法需要花费时间来定位具有给定键的现有项。

请编写此方法的高效版本 putOnlyIfNull(k,v)，只有当键 k 对应的项值为 null 时，才将该项添加到映射中。

请提供 SortedTableMap 类中 putOnlyIfNull(k,v) 方法的 Java/Python 实现，并在 main 方法中编写测试代码。

提示：你的解决方案应只调用一次 findIndex 方法，如果发现该键对应的值为 null，则将该项添加到表中，否则返回现有值或说明该项不存在。


##3 3

This exercise sorts collections using different Comparators. use an Item class.


Write a main() method for the QuickSort class. 

Create a queue of Item objects and sort them in **increasing order**. 

Populate the queue with several Item objects and then call the quicksort method. 

The Item class has the following instance variables:

int itemId;
String itemName
double itemPrice
Hint: itemPrice to compare Item objects.

QuickSort

本练习使用不同的比较器对集合进行排序。请使用 Item 类。

为 QuickSort 类编写 main() 方法。

创建一个 Item 对象队列，并按**升序**对其进行排序。

用多个 Item 对象填充队列，然后调用 quicksort 方法。

Item 类包含以下实例变量：

int itemId;
String itemName
double itemPrice
提示：itemPrice 用于比较 Item 对象。