# Java Methods Reference: `.indexOf()` vs `.valueOf()`

> **DSA Revision Notes** | Quick reference for common Java methods used in data structures and algorithms

---

## 🔹 `.indexOf()` Method

### ✅ Purpose:
Finds the **index/position** of a character, substring (in a `String`), or element (in a `List`).

### ✅ Belongs to:
- `String`
- `ArrayList`
- Other collections that implement `List`

### ✅ Syntax:

#### For `String`:
```java
int index = str.indexOf("substring");
```

#### For `ArrayList`:
```java
int index = list.indexOf(element);
```

### ✅ Returns:
- An `int` value:
  - If found → index of the first occurrence (0-based)
  - If **not found** → `-1`

### ✅ Examples:

#### 🔸 With `String`:
```java
String str = "Hello World";
int index = str.indexOf("World");
System.out.println(index); // Output: 6
```

#### 🔸 With `ArrayList`:
```java
import java.util.*;

ArrayList<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "mango"));
int index = fruits.indexOf("mango");
System.out.println(index); // Output: 2
```

#### 🔸 Not Found Case:
```java
int notFound = str.indexOf("Java");
System.out.println(notFound); // Output: -1
```

---

## 🔹 `.valueOf()` Method

### ✅ Purpose:
Converts **primitive types or objects** into their **String representation**.

### ✅ Belongs to:
- `String` class (as a static method)

### ✅ Syntax:
```java
String.valueOf(data);
```

### ✅ Returns:
- A `String` representing the passed value

### ✅ Common Use Cases:

| Input Type | Example | Output |
|------------|---------|--------|
| `int` | `String.valueOf(123)` | `"123"` |
| `double` | `String.valueOf(3.14)` | `"3.14"` |
| `boolean` | `String.valueOf(true)` | `"true"` |
| `char` | `String.valueOf('A')` | `"A"` |
| `Object` | `String.valueOf(obj)` | `obj.toString()` (or `"null"` if null) |

### ✅ Examples:
```java
int num = 100;
String strNum = String.valueOf(num);
System.out.println(strNum); // Output: "100"

boolean flag = false;
String strFlag = String.valueOf(flag);
System.out.println(strFlag); // Output: "false"
```

---

## 🔁 Quick Comparison Table

| Feature | `.indexOf()` | `.valueOf()` |
|---------|-------------|--------------|
| **Purpose** | Find index of an element or substring | Convert value to a string |
| **Returns** | `int` | `String` |
| **Used In** | `String`, `ArrayList`, etc. | `String` class |
| **Return -1?** | Yes (if not found) | No (always returns a String) |
| **Overloaded?** | Yes (for char, string, and index options) | Yes (for all primitive types) |

---

## 📝 Important Notes:
- `.indexOf()` is **case-sensitive** in `String`
- `.valueOf(null)` returns `"null"` only when using object references
- Both methods are commonly used in Java programming and interviews

## ✅ Pro Tip:
Use `.valueOf()` when you need explicit string conversion, though Java automatically converts primitives to String in most concatenation operations in modern versions.

---

## Time Complexity Notes:
- **String.indexOf()**: O(n*m) where n = string length, m = pattern length
- **ArrayList.indexOf()**: O(n) where n = list size
- **String.valueOf()**: O(1) for primitives, O(k) where k = string representation length

---
1. What does `"Hello".indexOf("l")` return?
2. What does `String.valueOf(42.5)` return?
3. How do you check if a substring exists in a string using `.indexOf()`?

**Answers:**
1. Returns `2` (first occurrence of 'l')
2. Returns `"42.5"`
3. Check if the result is not equal to `-1`: `str.indexOf("substring") != -1`