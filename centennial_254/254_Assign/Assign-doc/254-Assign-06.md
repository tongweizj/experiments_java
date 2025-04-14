**Lab Assignment #6 – Using Maps and Hash Tables**

## Due Date:     Friday, Week 11

## Purpose
The purpose of this Lab assignment is to:

·      Design algorithms that describe operations on ADT Maps
·      Investigate the efficiency of hash table implementations
·      Implement and test appropriate methods in Java or Python
· 设计描述 ADT Map 操作的算法
· 研究哈希表实现的效率
· 用 Ja​​va 或 Python 实现并测试适当的方法
## References
Read the course’s text chapter 10 and the lecture slides. 
This material provides the necessary information that you need to complete the exercises.

Be sure to read the following general instructions carefully:
- This assignment must be completed individually by all the students.
- See the naming and submission rules at the end of this document

## **Exercise 1**

**If your first name starts with a letter from A-J inclusively:**

Our _AbstractHashMap_ class maintains a load factor l ≤ 0.5. Reimplement that class to allow the user to specify the maximum load, and adjust the concrete subclasses accordingly.

Perform experiments on our _ProbeHashMap_ classes to measure its efficiency using random key sets and varying limits on the load factor. Do you think ProbeHashMap is better or ChainHashMap? When and how?

**Hint** The load factor can be controlled from within the abstract class, but there must be means for setting the parameter (either through the constructor, or a new method).

Write a Java/Python application to test your solution.

### 作业
**If your first name starts with a letter from K-Z inclusively:**                                                                  
Our _AbstractHashMap_ class maintains a load factor l ≤ 0.5. Reimplement that class to allow the user to specify the maximum load, and adjust the concrete subclasses accordingly.
我们的 _AbstractHashMap_ 类保持负载因子 l ≤ 0.5。
重新实现该类以允许用户指定最大负载，并相应地调整具体子类。

Perform experiments on our _ChainHashMap_ classes to measure its efficiency using random key sets and varying limits on the load factor. 

Do you think ProbeHashMap is better or ChainHashMap? 

When and how?
您认为 ProbeHashMap 更好还是 ChainHashMap 更好？何时以及如何？


**Hint** The load factor can be controlled from within the abstract class, but there must be means for setting the parameter (either through the constructor, or a new method).

**提示** 可以从抽象类内部控制负载因子，但必须有设置参数的方法（通过构造函数或新方法）。


Write a Java/Python application to test your solution                                                                                                  (7 marks)





编写一个 Java/Python 应用程序来测试您的解决方案                                                                                                           （7 分）
## **Exercise 2**

**If your first name starts with a letter from A-J inclusively:**

The use of **null** values in a map is problematic, as there is then no way to differentiate whether a **null** value returned by the call get(k) represents the legitimate value of an entry (k, null), or designates that key k was not found. The java.util.Map interface includes a boolean method, _containsKey(k)_, that resolves any such ambiguity.

Implement the _containKey(k)_ method for the _SortedTableMap_ class. **Hint:** Use the existing _findIndex(k)_ method.

Write a Java/Python application to test your solution.

## **If your first name starts with a letter from K-Z inclusively:**

Implement the _containKey(k)_ method for the _UnSortedTab__leMap_ class. **Hint:** Use the existing _findIndex(k)_ method.
为 _UnSortedTab__leMap_ 类实现 _containKey(k)_ 方法。**提示：**使用现有的 _findIndex(k)_ 方法。


Write a Java/Python application to test your solution.

(3 marks)

**Evaluation:**

|   |   |
|---|---|
|**Functionality:**<br><br>-       Correct implementation of requirements<br><br>-       Code demonstration and brief explanation in a short video|70%<br><br>10%|
|**Object-Oriented design**:<br><br>-       Correct design of classes and methods similarly to chapter 3 examples.<br><br>-       Correct use of generics<br><br>-       Correct use of naming guidelines for classes, variables, methods.|15%<br><br>5%|
|**Total**|100%|

**Naming and Submission Rules:**

You must **name your Eclipse project** according to the following rule:

**YourFullname_COMP254Labnumber**. Example: **JohnSmith_COMP254Lab1**

