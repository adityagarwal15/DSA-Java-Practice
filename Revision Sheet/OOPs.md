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
**Belongs to class, not instance(obj)**

```java
public class StaticExample {

    // 🔹 Static variable (shared by all instances)
    static int count = 0;

    // 🔹 Instance variable (unique to each object)
    String name;

    // 🔹 Static block (runs once when class is loaded)
    static {
        System.out.println("🔁 Static block executed");
    }

    // 🔹 Constructor
    StaticExample(String name) {
        this.name = name;
        count++;  // Increments static variable
    }

    // 🔹 Static method
    static void displayCount() {
        System.out.println("📦 Total objects created: " + count);
        // ❌ Can't access 'name' here (non-static)
    }

    // 🔹 Instance method
    void displayName() {
        System.out.println("👤 Name: " + name);
    }

    // 🔹 Static nested class
    static class StaticNested {
        void message() {
            System.out.println("📨 Inside static nested class");
        }
    }

    // 🔹 Main method
    public static void main(String[] args) {
        StaticExample.displayCount(); // ✅ Calling static method without object

        StaticExample s1 = new StaticExample("Aditya");
        StaticExample s2 = new StaticExample("Aarav");

        s1.displayName();   // 👤 Output: Aditya
        s2.displayName();   // 👤 Output: Aarav

        StaticExample.displayCount(); // 📦 Output: 2

        // ✅ Using static nested class
        StaticExample.StaticNested nested = new StaticExample.StaticNested();
        nested.message();  // 📨 Output: Inside static nested class
    }
}

```

---

### ✅ **23. Super Keyword**

The `super` keyword refers to the **parent class** in Java.

---

#### 🔑 **Uses of `super`:**

* `super.method()` – Call parent class method
* `super.variable` – Access parent class variable
* `super()` – Call parent class constructor (**must be the first line in a constructor**)

---

#### 💡 **Code Example**

```java
class Parent {
    String name = "Parent";

    // 🔹 Parent class constructor
    Parent() {
        System.out.println("Parent constructor called");
    }

    // 🔹 Parent method
    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    String name = "Child";

    // 🔹 Child constructor
    Child() {
        super();  // Calls Parent constructor
        System.out.println("Child constructor called");
    }

    // 🔹 Child method
    void display() {
        super.display();  // Calls Parent method
        System.out.println("Child method");
        System.out.println("Parent name: " + super.name);  // Access parent variable
        System.out.println("Child name: " + this.name);    // Access current variable
    }
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();  // Constructors get called
        obj.display();            // Methods get called
    }
}
```

---

### ✅ **24. This Keyword**
**Refers to current object of the class**

```java
class Person {
    String name;
    int age;

    // 👷 Constructor with parameters
    public Person(String name, int age) {
        // 🟡 Here, local variable 'name' is same as instance variable 'name'
        // ⚠️ If you just write: name = name;  ← it won’t work correctly!
        // ✅ So we use this.name to mean: "instance variable name"
        this.name = name;
        this.age = age;
    }

    void display() {
        // 🔹 this.name is same as just writing name here (no conflict now)
        System.out.println("Name: " + this.name);
        this.printAge();  // Calls another method of same object
    }

    void printAge() {
        System.out.println("Age: " + age);
    }

    Person getThis() {
        return this;  // Returns the current object
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a new Person object
        Person p1 = new Person("Aditya", 21);

        // Calling display method
        p1.display();

        // Using getThis() method
        Person p2 = p1.getThis();

        // Check if p1 and p2 are same
        System.out.println("Same object? " + (p1 == p2));  // true
    }
}


```

---

### ✅ **Q5: Basics of Exception Handling in Java**

#### 🔸 **What is Exception Handling?**

Exception handling in Java is a **mechanism** to handle **runtime errors**, allowing the normal flow of the program to continue.

---

### 🔹 **Basic Syntax:**

```java
try {
    // Code that may throw an exception
} catch (ExceptionType name) {
    // Code to handle the exception
}
```

You can also add:

* `finally` block (optional): Executes **always**, whether an exception occurred or not.
* Multiple `catch` blocks.

---

### 🔹 **Example:**

```java
public class Example {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // Error: index out of bounds
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        } finally {
            System.out.println("The 'try catch' block is finished.");
        }
    }
}
```

#### ✅ **Output:**

```
Something went wrong: java.lang.ArrayIndexOutOfBoundsException: 5
The 'try catch' block is finished.
```

---

### 🔹 **Key Points:**

* `try` block contains code that may throw an exception.
* `catch` handles the error.
* `finally` always runs (optional but useful for clean-up like closing files).

---

## 🎯 Quick Interview Questions & Answers

---

### **Q1: Can you achieve multiple inheritance in Java?**

**A**: No, through classes. Yes, through interfaces.

---

### **Q2: Difference between method overloading and overriding?**

**A**:

* **Overloading**: Same name, different parameters (compile-time)
* **Overriding**: Same signature, different implementation (runtime)

---

### **Q3: Why is Java "pass-by-value"?**

**A**: Java passes the **value of reference** for objects, not the reference itself.

---

### **Q4: Can abstract class have constructor?**

**A**: Yes, but cannot be instantiated directly.

---

