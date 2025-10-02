Due Date:	Friday, Week 8 

## Purpose
The purpose of this Lab assignment is to:
本实验作业的目的是：
- Design algorithms  that describe operations on ADT stacks, queues, and lists
- Implement and test appropriate methods in Java or Python
- 设计描述 ADT 堆栈、队列和列表操作的算法
- 用 Ja​​va 或 Python 实现并测试适当的方法

### References
参考资料：
Read the course’s text chapter 6, 7 and the lecture slides. This material provides the necessary information that you need to complete the exercises.
阅读课程文本第 6、7 章和讲座幻灯片。这些材料提供了完成练习所需的必要信息。

Be sure to read the following general instructions carefully:
- This assignment must be completed individually by all the students.
请务必仔细阅读以下一般说明：
- 所有学生必须单独完成此作业。

## Exercise 1

If your first name starts with a letter from K-Z inclusively:
如果您的名字以字母 K-Z 开头：

Suppose we want to extend the PositionalList abstract data type with a method, findPosition(e), that returns the first position containing an element equal to e (or null if no such position exists). 
假设我们想用一个方法 findPosition(e) 扩展 PositionalList 抽象数据类型，该方法返回包含等于 e 的元素的第一个位置（如果不存在这样的位置，则返回 null）。

Implement this method using only existing methods of the PositionalList interface (not details of our LinkedPositionalList implementation). Write the necessary code to test the method. 
Hint: use the equals method to test equality.
 (5 marks)
仅使用 PositionalList 接口的现有方法（而不是 LinkedPositionalList 实现的细节）实现此方法。编写必要的代码来测试该方法。
提示：使用 equals 方法测试相等性。

## Exercise 2

If your first name starts with a letter from K-Z inclusively:
如果您的名字以 K-Z 字母开头：

Write a recursive method for removing all the elements from a stack S. Write the necessary code to test the method.
Hint: First check if the stack is already empty.
编写一个递归方法，用于从堆栈 S 中删除所有元素。
编写必要的代码来测试该方法。
提示：首先检查堆栈是否已为空。
## Exercise 3

Implement a method with signature concatenate(`LinkedQueue<E>` Q2) for the `LinkedQueue<E>` class that takes all elements of Q2 and appends them to the end of the original queue. The operation should run in O(1) time and should result in Q2 being an empty queue. Write the necessary code to test the method. 

为 `LinkedQueue<E>` 类实现一个签名为 concatenate(`LinkedQueue<E>` Q2) 的方法，该方法获取 Q2 的所有元素并将它们附加到原始队列的末尾。该操作应在 O(1) 时间内运行，并应导致 Q2 成为空队列。编写必要的代码来测试该方法。

Hint: You may just modify the SinglyLinkedList class to add necessary support. 
提示：您可以修改 SinglyLinkedList 类以添加必要的支持。

## Naming and Submission Rules:

You must name your Eclipse project according to the following rule:
YourFullname_COMP254Labnumber. Example: JohnSmith_COMP254Lab4
You must name package names com.exercisenumber.yourfirstname.yourlastname, for example: com.exercise1.john.smith
Provide your student number and full name as a comment at the top of main method for each exercise.

Archive your project in a zip file named according to the following rule: 
YourFullname_COMP254Labnumber.zip

Example: JohnSmith_COMP254Lab4.zip

Upload the zip file on eCentennial using the Assignment link.


---
下面是对《Lab Assignment #4》的作业要求分析，包括中文翻译和每道题的详细解题思路：

---

## 💡 总体信息
- **课程**：COMP-254 数据结构与算法
- **实验名称**：Lab Assignment #4 – 使用ADT栈、队列和链表
- **截止日期**：第8周星期五
- **目标**：
  - 设计描述ADT栈、队列、链表操作的算法；
  - 用Java或Python实现并测试这些方法。
- **参考资料**：课程教材第6、7章 + PPT讲义
- **注意事项**：本次作业必须独立完成。

---

## ✅ Exercise 1 （共5分）

### ✏️ 原文：
如果你的名字首字母在 **A-J**：

> 假设我们想为 PositionalList ADT 扩展一个方法 `indexOf(p)`，该方法返回位置 `p` 上的元素当前索引。只允许使用 `PositionalList` 接口的方法，而不能使用 `LinkedPositionalList` 的实现细节。

提示：在遍历列表直到遇到 `p` 的过程中计数。

如果你的名字首字母在 **K-Z**：

> 扩展 `PositionalList`，实现 `findPosition(e)` 方法，返回包含值等于 `e` 的第一个位置（找不到则返回 null）。同样只能用 `PositionalList` 的接口方法。

