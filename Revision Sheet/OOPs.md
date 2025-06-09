# 🚀 Java OOP Essentials - MAANG/FAANG Interview Prep

---

## 📚 Core OOP Topics Checklist

### ✅ **01. Classes & Objects**
**Class**: Blueprint/Template  
**Object**: Instance of a class

```java
class Student {
    String name;
    int age;
    
    void study() {
        System.out.println(name + " is studying");
    }
}

// Creating objects
Student s1 = new Student();
s1.name = "Alice";
s1.age = 20;
```

---

### ✅ **02. Access Modifiers**

| Modifier | Class | Package | Subclass | Global |
|----------|-------|---------|----------|--------|
| private | ✅ | ❌ | ❌ | ❌ |
| default | ✅ | ✅ | ❌ | ❌ |
| protected | ✅ | ✅ | ✅ | ❌ |
| public | ✅ | ✅ | ✅ | ✅ |

```java
class Example {
    private int a;      // Only within class
    int b;             // Within package (default)
    protected int c;   // Within package + subclasses
    public int d;      // Everywhere
}
```

---

### ✅ **03. Getters & Setters**
```java
class Person {
    private String name;
    private int age;
    
    // Getter
    public String getName() {
        return name;
    }
    
    // Setter with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
```

---

### ✅ **04. Encapsulation** 🔒
**Definition**: Binding data and methods + restricting direct access

```java
class BankAccount {
    private double balance;  // Private data
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public double getBalance() {
        return balance;  // Controlled access
    }
}
```

**Benefits**: Data security, validation, maintainability

---

### ✅ **05. Constructors**
- No return type
- Same name as class
- Called when object is created

```java
class Car {
    String brand;
    int year;
    
    // Constructor
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}
```

---

### ✅ **06. Types of Constructors**

#### **Default Constructor**
```java
class Student {
    String name = "Unknown";
    
    // Default constructor (provided by Java if not written)
    public Student() {
        // Empty
    }
}
```

#### **Parameterized Constructor**
```java
class Student {
    String name;
    int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

#### **Constructor Overloading**
```java
class Employee {
    String name;
    int id;
    double salary;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}
```

---

### ✅ **07. Copy Constructor**
Java doesn't have built-in copy constructor, but we can create one:

```java
class Person {
    String name;
    int age;
    
    // Regular constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }
}

// Usage
Person p1 = new Person("John", 25);
Person p2 = new Person(p1);  // Copy constructor
```

---

### ✅ **08. Shallow & Deep Copy**

#### **Shallow Copy**
```java
class Student {
    String name;
    int[] marks;
    
    // Shallow copy - only copies references
    public Student shallowCopy() {
        Student copy = new Student();
        copy.name = this.name;
        copy.marks = this.marks;  // Same reference!
        return copy;
    }
}
```

#### **Deep Copy**
```java
class Student {
    String name;
    int[] marks;
    
    // Deep copy - creates new objects
    public Student deepCopy() {
        Student copy = new Student();
        copy.name = this.name;
        copy.marks = this.marks.clone();  // New array
        return copy;
    }
}
```

---

### ✅ **09. Destructors**
Java has **Garbage Collector** - no manual destructors needed.

```java
class Resource {
    // finalize() method (deprecated but sometimes asked)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object being garbage collected");
        super.finalize();
    }
    
    // Better approach: cleanup method
    public void cleanup() {
        // Manual cleanup if needed
    }
}
```

---

### ✅ **10. Inheritance** 🧬
**Definition**: Child class inherits properties from parent class

```java
class Animal {
    String name;
    
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Usage
Dog d = new Dog();
d.name = "Buddy";  // Inherited from Animal
d.eat();           // Inherited method
d.bark();          // Own method
```

---

### ✅ **11. Single Level Inheritance**
```java
class Parent {
    void display() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child class");
    }
}
```

---

### ✅ **12. Multi Level Inheritance**
```java
class GrandParent {
    void method1() {
        System.out.println("GrandParent");
    }
}

class Parent extends GrandParent {
    void method2() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void method3() {
        System.out.println("Child");
    }
}

// Child has access to all methods: method1, method2, method3
```

---

### ✅ **13. Hierarchical Inheritance**
```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Meowing...");
    }
}

// Both Dog and Cat inherit from Animal
```

---

### ✅ **14. Hybrid Inheritance**
**Java doesn't support multiple class inheritance** - but can achieve using **interfaces**

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird flying");
    }
}

class Duck extends Bird implements Swimmable {
    public void swim() {
        System.out.println("Duck swimming");
    }
}
```

---

### ✅ **15. Polymorphism** 🎭
**Definition**: One interface, multiple forms

**Two Types**:
1. **Compile-time**: Method Overloading
2. **Runtime**: Method Overriding

```java
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing rectangle");
    }
}

// Polymorphism in action
Shape[] shapes = {new Circle(), new Rectangle()};
for (Shape shape : shapes) {
    shape.draw();  // Calls appropriate method at runtime
}
```

---

### ✅ **16. Method Overloading**
**Same method name, different parameters**

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

**Rules**:
- Different number of parameters
- Different type of parameters  
- Different order of parameters

---

