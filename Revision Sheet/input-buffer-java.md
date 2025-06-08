# 🔁 Java Input Buffer - Quick Interview Revision

**Critical Scanner pitfall that breaks 90% of coding interview solutions!**

---

## 🚨 The #1 Scanner Trap

### ⚠️ Problem: Mixed Input Types
```java
Scanner sc = new Scanner(System.in);
int age = sc.nextInt();         // User types: 25<ENTER>
String name = sc.nextLine();    // ❌ Gets empty string!

System.out.println("Name: '" + name + "'");  // Output: Name: ''
```

**What happens:**
- `nextInt()` reads `25` but leaves `\n` in buffer
- `nextLine()` immediately reads the leftover `\n` (empty line)
- Your program skips the actual name input!

---

## ✅ The Fix: Buffer Clearing

```java
Scanner sc = new Scanner(System.in);
int age = sc.nextInt();         // Reads the number
sc.nextLine();                  // ✅ Consume the leftover \n

String name = sc.nextLine();    // ✅ Now reads actual input
System.out.println("Name: " + name);  // Works correctly!
```

---

## 🎯 Common Interview Scenarios

### Scenario 1: Multiple Test Cases
```java
Scanner sc = new Scanner(System.in);
int t = sc.nextInt();           // Number of test cases
sc.nextLine();                  // ✅ Clear buffer

for(int i = 0; i < t; i++) {
    String line = sc.nextLine(); // Read each test case
    // Process line...
}
```

### Scenario 2: Array + String Input
```java
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();           // Array size
sc.nextLine();                  // ✅ Clear buffer

String[] arr = new String[n];
for(int i = 0; i < n; i++) {
    arr[i] = sc.nextLine();     // Read each string
}
```

### Scenario 3: Mixed Data Types
```java
Scanner sc = new Scanner(System.in);
int id = sc.nextInt();
double salary = sc.nextDouble();
sc.nextLine();                  // ✅ Clear buffer

String name = sc.nextLine();
String department = sc.nextLine();
```

---

## 📊 Method Behavior Chart

| Method | Reads | Leaves \n? | Use Case |
|--------|-------|------------|----------|
| `nextInt()` | Integer only | ✅ Yes | Numbers |
| `nextDouble()` | Double only | ✅ Yes | Decimals |
| `next()` | Next token | ✅ Yes | Single words |
| `nextLine()` | Entire line | ❌ No | Full lines |

**Rule:** After any `next___()` method, use `nextLine()` to clear buffer before reading strings.

---

## 🔧 Alternative Solutions

### Solution 1: Use nextLine() for Everything
```java
Scanner sc = new Scanner(System.in);
int age = Integer.parseInt(sc.nextLine());      // Convert string to int
double salary = Double.parseDouble(sc.nextLine()); // Convert string to double
String name = sc.nextLine();                    // Direct string input
```

### Solution 2: BufferedReader (Advanced)
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int age = Integer.parseInt(br.readLine());
String name = br.readLine();
// No buffer issues!
```

---

## 🚨 Debug Your Input Issues

### Quick Test Template:
```java
Scanner sc = new Scanner(System.in);
System.out.println("Enter number:");
int num = sc.nextInt();
System.out.println("You entered: " + num);

System.out.println("Enter string:");
String str = sc.nextLine();
System.out.println("You entered: '" + str + "'");

// If str is empty, you have buffer issues!
```

### Common Symptoms:
- ❌ Program skips string input
- ❌ Getting empty strings unexpectedly  
- ❌ "Input mismatch" exceptions
- ❌ Wrong number of inputs processed

---

## 🎯 Interview Pattern Recognition

### Pattern 1: Input Format
```
Input:
3
Alice
Bob
Charlie
```

**Wrong approach:**
```java
int n = sc.nextInt();
for(int i = 0; i < n; i++) {
    String name = sc.nextLine();  // ❌ First iteration gets empty string
}
```

**Correct approach:**
```java
int n = sc.nextInt();
sc.nextLine();  // ✅ Clear buffer
for(int i = 0; i < n; i++) {
    String name = sc.nextLine();
}
```

### Pattern 2: Mixed Input
```
Input:
5 3.14
Hello World
```

**Solution:**
```java
int num = sc.nextInt();
double decimal = sc.nextDouble();
sc.nextLine();  // ✅ Clear buffer
String text = sc.nextLine();
```

---

## 💡 Interview Tips

### When Explaining Your Solution:
✅ **Say:** "I'll clear the input buffer after reading integers to avoid newline issues"

✅ **Show:** Add `sc.nextLine()` after numeric inputs

✅ **Explain:** "This prevents the nextLine() from reading leftover newlines"

### Red Flags in Your Code:
❌ `nextInt()` followed directly by `nextLine()`
❌ Not handling mixed input types properly
❌ Skipping inputs in loops

---

## 🏆 Quick Practice Problems

### Problem 1: Student Data
```java
// Input format:
// 101
// John Doe
// 85.5

Scanner sc = new Scanner(System.in);
int id = sc.nextInt();
sc.nextLine();                  // ✅ Clear buffer
String name = sc.nextLine();
double grade = sc.nextDouble();
```

### Problem 2: Multiple Entries
```java
// Input format:
// 2
// 25 Alice Smith
// 30 Bob Jones

Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
sc.nextLine();                  // ✅ Clear buffer

for(int i = 0; i < n; i++) {
    String line = sc.nextLine();
    String[] parts = line.split(" ", 2);
    int age = Integer.parseInt(parts[0]);
    String name = parts[1];
}
```

---

## 🧠 Memory Tricks

### **"CLEAR" Method:**
- **C**heck if using nextInt()/nextDouble()
- **L**ook for nextLine() after it
- **E**nsure buffer clearing with sc.nextLine()
- **A**lways test with sample input
- **R**emember: numbers leave newlines!

### **Visual Memory:**
```
nextInt() → [25][\n] ← leftover newline
nextLine() → reads [\n] ← gets empty string!
```

---

## 🔥 Last-Minute Checklist

**Before coding interviews:**

- [ ] **Always clear buffer** after `nextInt()`, `nextDouble()`, `next()`
- [ ] **Test mixed input types** in your solution
- [ ] **Use `nextLine()` + parsing** as alternative approach
- [ ] **Recognize input format patterns** in problem statements
- [ ] **Debug empty string issues** quickly

**Common input patterns to watch for:**
- Number followed by strings
- Multiple test cases with mixed types
- Array size + string elements
- ID + name combinations

**Ready to handle any Scanner input without issues! 🚀**