### **Q5: Can interface have variables?**

**A**: Yes, but they are `public static final` by default.

---

### **Q6: Which access modifiers are allowed on classes, methods, and variables?**

| Access Modifier         | Top-Level Class | Nested Class | Constructor | Method | Field (Variable) |
| ----------------------- | --------------- | ------------ | ----------- | ------ | ---------------- |
| `private`               | ❌ No            | ✅ Yes        | ✅ Yes       | ✅ Yes  | ✅ Yes            |
| *default* (no modifier) | ✅ Yes           | ✅ Yes        | ✅ Yes       | ✅ Yes  | ✅ Yes            |
| `protected`             | ❌ No            | ✅ Yes        | ✅ Yes       | ✅ Yes  | ✅ Yes            |
| `public`                | ✅ Yes           | ✅ Yes        | ✅ Yes       | ✅ Yes  | ✅ Yes            |

**Note:**

* Top-level classes allow only `public` or *default* (package-private).
* Nested classes, constructors, methods, and fields support all access modifiers.

---

### **Q7: Which of the following is a correct statement?**

*(Assume both classes are in the same package)*

```java
class Vehicle { }
class Car extends Vehicle { }
```

Now choose the valid object creation statement:

✅ `Car c = new Car();` → **Correct**
✅ `Vehicle v = new Vehicle();` → **Correct**
✅ `Vehicle v = new Car();` → **Correct (Upcasting allowed)**
❌ `Car c = new Vehicle();` → **Incorrect (Cannot downcast directly)**

---

### **Q8: What will be the output of this code?**

```java
public class InheritanceTest {
    public static void main(String[] args) {
        Vehicle obj1 = new Car();
        obj1.print();   // Polymorphism: Calls Car’s method

        Vehicle obj2 = new Vehicle();
        obj2.print();   // Calls Vehicle’s method
    }
}

class Vehicle {
    void print() {
        System.out.println("Base class (Vehicle)");
    }
}

class Car extends Vehicle {
    @Override
    void print() {
        System.out.println("Derived class (Car)");
    }
}
```

### ✅ **Output:**

```
Derived class (Car)
Base class (Vehicle)
```

**Explanation:**

* `obj1` refers to a `Car` object, so the **overridden `print()`** method is called — this is **runtime polymorphism**.
* `obj2` is a `Vehicle` object, so its own method runs.

---

### **Q9: What will be the output of this code?**

```java
public class Inheritance {
    public static void main(String[] args) {
        Vehicle obj1 = new Car();
        obj1.print1();   // ❌ Compile-time Error

        Vehicle obj2 = new Vehicle();
        obj2.print();
    }
}

class Vehicle {
    void print() {
        System.out.println("Base class (Vehicle)");
    }
}

class Car extends Vehicle {
    void print1() {
        System.out.println("Derived class (Car)");
    }
}
```

### ❌ **Output: Compile-time Error**

**Explanation:**

* `obj1` is declared as type `Vehicle`, which has **no method** named `print1()`.
* Even though `obj1` is actually a `Car` object, **only methods available in the reference type** (`Vehicle`) can be called without casting.

**Fix:**

```java
((Car) obj1).print1();  // ✅ Cast required to access `print1()`
```

---

### **Q10: Which line has the error?**

```java
class Test {
    static int marks;

    void set_marks(int marks) {
        this.marks = marks;
    }
}

public class OOPS {
    public static void main(String[] args) {
        Test t = new Test();             // ✅ Line 1
        t.set_marks(98);                 // ✅ Line 2
        System.out.print(Test.marks);    // ✅ Line 3
    }
}
```

### ✅ **Output:**

```
98
```

So, which line has error?
❌ **None** — all lines are correct.

> 💡 `marks` is static, so it can be accessed using the class name directly without creating an object.

---

### **Q11: What will be the output of the following code?**

```java
class Test {
    static int a = 10;
    static int b;

    static void changeB() {
       b = a * 3;
    }
}

public class OOPS {
    public static void main(String[] args) {
        Test t = new Test();
        t.changeB();
        System.out.print(Test.a + Test.b);
    }
}
```

### ✅ **Output:**

```
40
```

**Explanation:**

* `a` and `b` are static, so they belong to the **class**, not the instance.
* `changeB()` sets `b = 30`.
* Final print: `10 + 30 = 40`

---

### **Q12: Look at the following code and choose the right access modifier for the word:**

**`Shape.java`**

```java
public class Shape {
    protected void display() {
        System.out.println("Display-base");
    }
}
```

**`Circle.java`**

```java
public class Circle extends Shape {
    <access-modifier> void display() {
        System.out.println("Display-derived");
    }
}
```

### ❓**Question**:

What access modifier(s) can replace `<access-modifier>` in `Circle` without causing a compile-time error?


### ✅ **Answer:**

You can use:

* `protected` ✅
* `public` ✅

You **cannot** use:

* `default` (package-private) ❌ — only works **if both classes are in the same package**
* `private` ❌ — cannot reduce visibility while overriding

### 📌 **Rule**:

> **When overriding a method**, the subclass **cannot reduce** the access level of the method.

* `protected` (superclass) → must be overridden with `protected` or `public`
* Overriding with `private` will cause a **compile-time error**

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