### ✅ **17. Method Overriding**
**Same method signature in parent and child**

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}
```

**Rules**:
- Same method signature
- Cannot reduce visibility (`public` → `private` ❌)
- Cannot override `static`, `final`, `private` methods

---

### ✅ **18. Packages in Java**
```java
// Creating package
package com.company.project;

// Importing
import java.util.ArrayList;
import java.util.*;  // Import all

public class MyClass {
    // Class content
}
```

**Benefits**: Organization, namespace, access control

---

### ✅ **19. Abstraction** 🎨
**Definition**: Hiding implementation details, showing only functionality

```java
abstract class Vehicle {
    abstract void start();  // Abstract method
    
    void stop() {  // Concrete method
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car started with key");
    }
}
```

---

### ✅ **20. Abstract Classes**
- Cannot be instantiated
- Can have abstract and concrete methods
- Can have constructors

```java
abstract class Shape {
    String color;
    
    // Constructor in abstract class
    public Shape(String color) {
        this.color = color;
    }
    
    abstract double calculateArea();  // Must be implemented
    
    void displayColor() {  // Can have concrete methods
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
```

---

### ✅ **21. Interfaces**

* Provides **100% abstraction** (before Java 8)
* Allows **multiple inheritance**
* All methods are `public abstract` by default (before Java 8)
* All variables are `public static final` (constants)
* From **Java 8 onward**, interfaces can also have:

  * `default` methods (with body)
  * `static` methods

```java
interface Drawable {
    void draw();  // public abstract by default

    // Java 8+ features
    default void print() {
        System.out.println("Printing...");
    }

    static void info() {
        System.out.println("Drawable interface");
    }
}

class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}
```

---

### ✅ **Multiple Inheritance via Interface**

```java
interface A {
    void showA();
}

interface B {
    void showB();
}

// Class implements both interfaces
class C implements A, B {
    public void showA() {
        System.out.println("Inside showA from interface A");
    }

    public void showB() {
        System.out.println("Inside showB from interface B");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.showA();
        obj.showB();
    }
}
```

🧠 In Java, **multiple inheritance** is not allowed with classes (to avoid conflicts), but **it is allowed with interfaces**. This way, a class can follow multiple "contracts" at once.

---

### ✅ **Abstract Class vs Interface**

| Feature                  | **Abstract Class**  | **Interface (After Java 8)**      |
| ------------------------ | ------------------- | --------------------------------- |
| **Instantiation**        | ❌ Cannot            | ❌ Cannot                          |
| **Constructor**          | ✅ Yes               | ❌ No                              |
| **Multiple Inheritance** | ❌ No                | ✅ Yes                             |
| **Method Types**         | Abstract + Concrete | Abstract, `default`, and `static` |
| **Fields/Variables**     | Normal fields       | `public static final` only        |

---

### ✅ **22. Static Keyword**
**Belongs to class, not instance**

```java
class Student {
    static String schoolName = "ABC School";  // Static variable
    String studentName;  // Instance variable
    
    static void displaySchool() {  // Static method
        System.out.println("School: " + schoolName);
        // Cannot access instance variables here
    }
    
    void displayStudent() {  // Instance method
        System.out.println("Student: " + studentName);
        System.out.println("School: " + schoolName);  // Can access static
    }
}

// Usage
Student.displaySchool();  // Called with class name
Student s1 = new Student();
s1.displayStudent();
```

---

### ✅ **23. Super Keyword**
**Refers to parent class**

```java
class Parent {
    String name = "Parent";
    
    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    String name = "Child";
    
    void display() {
        super.display();  // Calls parent method
        System.out.println("Child method");
        System.out.println("Parent name: " + super.name);
        System.out.println("Child name: " + this.name);
    }
    
    Child() {
        super();  // Calls parent constructor
    }
}
```

---

### ✅ **24. This Keyword**
**Refers to current object**

```java
class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;  // Resolves naming conflict
        this.age = age;
    }
    
    void display() {
        System.out.println("Name: " + this.name);
        this.printAge();  // Calls method of current object
    }
    
    void printAge() {
        System.out.println("Age: " + age);
    }
    
    Person getThis() {
        return this;  // Returns current object
    }
}
```

---

## 🎯 Quick Interview Questions & Answers

### **Q1: Can you achieve multiple inheritance in Java?**
**A**: No, through classes. Yes, through interfaces.

### **Q2: Difference between method overloading and overriding?**
**A**: 
- **Overloading**: Same name, different parameters (compile-time)
- **Overriding**: Same signature, different implementation (runtime)

### **Q3: Why is Java "pass-by-value"?**
**A**: Java passes the **value of reference** for objects, not the reference itself.

### **Q4: Can abstract class have constructor?**
**A**: Yes, but cannot be instantiated directly.

### **Q5: Can interface have variables?**
**A**: Yes, but they are `public static final` by default.

---

## ✅ Final Checklist

- [ ] Classes & Objects creation
- [ ] All 4 access modifiers
- [ ] Encapsulation with getters/setters
- [ ] Constructor types and overloading
- [ ] Shallow vs Deep copy
- [ ] Inheritance types (single, multilevel, hierarchical)
- [ ] Polymorphism (overloading vs overriding)
- [ ] Abstraction (abstract classes vs interfaces)
- [ ] Static, super, this keywords usage

**🎯 This covers 90% of OOP questions in MAANG interviews!**
