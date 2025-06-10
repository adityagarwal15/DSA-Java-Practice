# 🐛 Java Common Mistakes - Quick Reference Guide

> Personal checklist to avoid repeating coding errors during Java revision

---

## 🧹 **Resource Management**

### Scanner Not Closed
- **Problem:** Memory leaks and resource waste
- **Solution:** Always add `scanner.close();` at the end
- **Best Practice:** Use try-with-resources when possible
```java
try (Scanner sc = new Scanner(System.in)) {
    // your code here
} // automatically closes
```

---

## 🔢 **Data Types & Precision**

### Wrong Data Type with Math.PI
- **❌ Wrong:** `float area = Math.PI * r * r;`
- **✅ Correct:** `double area = Math.PI * r * r;`
- **Why:** `Math.PI` is a `double`, mixing with `float` loses precision

### Integer Division Trap
- **❌ Wrong:** `double result = 5 / 2;` // gives 2.0
- **✅ Correct:** `double result = 5.0 / 2;` // gives 2.5

---

## 🧮 **Mathematical Operations**

### Parentheses in Calculations
- **❌ Wrong:** `int avg = a + b + c / 3;` // only c is divided
- **✅ Correct:** `int avg = (a + b + c) / 3;`

### Order of Operations
- Remember **PEMDAS/BODMAS**
- Use parentheses to make intentions clear
- Be careful with mixed data types

---

## 📅 **Leap Year Logic**

### Incorrect Condition Order
- **❌ Wrong Order:** Check `%4` first, then `%100`, then `%400`
- **✅ Correct Logic:**
```java
boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
```

### Quick Rule
1. Divisible by 400 → **Leap Year**
2. Divisible by 100 → **Not Leap Year**  
3. Divisible by 4 → **Leap Year**
4. Otherwise → **Not Leap Year**

---

## 🔍 **Logical Conditions**

### Missing Edge Cases
- **All Equal Case:** When comparing numbers, handle equality
```java
if (a == b && b == c) {
    System.out.println("All numbers are equal");
} else if (a >= b && a >= c) {
    System.out.println("a is largest");
}
```

### Boolean Logic Errors
- **❌ Wrong:** `if (age > 18 && age < 60 && gender == "male")`
- **✅ Correct:** `if (age > 18 && age < 60 && gender.equals("male"))`

---

## 📋 **String Operations**

### String Comparison
- **❌ Wrong:** `if (str1 == str2)`
- **✅ Correct:** `if (str1.equals(str2))`
- **Null-Safe:** `if (Objects.equals(str1, str2))`

### Case Sensitivity
- Use `.equalsIgnoreCase()` when case doesn't matter
- Use `.toLowerCase()` or `.toUpperCase()` for consistent comparison

---

## 🎨 **Output Formatting**

### Clean Console Output
```java
// Instead of multiple print statements
System.out.printf("Name: %s, Age: %d, Score: %.2f%n", name, age, score);

// Currency formatting
System.out.printf("Price: ₹%.2f%n", price);

// Percentage formatting  
System.out.printf("Success Rate: %.1f%%%n", rate);
```

### Common Format Specifiers
- `%s` → String
- `%d` → Integer  
- `%.2f` → Float/Double with 2 decimal places
- `%n` → Platform-independent newline

---

## ⚡ **Performance Tips**

### StringBuilder for String Concatenation
- **❌ Slow:** `str += "text";` in loops
- **✅ Fast:** Use `StringBuilder` for multiple concatenations

### Avoid Unnecessary Object Creation
- **❌ Wrong:** `new String("text")`
- **✅ Correct:** `"text"` (string literal)

---

## 🎯 **Quick Debugging Checklist**

- [ ] Scanner closed?
- [ ] Correct data types used?
- [ ] Parentheses in calculations?
- [ ] String comparison with `.equals()`?
- [ ] Edge cases handled?
- [ ] Proper formatting applied?

---

## 💡 **Pro Tips**

1. **Use meaningful variable names** → `radius` instead of `r`
2. **Add comments for complex logic** → Future you will thank you
3. **Test with edge cases** → Zero, negative numbers, empty strings
4. **Use IDE warnings** → They often catch these mistakes
5. **Code review your own work** → Read it like someone else wrote it

---

> 🔄 **Keep this updated!** Add new mistakes as you encounter them. Small fixes prevent big debugging sessions.