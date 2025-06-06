# 🔁 String Comparison in Java

Understanding how strings work in Java is crucial to avoid subtle bugs during comparison. This guide summarizes the difference between `==` and `.equals()` with examples.

---

## ✨ Basic String Declaration

```java
String s1 = "tony";
String s2 = "tony";
String s3 = new String("tony");
```

---

## 🔍 Comparing Strings with `==`

```java
if (s1 == s2) {
    System.out.println("Same");
} else {
    System.out.println("Not same");
}
```

### ✅ Output:
```
Same
```

### ✅ Reason:
- `s1` and `s2` are both **string literals**.
- Java stores string literals in the **String Pool**, and reuses the same memory reference for identical literals.
- So `s1 == s2` compares **reference** and returns `true`.

---

## 🔍 Comparing Literal and `new String()`

```java
if (s1 == s3) {
    System.out.println("Same");
} else {
    System.out.println("Not same");
}
```

### ❌ Output:
```
Not same
```

### ❌ Reason:
- `s3` is created using `new`, so it creates a **new object in heap memory**, not the pool.
- Hence `s1` and `s3` have **different references**.

---

## ✅ Correct Way: Using `.equals()`

```java
if (s1.equals(s3)) {
    System.out.println("Same");
} else {
    System.out.println("Not same");
}
```

### ✅ Output:
```
Same
```

### ✅ Reason:
- `.equals()` checks the **content/value** of the strings, not the memory reference.

---

## 🧠 Key Takeaways

| Operation   | Checks For      | Use When                   |
|-------------|-----------------|----------------------------|
| `==`        | Reference match | Memory location comparison |
| `.equals()` | Value match     | Actual content comparison  |

---

## 🚫 Common Mistakes

- ❌ Using `==` to compare strings for content.
- ❌ Forgetting that `new String()` creates a new object.
- ❌ Not handling null values when using `.equals()`.

---

## 🛡️ Null-Safe String Comparison

```java
// Safe approach to avoid NullPointerException
String str1 = null;
String str2 = "hello";

// Method 1: Check for null first
if (str1 != null && str1.equals(str2)) {
    System.out.println("Equal");
}

// Method 2: Use Objects.equals() (Java 7+)
if (Objects.equals(str1, str2)) {
    System.out.println("Equal");
}

// Method 3: Use known non-null string first
if ("hello".equals(str1)) {
    System.out.println("Equal");
}
```

---

## 🔧 Additional String Comparison Methods

```java
String s1 = "Hello";
String s2 = "hello";

// Case-insensitive comparison
if (s1.equalsIgnoreCase(s2)) {
    System.out.println("Equal ignoring case"); // This will print
}

// Lexicographic comparison
int result = s1.compareTo(s2);
if (result == 0) {
    System.out.println("Strings are equal");
} else if (result < 0) {
    System.out.println("s1 comes before s2");
} else {
    System.out.println("s1 comes after s2");
}

// Case-insensitive lexicographic comparison
int resultIgnoreCase = s1.compareToIgnoreCase(s2);
```

---

## 🧪 Complete Example Code

```java
import java.util.Objects;

public class StringComparison {
    public static void main(String[] args) {
        String s1 = "tony";
        String s2 = "tony";
        String s3 = new String("tony");
        String s4 = null;

        // Reference comparison
        System.out.println("=== Reference Comparison (==) ===");
        System.out.println("s1 == s2: " + (s1 == s2));         // true
        System.out.println("s1 == s3: " + (s1 == s3));         // false

        // Content comparison
        System.out.println("\n=== Content Comparison (.equals()) ===");
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true

        // Null-safe comparison
        System.out.println("\n=== Null-Safe Comparison ===");
        System.out.println("Objects.equals(s1, s4): " + Objects.equals(s1, s4)); // false
        System.out.println("Objects.equals(s4, s4): " + Objects.equals(s4, s4)); // true

        // Case-insensitive comparison
        String upper = "TONY";
        System.out.println("\n=== Case-Insensitive Comparison ===");
        System.out.println("s1.equalsIgnoreCase(upper): " + s1.equalsIgnoreCase(upper)); // true
    }
}
```

---

## 📚 String Pool vs Heap Memory

```java
String literal1 = "java";          // Stored in String Pool
String literal2 = "java";          // Reuses same reference from pool
String object1 = new String("java"); // Creates new object in heap
String object2 = new String("java"); // Creates another new object in heap

System.out.println(literal1 == literal2); // true (same reference)
System.out.println(object1 == object2);   // false (different objects)
System.out.println(literal1 == object1);  // false (different locations)

// Force string to be added to pool
String interned = object1.intern();
System.out.println(literal1 == interned); // true (now same reference)
```

---

## 📌 Best Practices

1. **Always use `.equals()` for content comparison** - unless you specifically need reference comparison.
2. **Handle null values** - use `Objects.equals()` or check for null before calling `.equals()`.
3. **Use `.equalsIgnoreCase()`** for case-insensitive comparisons.
4. **Consider using `.trim()`** if whitespace might be an issue.
5. **Use `.compareTo()`** when you need lexicographic ordering.

---

## ⚡ Performance Notes

- String literals are automatically interned and stored in the String Pool.
- `new String()` always creates a new object, even if an identical string exists in the pool.
- `.intern()` can be used to manually add strings to the pool, but use carefully as it can cause memory issues.
- String Pool is stored in heap memory (Java 7+), previously in PermGen space.

---