提示：用 `equals` 方法进行比较。

---

### ✅ 中文翻译：
- 如果你的名字是 A-J 开头，请实现 `indexOf(p)` 方法：返回位置 `p` 对应元素的索引（从头开始为0）。
- 如果你的名字是 K-Z 开头，请实现 `findPosition(e)` 方法：找到并返回第一个值等于 `e` 的位置。

---

### 🧠 解题思路：

#### 若你的名字是 A-J（实现 `indexOf(p)`）：

```java
public int indexOf(Position<E> p) {
    Position<E> current = list.first();
    int index = 0;
    while (current != null && current != p) {
        current = list.after(current);
        index++;
    }
    if (current == null) return -1; // p 不存在于列表中
    return index;
}
```

- 遍历链表从 `first()` 开始。
- 每一步比较 `current == p`，直到找到为止。
- 记录步数作为索引。

#### 若你的名字是 K-Z（实现 `findPosition(e)`）：

```java
public Position<E> findPosition(E e) {
    for (Position<E> p : list.positions()) {
        if (p.getElement().equals(e))
            return p;
    }
    return null;
}
```

- 用 `positions()` 遍历所有位置。
- 使用 `equals()` 方法逐个比较。
- 找到后立即返回。

---

## ✅ Exercise 2（共2分）

### ✏️ 原文：

**A-J首字母：**实现 `transfer(S, T)` 方法，将栈 `S` 中的元素全部转移到栈 `T`，使得 `S` 的栈顶成为 `T` 的栈底。

**K-Z首字母：**递归实现清空栈 `S` 的方法。

---

### ✅ 中文翻译：
- 如果你的名字是 A-J 开头，请实现将一个栈 `S` 逆序复制到另一个栈 `T` 的方法。
- 如果你的名字是 K-Z 开头，请实现一个递归方法，将栈 `S` 所有元素移除。

---

### 🧠 解题思路：

#### 若你是 A-J（实现 `transfer(S, T)`）：

```java
public void transfer(Stack<E> S, Stack<E> T) {
    Stack<E> temp = new ArrayStack<>();
    while (!S.isEmpty()) {
        temp.push(S.pop());
    }
    while (!temp.isEmpty()) {
        T.push(temp.pop());
    }
}
```

- 因为栈是后进先出，我们需要借助一个临时栈 `temp` 来保持顺序。
- 先把 `S` 全部 pop 到 `temp`。
- 然后从 `temp` push 到 `T`，顺序反转完成。

#### 若你是 K-Z（递归清空栈）：

```java
public void recursiveClear(Stack<E> S) {
    if (S.isEmpty()) return;
    S.pop();
    recursiveClear(S);
}
```

- 递归条件是栈为空。
- 每次递归调用 `pop()`。
- 不需要返回值。

---

## ✅ Exercise 3（共3分）

### ✏️ 原文：
实现 `LinkedQueue<E>` 中的 `concatenate(LinkedQueue<E> Q2)` 方法，将 `Q2` 的所有元素追加到当前队列末尾。时间复杂度应为 O(1)，且执行后 `Q2` 应变为空。

提示：你可能需要修改 `SinglyLinkedList` 类以支持此操作。

---

### ✅ 中文翻译：
- 实现一个队列拼接方法：将 `Q2` 所有元素连接到 `Q1`（原始队列）后面。
- 要求效率为 O(1)，即不能用逐个出入队的方式。
- 拼接后 `Q2` 为空。

---

### 🧠 解题思路：

```java
public void concatenate(LinkedQueue<E> Q2) {
    if (Q2.isEmpty()) return;

    this.tail.setNext(Q2.head.getNext()); // 连接两个队列的节点
    this.tail = Q2.tail; // 更新 tail 指针
    this.size += Q2.size;

    Q2.head.setNext(null); // 清空 Q2
    Q2.tail = Q2.head;
    Q2.size = 0;
}
```

- 假设队列由带 dummy head 的单链表实现。
- 将当前队列的尾部 `tail` 和 `Q2.head.next` 相连。
- 更新 `tail` 和 `size`。
- 清空 `Q2` 的头指针和大小。

---

## ✅ 提交和命名规则：

1. Eclipse项目命名：`YourFullName_COMP254Lab4`
2. 包名命名：`com.exercise1.firstname.lastname`（每题不同包）
3. 每个 `main()` 顶部添加注释：全名和学号
4. 项目压缩为 `.zip`：`YourFullName_COMP254Lab4.zip`
5. 上传到 eCentennial

---

需要我为你某题生成代码模板或测试用例吗？还是你想说一下你的名字首字母，我可以针对你要做的那一组详细展开代码。