# 🧵 Java StringBuilder – Quick Interview Revision

**Last-minute prep for StringBuilder questions in interviews and exams!**

---

## ⚡ Key Points to Remember

### Why StringBuilder?
- **String is immutable** → creates new objects on every change
- **StringBuilder is mutable** → modifies same object
- **10-100x faster** than String concatenation in loops

### When to Use?
- ✅ String building in loops
- ✅ Multiple string operations
- ✅ Dynamic content generation
- ❌ Single concatenation (String is fine)

---

## 🎯 Common Interview Questions

### Q1: "What's the difference between String, StringBuilder, and StringBuffer?"

| | String | StringBuilder | StringBuffer |
|---|---|---|---|
| **Mutable?** | ❌ Immutable | ✅ Mutable | ✅ Mutable |
| **Thread-safe?** | ✅ Yes | ❌ No | ✅ Yes |
| **Performance** | Slow (loops) | Fast | Moderate |
| **When to use?** | Static text | Single-threaded | Multi-threaded |

### Q2: "Show me StringBuilder in action"
```java
// Creating
StringBuilder sb = new StringBuilder("Hello");

// Key methods (memorize these!)
sb.append(" World");        // "Hello World"
sb.insert(5, " Java");      // "Hello Java World"
sb.delete(5, 10);          // "Hello World"
sb.reverse();              // "dlroW olleH"
sb.toString();             // Convert to String
```

### Q3: "Why is this code slow?"
```java
// ❌ SLOW - Creates 1000 String objects!
String result = "";
for(int i = 0; i < 1000; i++) {
    result += i;  // New String object each time
}

// ✅ FAST - One StringBuilder object
StringBuilder sb = new StringBuilder();
for(int i = 0; i < 1000; i++) {
    sb.append(i);  // Reuses same object
}
```

---

## 📝 Must-Know Methods

```java
StringBuilder sb = new StringBuilder();

// Building
sb.append("text");           // Add to end
sb.insert(index, "text");    // Add at position
sb.append(123);              // Works with any type

// Modifying  
sb.delete(start, end);       // Remove range
sb.deleteCharAt(index);      // Remove single char
sb.reverse();                // Reverse entire string
sb.setCharAt(index, 'X');    // Replace character

// Accessing
sb.length();                 // Number of characters
sb.charAt(index);            // Get character
sb.toString();               // Convert to String
```

---

## 🚨 Common Mistakes to Avoid

### 1. Wrong Comparison
```java
StringBuilder sb1 = new StringBuilder("hello");
StringBuilder sb2 = new StringBuilder("hello");

// ❌ WRONG - Never use these!
if(sb1 == sb2) { }           // Compares references
if(sb1.equals(sb2)) { }      // StringBuilder doesn't override equals

// ✅ CORRECT
if(sb1.toString().equals(sb2.toString())) { }
```

### 2. Forgetting toString()
```java
// ❌ WRONG - Returns StringBuilder object
public StringBuilder getName() {
    return new StringBuilder("John");
}

// ✅ CORRECT - Returns String
public String getName() {
    return new StringBuilder("John").toString();
}
```

### 3. Using String in Loops
```java
// ❌ AVOID - Creates many objects
String result = "";
for(String word : words) {
    result += word + " ";
}

// ✅ PREFER - Efficient
StringBuilder sb = new StringBuilder();
for(String word : words) {
    sb.append(word).append(" ");
}
```

---

## 🏆 Quick Practice Problems

### Problem 1: Reverse String
```java
public String reverseString(String input) {
    return new StringBuilder(input).reverse().toString();
}
```

### Problem 2: Palindrome Check
```java
public boolean isPalindrome(String str) {
    StringBuilder sb = new StringBuilder(str);
    return str.equals(sb.reverse().toString());
}
```

### Problem 3: Build CSV
```java
public String arrayToCSV(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < arr.length; i++) {
        sb.append(arr[i]);
        if(i < arr.length - 1) sb.append(",");
    }
    return sb.toString();
}
```

---

## 💡 Interview Tips

### Code Optimization Question
**Interviewer:** "How would you optimize this?"
```java
String result = "";
for(int i = 0; i < n; i++) {
    result += data[i];
}
```

**Your Answer:** "Use StringBuilder for better performance"
```java
StringBuilder sb = new StringBuilder();
for(int i = 0; i < n; i++) {
    sb.append(data[i]);
}
return sb.toString();
```

### Method Chaining
**Show off with:** `sb.append("Hello").append(" ").append("World")`

### Capacity Knowledge
**Bonus points:** "StringBuilder has initial capacity of 16, grows automatically"

---

## 🎯 Final Checklist

**Before the interview, make sure you know:**

- [ ] **Why StringBuilder?** → Mutable, efficient for loops
- [ ] **Key methods:** append(), insert(), delete(), reverse(), toString()
- [ ] **Comparison:** String vs StringBuilder vs StringBuffer
- [ ] **Common mistake:** Using == or .equals() for comparison
- [ ] **Performance:** Why it's faster than String concatenation
- [ ] **When NOT to use:** Single concatenation operations

---

## 🔥 Last-Minute Memory Aid

**"SMART" StringBuilder:**
- **S**tring is immutable, StringBuilder is mutable
- **M**ethod chaining: `sb.append().insert().reverse()`
- **A**ppend is most common operation
- **R**everse for palindrome problems
- **T**oString() to convert back to String

**Ready to ace those StringBuilder questions! 🚀**