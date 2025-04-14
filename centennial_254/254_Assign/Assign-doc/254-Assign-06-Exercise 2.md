The use of **null** values in a map is problematic, as there is then no way to differentiate whether a **null** value returned by the call get(k) represents the legitimate value of an entry (k, null), or designates that key k was not found. 

The java.util.Map interface includes a boolean method, _containsKey(k)_, that resolves any such ambiguity.
在映射中使用 **null** 值是有问题的，因为无法区分调用 get(k) 返回的 **null** 值是代表条目 (k, null) 的合法值，还是表示未找到键 k。java.util.Map 
接口包含一个布尔方法 _containsKey(k)_，可解决任何此类歧义。

Implement the _containKey(k)_ method for the _SortedTableMap_ class. **Hint:** Use the existing _findIndex(k)_ method.

Write a Java/Python application to test your solution.


Implement the _containKey(k)_ method for the _UnSortedTab__leMap_ class. 


**Hint:** Use the existing _findIndex(k)_ method.
为 _UnSortedTab__leMap_ 类实现 _containKey(k)_ 方法。
**提示：**使用现有的 _findIndex(k)_ 方法。