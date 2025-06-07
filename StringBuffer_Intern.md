# 🧵 Java String intern() Method & StringBuffer – Interview Revision

A comprehensive guide to master String-related concepts for Java interviews.

## 🔍 String `intern()` Method

### What is `intern()`?
The `intern()` method returns a **canonical representation** of the string object. It returns a string from the **String Constant Pool** if it already exists, or adds it to the pool if it doesn't exist.

### Why use `intern()`?
- ✅ **Memory optimization** – stores only one copy of identical strings
- ✅ **Faster comparisons** – enables `==` comparison instead of `.equals()`
- ✅ **Reduced object creation** – reuses existing string literals

### How it works:
```java
String s1 = new String("hello");  // Creates object in heap
String s2 = "hello";              // String literal in pool
String s3 = new String("hello").intern(); // Interned string

System.out.println(s1 == s2);            // false (heap vs pool)
System.out.println(s1.intern() == s2);   // true (both reference pool)
System.out.println(s2 == s3);            // true (both in pool)
```

### Performance Considerations:
```java
// Without intern() - creates multiple objects
for(int i = 0; i < 1000; i++) {
    String str = new String("duplicate");
}

// With intern() - reuses single object
for(int i = 0; i < 1000; i++) {
    String str = new String("duplicate").intern();
}
```

### Real-World Usage:
- **Compilers & Parsers** – for keyword and identifier management
- **Configuration files** – when same keys appear frequently
- **Large applications** – where many identical strings are processed

---

## 🔄 StringBuffer vs StringBuilder

### StringBuffer Overview
A **mutable**, **thread-safe** class for string manipulation operations.

### Key Differences:

| Feature | StringBuffer | StringBuilder | String |
|---------|-------------|---------------|---------|
| **Mutability** | ✅ Mutable | ✅ Mutable | ❌ Immutable |
| **Thread Safety** | ✅ Synchronized | ❌ Not synchronized | ✅ Immutable (inherently safe) |
| **Performance** | 🚫 Slower | ⚡ Fastest | 🐢 Slowest for concatenation |
| **Best For** | Multi-threaded env | Single-threaded env | Static content |
| **Memory** | Efficient | Most efficient | Creates new objects |

### Essential Methods:
```java
StringBuffer sb = new StringBuffer("Java");

// Core operations
sb.append(" Programming");        // Java Programming
sb.insert(5, "Advanced ");        // Java Advanced Programming  
sb.delete(5, 14);                // Java Programming
sb.replace(5, 16, "Development"); // Java Development
sb.reverse();                     // tnempoleveD avaJ

// Utility methods
sb.length();                      // Current length
sb.capacity();                    // Current capacity
sb.charAt(0);                     // Character at index
sb.substring(0, 4);              // Extract substring
String result = sb.toString();    // Convert to String
```

### Performance Comparison:
```java
// Poor performance - creates multiple String objects
String result = "";
for(int i = 0; i < 1000; i++) {
    result += "text" + i;  // Creates new String each time
}

// Better performance - single mutable object
StringBuilder sb = new StringBuilder();
for(int i = 0; i < 1000; i++) {
    sb.append("text").append(i);
}
String result = sb.toString();

// Thread-safe version
StringBuffer sbf = new StringBuffer();
for(int i = 0; i < 1000; i++) {
    sbf.append("text").append(i);
}
String result = sbf.toString();
```

### Capacity Management:
```java
StringBuffer sb = new StringBuffer(50); // Initial capacity
System.out.println(sb.capacity()); // 50

sb.append("This is a very long string that exceeds initial capacity");
System.out.println(sb.capacity()); // Automatically expanded
```

---

## 📊 Complete Comparison Matrix

| Operation | String | StringBuilder | StringBuffer |
|-----------|---------|---------------|--------------|
| **Creation** | `String s = "text"` | `new StringBuilder()` | `new StringBuffer()` |
| **Concatenation** | `s1 + s2` (slow) | `sb.append()` (fast) | `sb.append()` (moderate) |
| **Thread Safety** | Immutable | Not thread-safe | Thread-safe |
| **Memory Usage** | High (new objects) | Low | Low |
| **When to Use** | Static strings | Single-threaded apps | Multi-threaded apps |

---

## ✅ Interview Tips & Best Practices

### Memory Optimization:
- Use `intern()` when processing many identical strings from external sources
- Prefer `StringBuilder` over `StringBuffer` unless thread safety is required
- Avoid string concatenation with `+` in loops

### Comparison Guidelines:
- Always use `.equals()` for string content comparison
- Use `==` only when both strings are guaranteed to be interned
- Consider `Objects.equals()` for null-safe comparisons

### Performance Tips:
```java
// ❌ Avoid this pattern
String result = "";
for(String item : list) {
    result += item + " ";
}

// ✅ Use this instead
StringBuilder sb = new StringBuilder();
for(String item : list) {
    sb.append(item).append(" ");
}
String result = sb.toString();
```

### Common Interview Questions:
1. **"What happens when you create a string with `new String()`?"**
   - Creates object in heap, not in string pool
   
2. **"When would you use `intern()`?"**
   - When memory optimization is critical and many duplicate strings exist
   
3. **"StringBuffer vs StringBuilder - which is faster?"**
   - StringBuilder is faster due to lack of synchronization overhead

---

## 🎯 Quick Reference for Interviews

### String Pool Behavior:
```java
String s1 = "hello";              // Pool
String s2 = "hello";              // Pool (same reference)
String s3 = new String("hello");  // Heap
String s4 = s3.intern();          // Pool (same as s1, s2)

System.out.println(s1 == s2);     // true
System.out.println(s1 == s3);     // false  
System.out.println(s1 == s4);     // true
```

### Thread Safety Example:
```java
// Thread-safe operation
StringBuffer sb = new StringBuffer();
// Multiple threads can safely call sb.append()

// Not thread-safe
StringBuilder sb2 = new StringBuilder();
// Requires external synchronization for multi-threaded access
```

Remember: Choose the right tool for the job – String for immutable content, StringBuilder for single-threaded performance, and StringBuffer when thread safety is essential!

🚀 **Good luck with your interviews!**