You must name package names **com.exercisenumber.yourfirstname.yourlastname**, for example: com.exercise1.john.smith

Provide your **student number and full name as a comment** at the top of main method for each exercise.

**Archive your project in a zip file** named according to the following rule:

**YourFullname_COMP254Labnumber.zip**

Example: **JohnSmith_COMP254Lab1.zip**

Upload the zip file on eCentennial using the Assignment link.

下面给出对文档的详细中英文对照翻译以及对题目解题思路的分析。

---

## 一、文档中英对照翻译

### 标题及基本信息
**English:**  
Data Structures and Algorithms  
COMP-254

Lab Assignment #6 – Using Maps and Hash Tables

Due Date:	Friday, Week 11 

**中文：**  
数据结构与算法  
COMP-254

实验作业 #6 – 使用映射（Maps）和散列表（Hash Tables）

截止日期：第11周，星期五

---

### 实验目的
**English:**  
Purpose: The purpose of this Lab assignment is to:
- Design algorithms that describe operations on ADT Maps
- Investigate the efficiency of hash table implementations
- Implement and test appropriate methods in Java or Python

**中文：**  
目的：该实验作业的目的是：
- 设计描述抽象数据类型（ADT）映射操作的算法
- 探究散列表实现的效率
- 用 Java 或 Python 实现并测试相关方法

---

### 参考文献
**English:**  
References: Read the course’s text chapter 10 and the lecture slides. This material provides the necessary information that you need to complete the exercises.

**中文：**  
参考文献：请阅读课程教材第10章以及讲义幻灯片。这些资料提供了完成实验所需的必要信息。

---

### 通用说明
**English:**  
Be sure to read the following general instructions carefully:
- This assignment must be completed individually by all the students.
- See the naming and submission rules at the end of this document

**中文：**  
请务必仔细阅读以下通用说明：
- 本实验作业必须由每位学生独立完成。
- 请参照本文档末尾的命名和提交规则

---

### Exercise 1
**English:**  
If your first name starts with a letter from A-J inclusively:

Our AbstractHashMap class maintains a load factor l ≤ 0.5. Reimplement that class to allow the user to specify the maximum load, and adjust the concrete subclasses accordingly.

Perform experiments on our ProbeHashMap classes to measure its efficiency using random key sets and varying limits on the load factor. Do you think ProbeHashMap is better or ChainHashMap? When and how?

*Hint:* The load factor can be controlled from within the abstract class, but there must be means for setting the parameter (either through the constructor, or a new method).

Write a Java/Python application to test your solution.

If your first name starts with a letter from K-Z inclusively:

Our AbstractHashMap class maintains a load factor l ≤ 0.5. Reimplement that class to allow the user to specify the maximum load, and adjust the concrete subclasses accordingly.

Perform experiments on our ChainHashMap classes to measure its efficiency using random key sets and varying limits on the load factor. Do you think ProbeHashMap is better or ChainHashMap? When and how?

*Hint:* The load factor can be controlled from within the abstract class, but there must be means for setting the parameter (either through the constructor, or a new method).

Write a Java/Python application to test your solution														(7 marks)

**中文：**  
练习 1

如果你的名字首字母在 A-J 范围内（包括 A 和 J）：

我们的 AbstractHashMap 类维持了一个载入因子 l ≤ 0.5。请重新实现该类，允许用户指定最大的载入因子，并相应地调整具体的子类。

对我们的 ProbeHashMap 类进行实验，通过随机键集合和不同的载入因子限制来测量其效率。你认为 ProbeHashMap 比 ChainHashMap 更好吗？在什么情况下，以及怎么比较？

*提示：* 载入因子可以在抽象类内部控制，但必须提供设置该参数的方法（可以通过构造函数或者添加新方法）。

编写一个 Java/Python 应用程序来测试你的解决方案。

如果你的名字首字母在 K-Z 范围内（包括 K 和 Z）：

我们的 AbstractHashMap 类维持了一个载入因子 l ≤ 0.5。请重新实现该类，允许用户指定最大的载入因子，并相应地调整具体的子类。

