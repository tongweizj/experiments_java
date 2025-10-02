##  load factor                                
Our _AbstractHashMap_ class maintains a load factor l ≤ 0.5. Reimplement that class to allow the user to specify the maximum load, and adjust the concrete subclasses accordingly.
我们的 _AbstractHashMap_ 类保持负载因子 l ≤ 0.5。
重新实现该类以允许用户指定最大负载，并相应地调整具体子类。

## 性能实验

Perform experiments on our _ChainHashMap_ classes to measure its efficiency using 
- random key sets 
- and varying limits on the load factor. 

对我们的 _ChainHashMap_ 类进行实验，
使用随机键集合和不同的负载因子限制，来衡量其效率。

Do you think ProbeHashMap is better or ChainHashMap? 

When and how?
您认为 ProbeHashMap 更好还是 ChainHashMap 更好？何时以及如何？


**Hint** 
The load factor can be controlled from within the abstract class, 
but there must be means for setting the parameter (either through the constructor, or a new method).

**提示** 可以从抽象类内部控制负载因子，但必须有设置参数的方法（通过构造函数或新方法）。


Write a Java/Python application to test your solution              

---


这道题考察的是对
- 哈希表负载因子的理解、
- Java面向对象编程技巧（如抽象类与继承）、
- 以及通过实验对不同哈希策略（开放寻址 vs 链式寻址）效率的比较。
 
我们可以从以下几个方面来分析这道题：

---

### 🧩 一、功能性要求分析

#### 1. 默认负载因子
- 题目提到现有的 `AbstractHashMap` 保持 `l ≤ 0.5`，这表示：
  - 每当哈希表的元素数量超过容量的 50%，就会触发 `resize()` 操作（扩容和再散列）。

#### 2. 目标需求
- 需要**允许用户指定最大负载因子**，不再固定为 0.5：
  - 可以通过构造函数参数或 setter 方法传入。
  - 该值应该存储为类的成员变量，例如 `protected double maxLoadFactor;`。
  - `put()` 和 `resize()` 的触发逻辑也要依赖于这个变量。

#### 3. 子类适配
- `ChainHashMap` 和 `ProbeHashMap` 是 `AbstractHashMap` 的子类：
  - 子类的构造函数也要支持向父类传递最大负载因子。
  - 或者父类有 setter 方法，子类调用。

---

### 🧪 二、实验设计与测量指标

题目要求对 `ChainHashMap` 做实验，

#### 实验条件
常量: 使用**随机键集
变量: 不同负载因子限制**。

#### 目的
是观察负载因子如何影响性能。

#### 问题
ChainHashMap  和 AbstractHashMap 的关系

ChainHashMap 和 ProbeHashMap 比

#### 实验关键要素：
1. **数据结构：** 只要求实验 `ChainHashMap`，不是两者对比（虽然后面会问你哪个更好）。
2. **输入数据：** 随机生成的键值对（例如使用 UUID、随机整数等）。
3. **控制变量：** 
   - 最大负载因子值（例如 0.3, 0.5, 0.7, 0.9）
- 
1. **测量指标：**
   - `put()` 的耗时或操作次数
   - `get()` 的平均查找成本
   - `resize()` 的频率
   - 整体执行时间或空间消耗

---

### ⚔️ 三、Probe vs Chain：优劣比较（思考维度）

这是题目的开放性讨论部分。需要从以下角度去思考：

| 维度             | ChainHashMap                             | ProbeHashMap                             |
|------------------|------------------------------------------|-------------------------------------------|
| 查找性能         | 较稳定，冲突时通过链表管理               | 高负载时查找性能下降                      |
| 插入性能         | 插入快，冲突时加链表节点                 | 插入受限于空位查找策略（线性探测等）     |
| 空间利用率       | 较低，链表占用额外空间                   | 较高，元素都在数组内                     |
| 删除操作         | 简单，只需从链表中删除                   | 复杂，可能需要“标记删除”                 |
| 内存访问局部性   | 差（链表可能不连续）                     | 好（数组访问）                           |
| 最适负载因子范围 | 可以支持更高的负载因子（如 0.75）         | 一般建议不超过 0.5                        |

---

### 🛠 四、实现难点提示

- 父类与子类如何协作传递 load factor；
- `resize()` 方法中判断何时扩容的逻辑；
- 实验中如何控制变量、重复测试确保数据稳定。

---

你可以先尝试实现类的改动，然后再根据性能测试的数据来分析 ProbeHashMap 和 ChainHashMap 哪个更适合哪种场景。是否要我帮你出一份伪代码或者实验设计方案？