# 🔁 String Comparison in Java - Quick Interview Revision

**Critical concept that trips up 80% of Java interview candidates!**

---

## 🚨 The #1 String Comparison Trap

### ❌ Common Mistake:
```java
String s1 = "hello";
String s2 = new String("hello");

if (s1 == s2) {
    System.out.println("Equal");  // ❌ Never prints!
}
```

### ✅ Correct Approach:
```java
if (s1.equals(s2)) {
    System.out.println("Equal");  // ✅ Always prints!
}
```

---

## 🎯 Interview Question Patterns

### Q1: "What's the output of this code?"
```java
String s1 = "java";
String s2 = "java";
String s3 = new String("java");

System.out.println(s1 == s2);        // ?
System.out.println(s1 == s3);        // ?
System.out.println(s1.equals(s3));   // ?
```

**Answer:**
- `s1 == s2` → **true** (same reference in String Pool)
- `s1 == s3` → **false** (different references)
- `s1.equals(s3)` → **true** (same content)

### Q2: "Explain String Pool vs Heap"
```java
String literal = "hello";      // String Pool
String object = new String("hello");  // Heap memory

// literal and object have same content but different locations
```

---

## 📊 Quick Reference Table

| Operator | Checks | String Pool | new String() | Use Case |
|----------|--------|-------------|--------------|----------|
| `==` | Reference | ✅ Same ref | ❌ Different ref | Memory comparison |
| `.equals()` | Content | ✅ Same content | ✅ Same content | Value comparison |

---

## 🔧 Common Comparison Methods

### Basic Comparison
```java
String s1 = "Hello";
String s2 = "hello";

// Case-sensitive
s1.equals(s2);              // false

// Case-insensitive  
s1.equalsIgnoreCase(s2);    // true

// Lexicographic ordering
s1.compareTo(s2);           // negative (s1 < s2)
s1.compareToIgnoreCase(s2); // 0 (equal when ignoring case)
```

### Null-Safe Comparison
```java
String s1 = null;
String s2 = "hello";

// ❌ Throws NullPointerException
// s1.equals(s2);

// ✅ Safe approaches
Objects.equals(s1, s2);     // false (Java 7+)
"hello".equals(s1);         // false (known string first)
```

---

## 🚨 Interview Red Flags

### ❌ Don't Do This:
```java
// Comparing with ==
if (name == "John") { }

// Not handling nulls
if (str.equals("test")) { }  // Can throw NPE

// Inefficient null checks
if (str != null && str.equals("test")) { }
```

### ✅ Do This Instead:
```java
// Use equals for content
if ("John".equals(name)) { }

// Null-safe comparison
if (Objects.equals(str, "test")) { }

// Or use known string first
if ("test".equals(str)) { }
```

---

## 🏆 Advanced Interview Topics

### String Interning
```java
String s1 = "java";
String s2 = new String("java").intern();

System.out.println(s1 == s2);  // true (both in String Pool now)
```

### String Pool Behavior
```java
String s1 = "hello";
String s2 = "hello";           // Reuses s1's reference
String s3 = new String("hello"); // Creates new object
String s4 = s3.intern();       // Returns reference to pool

System.out.println(s1 == s2);  // true
System.out.println(s1 == s3);  // false  
System.out.println(s1 == s4);  // true
```

---

## 🎯 Problem-Solving Patterns

### Pattern 1: User Input Comparison
```java
Scanner sc = new Scanner(System.in);
String input = sc.nextLine();

// ✅ Correct way
if ("yes".equals(input.trim().toLowerCase())) {
    // Handle yes
}

// ❌ Wrong way
if (input == "yes") {  // Never works with user input
    // This won't execute
}
```

### Pattern 2: Array/List String Search
```java
String[] names = {"Alice", "Bob", "Charlie"};
String target = "Bob";

// ✅ Correct search
boolean found = false;
for (String name : names) {
    if (name.equals(target)) {
        found = true;
        break;
    }
}

// Or using streams
boolean found = Arrays.stream(names)
    .anyMatch(name -> name.equals(target));
```

### Pattern 3: Case-Insensitive Operations
```java
List<String> words = Arrays.asList("Hello", "WORLD", "Java");
String search = "hello";

// Find ignoring case
Optional<String> result = words.stream()
    .filter(word -> word.equalsIgnoreCase(search))
    .findFirst();
```

---

## 🧠 Memory Tricks

### **"SPACE" Method for String Comparison:**
- **S**tring Pool vs Heap location
- **P**ool reuses same reference for literals
- **A**lways use .equals() for content
- **C**heck for null before comparison
- **E**quals() checks value, == checks reference

### **Visual Memory:**
```
String Pool:    [java] ← s1, s2 point here
Heap Memory:    [java] ← s3 points here (different location)
```

---

## 🔥 Quick Practice Problems

### Problem 1: Password Validation
```java
public boolean validatePassword(String input) {
    String correctPassword = "secret123";
    
    // ✅ Correct
    return correctPassword.equals(input);
    
    // ❌ Wrong
    // return input == correctPassword;
}
```

### Problem 2: Menu Selection
```java
public void handleMenuChoice(String choice) {
    // ✅ Null-safe and case-insensitive
    if ("EXIT".equalsIgnoreCase(choice)) {
        System.out.println("Goodbye!");
    } else if ("HELP".equalsIgnoreCase(choice)) {
        System.out.println("Help menu");
    }
}
```

### Problem 3: String Deduplication
```java
public List<String> removeDuplicates(List<String> strings) {
    return strings.stream()
        .distinct()  // Uses .equals() internally
        .collect(Collectors.toList());
}
```

---

## 💡 Interview Success Tips

### When Explaining:
✅ **Say:** "I'll use .equals() to compare string content, not references"

✅ **Show:** Demonstrate understanding of String Pool vs Heap

✅ **Handle:** Always consider null values in your solution

### Common Follow-ups:
- **"What about performance?"** → String Pool is faster for literals
- **"How do you handle null?"** → Use Objects.equals() or check first
- **"Case sensitivity?"** → Use equalsIgnoreCase() when needed

---

## 🎯 Last-Minute Checklist

**Before coding interviews:**

- [ ] **Never use == for string content** comparison
- [ ] **Always use .equals()** for value comparison
- [ ] **Handle null values** with Objects.equals() or null checks
- [ ] **Use equalsIgnoreCase()** for case-insensitive needs
- [ ] **Understand String Pool** vs Heap memory locations
- [ ] **Know when to use .trim()** for user input

**Red flags to avoid:**
- Using == instead of .equals()
- Not handling null strings
- Forgetting case sensitivity issues
- Not trimming user input

**Ready to ace string comparison questions! 🚀**