对我们的 ChainHashMap 类进行实验，通过随机键集合和不同的载入因子限制来测量其效率。你认为 ProbeHashMap 比 ChainHashMap 更好吗？在什么情况下，以及怎么比较？

*提示：* 载入因子可以在抽象类内部控制，但必须提供设置该参数的方法（可以通过构造函数或者添加新方法）。

编写一个 Java/Python 应用程序来测试你的解决方案														(7 分)

---

### Exercise 2
**English:**  
If your first name starts with a letter from A-J inclusively:

The use of null values in a map is problematic, as there is then no way to differentiate whether a null value returned by the call get(k) represents the legitimate value of an entry (k, null), or designates that key k was not found. The java.util.Map interface includes a boolean method, containsKey(k), that resolves any such ambiguity.

Implement the containKey(k) method for the SortedTableMap class. *Hint:* Use the existing findIndex(k) method.

Write a Java/Python application to test your solution.

If your first name starts with a letter from K-Z inclusively:

Implement the containKey(k) method for the UnSortedTableMap class. *Hint:* Use the existing findIndex(k) method.

Write a Java/Python application to test your solution.

(3 marks)

**中文：**  
练习 2

如果你的名字首字母在 A-J 范围内（包括 A 和 J）：

在映射（map）中使用 null 值存在问题，因为当调用 get(k) 返回 null 时，我们无法区分这个 null 值是表示键 k 对应的合法值 (k, null) 还是说明键 k 未被找到。java.util.Map 接口提供了一个 boolean 类型的方法 containsKey(k) 来解决这种歧义。

请为 SortedTableMap 类实现 containsKey(k) 方法。*提示：* 使用已有的 findIndex(k) 方法。

编写一个 Java/Python 应用程序来测试你的解决方案。

如果你的名字首字母在 K-Z 范围内（包括 K 和 Z）：

请为 UnSortedTableMap 类实现 containsKey(k) 方法。*提示：* 使用已有的 findIndex(k) 方法。

编写一个 Java/Python 应用程序来测试你的解决方案。

(3 分)

---

### 评价标准
**English:**  
Evaluation: 
- Functionality:
  - Correct implementation of requirements
  - Code demonstration and brief explanation in a short video  
  70%
  
- Object-Oriented design: 
  - Correct design of classes and methods similarly to chapter 3 examples.
  - Correct use of generics
  - Correct use of naming guidelines for classes, variables, methods.
  15%
  
- Total: 100%

**中文：**  
评价标准：
- 功能性：
  - 正确实现要求
  - 代码展示以及一个简短视频中的简要解释  
  70%
  
- 面向对象设计：
  - 类和方法的设计符合第3章示例的要求。
  - 正确使用泛型
  - 正确使用类、变量、方法的命名规范  
  15%
  
- 总分：
  100%

---

### 命名和提交规则
**English:**  
Naming and Submission Rules:

You must name your Eclipse project according to the following rule:
YourFullname_COMP254Labnumber. Example: JohnSmith_COMP254Lab1

You must name package names com.exercisenumber.yourfirstname.yourlastname, for example: com.exercise1.john.smith

Provide your student number and full name as a comment at the top of main method for each exercise.

Archive your project in a zip file named according to the following rule: 
YourFullname_COMP254Labnumber.zip

Example: JohnSmith_COMP254Lab1.zip

Upload the zip file on eCentennial using the Assignment link.

**中文：**  
命名和提交规则：

你的 Eclipse 项目名称必须按照以下规则命名：
YourFullname_COMP254Labnumber。例如：JohnSmith_COMP254Lab1

你的包名应命名为：com.exercisenumber.yourfirstname.yourlastname，例如：com.exercise1.john.smith

在每个练习的 main 方法顶部以注释的形式注明你的学号和全名。

将你的项目压缩为 zip 文件，并按照以下规则命名：
YourFullname_COMP254Labnumber.zip

例如：JohnSmith_COMP254Lab1.zip

使用 Assignment 链接将 zip 文件上传至 eCentennial。

---

**页脚/页码说明：**

**English:**  
Lab #6  
Page 1 of 1

**中文：**  
实验 #6  
第1页，共1页

---

## 二、题目的解题思路

下面针对两个练习分别给出详细解题思路和建议：

