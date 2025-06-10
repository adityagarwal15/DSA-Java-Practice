//revisit binary to dec and dec to binary once



# Programming Mistakes to Avoid - Reference Guide

## Resource Management
### Scanner Resource Leak
- **Mistake**: Forgetting to write `sc.close();` at the end of the code
- **Impact**: Causes resource leaks and potential memory issues
- **Solution**: Always close Scanner objects after use
```java
Scanner sc = new Scanner(System.in);
// ... your code here
sc.close(); // Don't forget this!
```

## Data Types and Constants
### Math.PI Data Type
- **Mistake**: Using float when working with `Math.PI`
- **Issue**: `Math.PI` is a double by default, not float
- **Solution**: Use `double` data type for precise calculations
```java
double radius = 5.0;
double area = Math.PI * radius * radius; // Use double, not float
```

## Conditional Logic Order
### Year/Divisibility Checking
- **Mistake**: Wrong order when checking conditions like leap years
- **Correct Order**: Check 400 → 100 → 4
```java
// Leap year logic - order matters!
if (year % 400 == 0) {
    // Leap year
} else if (year % 100 == 0) {
    // Not leap year
} else if (year % 4 == 0) {
    // Leap year
} else {
    // Not leap year
}
```

### Comparing Three Numbers
- **Mistake**: Forgetting the "all equal" case when finding the largest
- **Solution**: Handle equality cases properly
```java
if (a == b && b == c) {
    System.out.println("All numbers are equal");
} else if (a >= b && a >= c) {
    System.out.println("a is largest");
} // ... continue with other cases
```

## Mathematical Operations
### Average Calculation
- **Mistake**: Missing brackets in average calculation
- **Wrong**: `a + b + c / 3` (only c is divided by 3)
- **Correct**: `(a + b + c) / 3` (entire sum is divided by 3)
```java
int avg = (a + b + c) / 3; // Brackets are crucial!
```

## Output Formatting
### Using printf for Formatted Output
- **When to use**: For decimal places (.2f) or special symbols (%, ₹, etc.)
- **Example**:
```java
float price = 149.99f;
System.out.printf("Price: ₹%.2f%n", price);
// Output: Price: ₹149.99

double percentage = 85.567;
System.out.printf("Score: %.1f%%%n", percentage);
// Output: Score: 85.6%
```

## Quick Reminders
- Always close resources (Scanner, Files, etc.)
- Use appropriate data types (double for Math.PI)
- Order matters in conditional checks
- Handle edge cases (equality in comparisons)
- Parentheses are crucial in mathematical expressions
- Use printf for formatted output with symbols and decimal precision

---
*Keep this handy for future reference and review before coding sessions!*