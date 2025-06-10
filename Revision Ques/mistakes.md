# ❌ Common Mistakes I Made While Revising Java

> A personal checklist to avoid repeating small but important errors.

---

## 🔁 General Coding Practices

1. **Forgetting to close the Scanner**
   - ✅ Always write `sc.close();` at the end to avoid resource leaks.
   - 🧠 Tip: This is especially important in larger programs or competitive coding platforms.

---

## 🔢 Data Types and Constants

2. **Using wrong data type with `Math.PI`**
   - ❌ `float area = Math.PI * r * r;`  
   - ✅ Use `double` instead:  
     ```java
     double area = Math.PI * r * r;
     ```

---

## 📅 Leap Year Logic

3. **Incorrect order while checking leap year**
   - ✅ Correct order:  
     First check `year % 400 == 0`  
     Then `year % 100 == 0`  
     Then `year % 4 == 0`
   - ✅ OR use the proper condition directly:
     ```java
     if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
     ```

---

## 📈 Logical Errors

4. **Missing the "all equal" case in comparison problems**
   - When comparing three numbers (e.g., largest of a, b, c), handle:
     ```java
     if (a == b && b == c) {
         System.out.println("All numbers are equal");
     }
     ```

5. **Forgetting brackets in average calculation**
   - ❌ `int avg = a + b + c / 3;`  
   - ✅ Correct version:  
     ```java
     int avg = (a + b + c) / 3;
     ```

---

## 🎨 Output Formatting

6. **Using `System.out.printf()` for cleaner output**
   - ✅ Helps format to 2 decimal places, include currency, %, etc.
   - Example:
     ```java
     float price = 149.99f;
     System.out.printf("Price: ₹%.2f%n", price);
     ```

---

📌 _Keep updating this file as you learn — small fixes save a lot of debugging time!_
