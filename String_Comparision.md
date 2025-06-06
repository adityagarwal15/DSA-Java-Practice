### 📄 `String_Comparison_Java.md`

````md
# 🔁 String Comparison in Java

Understanding how strings work in Java is crucial to avoid subtle bugs during comparison. This guide summarizes the difference between `==` and `.equals()` with examples.

---

## ✨ Basic String Declaration

```java
String s1 = "tony";
String s2 = "tony";
String s3 = new String("tony");
````

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

* `s1` and `s2` are both **string literals**.
* Java stores string literals in the **String Pool**, and reuses the same memory reference for identical literals.
* So `s1 == s2` compares **reference** and returns `true`.

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

* `s3` is created using `new`, so it creates a **new object in heap memory**, not the pool.
* Hence `s1` and `s3` have **different references**.

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

* `.equals()` checks the **content/value** of the strings, not the memory reference.

---

## 🧠 Key Takeaways

| Operation   | Checks For      | Use When                   |
| ----------- | --------------- | -------------------------- |
| `==`        | Reference match | Memory location comparison |
| `.equals()` | Value match     | Actual content comparison  |

---

## 🚫 Common Mistakes

* ❌ Using `==` to compare strings for content.
* ❌ Forgetting that `new String()` creates a new object.

---

## 🧪 Final Example Code

```java
public class CompareStrings {
    public static void main(String[] args) {
        String s1 = "tony";
        String s2 = "tony";
        String s3 = new String("tony");

        if (s1 == s2) {
            System.out.println("s1 == s2: Same");
        } else {
            System.out.println("s1 == s2: Not same");
        }

        if (s1 == s3) {
            System.out.println("s1 == s3: Same");
        } else {
            System.out.println("s1 == s3: Not same");
        }

        if (s1.equals(s3)) {
            System.out.println("s1.equals(s3): Same");
        } else {
            System.out.println("s1.equals(s3): Not same");
        }
    }
}
```

---

## 📌 Pro Tip

For strings, **always prefer `.equals()`** unless you're specifically testing **reference identity** (e.g., for interned strings).

---


