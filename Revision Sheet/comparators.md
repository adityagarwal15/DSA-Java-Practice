# 📘 Java Comparators - Quick Placement Reference

**DSA Interview Prep | 4th Year | 15-20+ LPA Target**

---

## 🎯 Why Learn This?
**High-frequency topics:** Custom sorting, PriorityQueue, Multi-criteria sorting  
**Companies:** Google, Microsoft, Amazon, Goldman Sachs, Flipkart

---

## 🧠 Two Ways to Sort Custom Objects

### **1. Comparable<T>** - Inside the class
```java
class Student implements Comparable<Student> {
    String name;
    int marks;
    
    @Override
    public int compareTo(Student s) {
        return Integer.compare(this.marks, s.marks);  // Ascending
    }
}

// Usage
Collections.sort(students);  // Uses compareTo()
```

### **2. Comparator<T>** - Outside the class
```java
// Lambda way (most common in interviews)
Collections.sort(students, (a, b) -> Integer.compare(b.marks, a.marks));  // Descending

// Built-in way
Collections.sort(students, Comparator.comparing(s -> s.marks));
```

---

## 🔹 Essential Patterns

### **Multi-criteria Sorting** ⭐ **Very Common**
```java
// First by marks (desc), then by name (asc)
Collections.sort(students, (a, b) -> {
    if (a.marks != b.marks) {
        return Integer.compare(b.marks, a.marks);  // Desc by marks
    }
    return a.name.compareTo(b.name);  // Asc by name
});

// Cleaner way
Collections.sort(students, 
    Comparator.comparing((Student s) -> s.marks).reversed()
              .thenComparing(s -> s.name));
```

### **PriorityQueue with Custom Comparator**
```java
// Interview Pattern: Top K / Heap problems

// Min heap by marks
PriorityQueue<Student> minHeap = new PriorityQueue<>((a, b) -> 
    Integer.compare(a.marks, b.marks));

// Max heap by marks  
PriorityQueue<Student> maxHeap = new PriorityQueue<>((a, b) -> 
    Integer.compare(b.marks, a.marks));
```

---

## 🧩 Complete Example
```java
import java.util.*;

class Student {
    String name;
    int marks;
    
    Student(String name, int marks) {
        this.name = name; this.marks = marks;
    }
    
    public String toString() { return name + ":" + marks; }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 92),
            new Student("Charlie", 85)
        );
        
        // Sort by marks descending
        Collections.sort(students, (a, b) -> Integer.compare(b.marks, a.marks));
        System.out.println(students);  // [Bob:92, Alice:85, Charlie:85]
    }
}
```

---

## 🚀 Interview Cheat Sheet

| **Need** | **Code** |
|----------|----------|
| **Sort ascending** | `(a, b) -> Integer.compare(a.field, b.field)` |
| **Sort descending** | `(a, b) -> Integer.compare(b.field, a.field)` |
| **String sort** | `(a, b) -> a.name.compareTo(b.name)` |
| **Min heap** | `new PriorityQueue<>((a, b) -> Integer.compare(a.field, b.field))` |
| **Max heap** | `new PriorityQueue<>((a, b) -> Integer.compare(b.field, a.field))` |

---

## ⚠️ Common Mistake
```java
// ❌ WRONG - Can overflow
return a.marks - b.marks;

// ✅ CORRECT - Safe
return Integer.compare(a.marks, b.marks);
```

---

## 🎯 High-Frequency Problems
1. **Meeting Rooms** - Sort intervals by start time
2. **Top K Elements** - Use PriorityQueue with custom comparator
3. **Student Ranking** - Multi-criteria sorting

**That's it! Practice these patterns and you're set for comparator questions.**