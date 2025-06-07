# 🧵 Java StringBuilder – Complete Revision Guide

`StringBuilder` is a mutable, efficient way to build or modify strings in Java. It avoids the overhead of creating new string objects, making it faster than `String` in many cases — especially in loops.

---

## 🚀 Why Use StringBuilder?

- `String` objects are **immutable** → any change creates a new object.
- `StringBuilder` is **mutable** → changes happen in the same object.
- More efficient for concatenation in **loops or dynamic strings**.

---

## 🛠️ How to Create a StringBuilder

```java
// Empty StringBuilder
StringBuilder sb = new StringBuilder();

// With initial value
StringBuilder sb = new StringBuilder("Hello");
````

---

## 🔁 Commonly Used Methods

| Method                   | Description                            |
| ------------------------ | -------------------------------------- |
| `append(str)`            | Adds string to the end                 |
| `insert(index, str)`     | Inserts string at a specific position  |
| `delete(start, end)`     | Deletes characters from start to end-1 |
| `deleteCharAt(index)`    | Deletes a single character             |
| `reverse()`              | Reverses the sequence                  |
| `toString()`             | Converts to `String`                   |
| `length()`               | Returns number of characters           |
| `charAt(index)`          | Returns character at index             |
| `setCharAt(index, char)` | Replaces character at index            |

---

## 🧪 Example 1: Basic Append and Print

```java
StringBuilder sb = new StringBuilder();
for (char ch = 'a'; ch <= 'z'; ch++) {
    sb.append(ch);
}
System.out.println(sb);  // abcdefghijklmnopqrstuvwxyz
```

---

## 🧪 Example 2: Insertion and Deletion

```java
StringBuilder sb = new StringBuilder("Hello");
sb.insert(1, 'i');          // Hiello
sb.delete(2, 4);            // Hilo
sb.setCharAt(0, 'J');       // Jilo
System.out.println(sb);    // Jilo
```

---

## 🧪 Example 3: Reverse a String

```java
StringBuilder sb = new StringBuilder("racecar");
sb.reverse();                // "racecar" (still the same, palindrome)
System.out.println(sb);
```

---

## 🧪 Example 4: String vs StringBuilder in Loops

```java
// ❌ Inefficient - new object each time
String str = "";
for (int i = 0; i < 1000; i++) {
    str += i;  // Slow
}

// ✅ Efficient - same object
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);  // Fast
}
```

---

## 🧠 Difference Between String, StringBuilder, StringBuffer

| Feature     | String          | StringBuilder        | StringBuffer          |
| ----------- | --------------- | -------------------- | --------------------- |
| Mutability  | Immutable       | Mutable              | Mutable               |
| Thread Safe | ❌ No            | ❌ No                 | ✅ Yes                 |
| Performance | Slow (in loops) | Fast (single thread) | Slower (synchronized) |

---

## 📝 Tip: Printing vs `toString()`

```java
StringBuilder sb = new StringBuilder("hello");
System.out.println(sb);             // ✅ hello
System.out.println(sb.toString());  // ✅ hello (explicit)
```

🧠 `.toString()` is **optional when printing**, but useful when:

* Returning values from methods
* Comparing content using `.equals()`
* Passing to functions expecting a `String`

---

## 📌 Best Practices

* Use `StringBuilder` in loops for better performance.
* Don't use `==` to compare content — use `.toString().equals(...)`.
* If multi-threading is involved, use `StringBuffer` (synchronized version).

---

## 🧪 Practice Challenge

Create a program that:

1. Takes a string input
2. Reverses it using `StringBuilder`
3. Checks if it’s a palindrome

```java
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder(input);
        String reversed = sb.reverse().toString();

        if (input.equals(reversed)) {
            System.out.println("Palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }
    }
}
```