### 练习1：关于 AbstractHashMap 类与不同 HashMap 实现的实验

1. **理解基本要求：**  
   - 目标是将现有的 AbstractHashMap 类中硬编码的载入因子（load factor ≤ 0.5）改为由用户指定。  
   - 然后，通过实验对两种不同的散列表实现（ProbeHashMap 与 ChainHashMap）进行效率比较。

2. **基本实现步骤：**  
   - **修改 AbstractHashMap：**  
     - 增加一个可配置的成员变量来保存最大载入因子。  
     - 通过构造函数或新方法（例如 setLoadFactor(double maxLoad)）让用户能够指定载入因子。  
     - 确保所有子类（ProbeHashMap 或 ChainHashMap）在扩容或者处理碰撞时正确地参考这个新参数。  
       
   - **调整具体子类：**  
     - 对于 A-J 字母的同学：主要修改 ProbeHashMap。  
     - 对于 K-Z 字母的同学：主要修改 ChainHashMap。  
     - 注意在扩展数组或重新哈希时，比较载入因子与用户设定的最大值，决定是否需要扩容及调整结构。

3. **性能实验设计：**  
   - **构造实验数据：**  
     - 使用随机生成的键集合。  
     - 设置不同的载入因子上限（如 0.3, 0.5, 0.7 等）以观察性能变化。  
   - **实验指标：**  
     - 记录插入、查找和删除操作的时间消耗。  
     - 分析不同载入因子配置下，两种实现（ProbeHashMap 与 ChainHashMap）的响应速度和扩容次数。  
   - **比较分析：**  
     - 说明在哪些情况下哪种实现有较优性能，比如探测散列在低载入因子下可能更高效，而链式散列则在高载入情况下表现稳定。

4. **编写测试应用程序：**  
   - 用于创建大量随机数据并执行操作，输出统计结果。  
   - 可以借助计时器记录每次操作的执行时间，最终以图表或汇总数据展示结果。

5. **注意事项：**  
   - 保证代码的健壮性，考虑边界情况（例如，当载入因子达不到指定值时如何处理等）。
   - 在代码和文档中清楚注明用户如何设置新的载入因子参数。

---

### 练习2：实现 containsKey 方法

1. **问题背景：**  
   - 映射中可能出现键存在但值为 null 的情况，单靠 get(k) 返回 null 无法判断是合法的 null 值还是键不存在。  
   - 因此，Java 的 Map 接口提供了 containsKey(k) 方法以消除这种歧义。

2. **实现方法（基于已有方法 findIndex）：**  
   - **对 SortedTableMap（A-J 字母的同学）：**  
     - 利用 findIndex(k) 方法来查找键 k 的索引。  
     - 如果返回的索引有效且对应的键与 k 相等，则返回 true；否则返回 false。  
   - **对 UnSortedTableMap（K-Z 字母的同学）：**  
     - 同样使用 findIndex(k) 方法进行查找。  
     - 对于无序表，依然比较索引位置的键来确认是否存在。

3. **测试程序：**  
   - 编写测试用例，分别验证当键存在但值为 null的情况、键不存在的情况、以及一般情况下包含键的判断。  
   - 通过调用 containsKey(k) 方法确保其返回值与预期一致。

4. **注意事项：**  
   - 确保代码鲁棒性：在 findIndex 返回无效索引时，正确处理避免数组越界。  
   - 注重代码注释，详细说明为何选择使用 findIndex 方法。

---

## 三、总结

**English Summary:**  
The assignment focuses on enhancing the flexibility of a hash table implementation by allowing a dynamic load factor and experimentally comparing the performance of different hash table designs (ProbeHashMap vs. ChainHashMap), as well as implementing a reliable containsKey method to handle null values in maps.

**中文总结：**  
本实验作业重点在于增强散列表的灵活性，通过允许用户指定动态载入因子以及对不同散列实现（ProbeHashMap 和 ChainHashMap）的性能比较进行实验，同时实现 containsKey 方法以可靠地处理映射中 null 值的问题。

以上就是本次实验文档的中英文对照翻译和各题目的详细解题思路。希望这能帮助你更好地理解要求和规划解决方案。