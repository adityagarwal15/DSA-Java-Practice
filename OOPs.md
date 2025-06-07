# 🚀 Java OOP Mastery Guide 

---

## 🔥 Memory Management & OOP

### **Object Lifecycle & Garbage Collection**
```java
public class ObjectLifecycleDemo {
    private static List<ObjectLifecycleDemo> instances = new ArrayList<>();
    private String data;
    
    public ObjectLifecycleDemo(String data) {
        this.data = data;
        instances.add(this); // Potential memory leak
    }
    
    // Finalize method (deprecated but still asked in interviews)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object being garbage collected: " + data);
        super.finalize();
    }
    
    // Proper cleanup method
    public void cleanup() {
        instances.remove(this);
        this.data = null;
    }
}
```

### **Method Hiding vs Method Overriding**
```java
class Parent {
    public static void staticMethod() {
        System.out.println("Parent static method");
    }
    
    public void instanceMethod() {
        System.out.println("Parent instance method");
    }
}

class Child extends Parent {
    // Method hiding (not overriding)
    public static void staticMethod() {
        System.out.println("Child static method");
    }
    
    // Method overriding
    @Override
    public void instanceMethod() {
        System.out.println("Child instance method");
    }
}

// Demonstration
Parent p = new Child();
p.staticMethod();    // Calls Parent.staticMethod() - Method Hiding
p.instanceMethod();  // Calls Child.instanceMethod() - Method Overriding
```

### **Advanced Constructor Patterns**
```java
public class DatabaseConnection {
    private final String url;
    private final String username;
    private final int timeout;
    private final boolean autoCommit;
    
    // Private constructor for builder pattern
    private DatabaseConnection(Builder builder) {
        this.url = builder.url;
        this.username = builder.username;
        this.timeout = builder.timeout;
        this.autoCommit = builder.autoCommit;
    }
    
    // Builder pattern - alternative to telescoping constructors
    public static class Builder {
        private String url;
        private String username;
        private int timeout = 30; // default
        private boolean autoCommit = true; // default
        
        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }
        
        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }
        
        public Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }
        
        public Builder setAutoCommit(boolean autoCommit) {
            this.autoCommit = autoCommit;
            return this;
        }
        
        public DatabaseConnection build() {
            if (url == null) throw new IllegalStateException("URL is required");
            return new DatabaseConnection(this);
        }
    }
}

// Usage
DatabaseConnection conn = new DatabaseConnection.Builder()
    .setUrl("jdbc:mysql://localhost:3306/db")
    .setUsername("admin")
    .setTimeout(60)
    .build();
```

---

## 🎯 Concurrency & OOP

### **Thread-Safe Singleton Patterns**
```java
// Enum singleton (Thread-safe + Serialization-safe)
public enum DatabaseManager {
    INSTANCE;
    
    private Connection connection;
    
    public void connect() {
        // Connection logic
    }
    
    public Connection getConnection() {
        return connection;
    }
}

// Double-checked locking
public class ConfigManager {
    private static volatile ConfigManager instance;
    private final Properties config;
    
    private ConfigManager() {
        config = new Properties();
        // Load configuration
    }
    
    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }
}

// Bill Pugh Solution (Initialization-on-demand holder)
public class ServiceManager {
    private ServiceManager() {}
    
    private static class SingletonHelper {
        private static final ServiceManager INSTANCE = new ServiceManager();
    }
    
    public static ServiceManager getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

### **Immutable Objects & Defensive Copying**
```java
public final class ImmutablePerson {
    private final String name;
    private final List<String> hobbies;
    private final Date birthDate;
    
    public ImmutablePerson(String name, List<String> hobbies, Date birthDate) {
        this.name = name;
        // Defensive copying for mutable objects
        this.hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies));
        this.birthDate = new Date(birthDate.getTime());
    }
    
    public String getName() { return name; }
    
    public List<String> getHobbies() {
        // Return copy to maintain immutability
        return new ArrayList<>(hobbies);
    }
    
    public Date getBirthDate() {
        // Return copy to prevent external modification
        return new Date(birthDate.getTime());
    }
    
    // Builder pattern for immutable objects
    public static class Builder {
        private String name;
        private List<String> hobbies = new ArrayList<>();
        private Date birthDate;
        
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder addHobby(String hobby) {
            this.hobbies.add(hobby);
            return this;
        }
        
        public Builder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }
        
        public ImmutablePerson build() {
            return new ImmutablePerson(name, hobbies, birthDate);
        }
    }
}
```

---

## 🧪 Advanced OOP Interview Scenarios

### **Q1: Design a flexible caching system using OOP principles**

```java
// Strategy pattern for cache eviction policies
interface EvictionPolicy<K> {
    void recordAccess(K key);
    K evict();
}

class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final LinkedHashMap<K, Boolean> accessOrder = new LinkedHashMap<>(16, 0.75f, true);
    
    @Override
    public void recordAccess(K key) {
        accessOrder.put(key, true);
    }
    
    @Override
    public K evict() {
        return accessOrder.isEmpty() ? null : accessOrder.keySet().iterator().next();
    }
}

// Generic cache with composition
public class FlexibleCache<K, V> {
    private final Map<K, V> cache;
    private final int maxSize;
    private final EvictionPolicy<K> evictionPolicy;
    
    public FlexibleCache(int maxSize, EvictionPolicy<K> evictionPolicy) {
        this.cache = new ConcurrentHashMap<>();
        this.maxSize = maxSize;
        this.evictionPolicy = evictionPolicy;
    }
    
    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            evictionPolicy.recordAccess(key);
        }
        return value;
    }
    
    public void put(K key, V value) {
        if (cache.size() >= maxSize && !cache.containsKey(key)) {
            K keyToEvict = evictionPolicy.evict();
            if (keyToEvict != null) {
                cache.remove(keyToEvict);
            }
        }
        cache.put(key, value);
        evictionPolicy.recordAccess(key);
    }
}
```

### **Q2: Implement a notification system supporting multiple channels**

```java
// Observer pattern with modern Java features
public interface NotificationObserver {
    void onNotification(Notification notification);
}

public record Notification(String message, NotificationType type, 
                          LocalDateTime timestamp) {}

public enum NotificationType {
    INFO, WARNING, ERROR, SUCCESS
}

public class NotificationManager {
    private final Map<NotificationType, List<NotificationObserver>> observers = 
        new ConcurrentHashMap<>();
    
    public void subscribe(NotificationType type, NotificationObserver observer) {
        observers.computeIfAbsent(type, k -> new CopyOnWriteArrayList<>()).add(observer);
    }
    
    public void unsubscribe(NotificationType type, NotificationObserver observer) {
        observers.getOrDefault(type, Collections.emptyList()).remove(observer);
    }
    
    public CompletableFuture<Void> notifyAsync(Notification notification) {
        List<NotificationObserver> typeObservers = 
            observers.getOrDefault(notification.type(), Collections.emptyList());
        
        List<CompletableFuture<Void>> futures = typeObservers.stream()
            .map(observer -> CompletableFuture.runAsync(() -> observer.onNotification(notification)))
            .collect(Collectors.toList());
        
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }
}

// Specific implementations
class EmailNotificationObserver implements NotificationObserver {
    @Override
    public void onNotification(Notification notification) {
        System.out.println("Email sent: " + notification.message());
    }
}

class SMSNotificationObserver implements NotificationObserver {
    @Override
    public void onNotification(Notification notification) {
        System.out.println("SMS sent: " + notification.message());
    }
}
```

### **Q3: Create a flexible validation framework**

```java
// Chain of Responsibility + Strategy pattern
public interface Validator<T> {
    ValidationResult validate(T object);
    
    default Validator<T> and(Validator<T> other) {
        return object -> {
            ValidationResult result = this.validate(object);
            return result.isValid() ? other.validate(object) : result;
        };
    }
}

public class ValidationResult {
    private final boolean valid;
    private final String errorMessage;
    
    private ValidationResult(boolean valid, String errorMessage) {
        this.valid = valid;
        this.errorMessage = errorMessage;
    }
    
    public static ValidationResult valid() {
        return new ValidationResult(true, null);
    }
    
    public static ValidationResult invalid(String message) {
        return new ValidationResult(false, message);
    }
    
    public boolean isValid() { return valid; }
    public String getErrorMessage() { return errorMessage; }
}

// Usage with lambda expressions
public class UserValidator {
    private static final Validator<User> nameValidator = 
        user -> user.getName() != null && !user.getName().trim().isEmpty() 
            ? ValidationResult.valid() 
            : ValidationResult.invalid("Name cannot be empty");
    
    private static final Validator<User> emailValidator = 
        user -> user.getEmail() != null && user.getEmail().contains("@")
            ? ValidationResult.valid()
            : ValidationResult.invalid("Invalid email format");
    
    private static final Validator<User> ageValidator = 
        user -> user.getAge() >= 0 && user.getAge() <= 150
            ? ValidationResult.valid()
            : ValidationResult.invalid("Age must be between 0 and 150");
    
    public static ValidationResult validateUser(User user) {
        return nameValidator
            .and(emailValidator)
            .and(ageValidator)
            .validate(user);
    }
}
```

---

## 🚨 Advanced Interview Traps & Edge Cases

### **Trap 4**: "What happens with method resolution in complex inheritance?"
```java
interface A { default void test() { System.out.println("A"); }}
interface B { default void test() { System.out.println("B"); }}
class C implements A, B {
    // Must override to resolve conflict
    @Override
    public void test() {
        A.super.test(); // Explicitly call A's implementation
    }
}
```

### **Trap 5**: "Explain the difference between shallow and deep cloning"
```java
public class DeepCloneExample implements Cloneable {
    private String name;
    private List<String> hobbies;
    
    // Shallow clone (default)
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Only copies references
    }
    
    // Deep clone implementation
    public DeepCloneExample deepClone() {
        DeepCloneExample copy = new DeepCloneExample();
        copy.name = this.name; // String is immutable, safe to share
        copy.hobbies = new ArrayList<>(this.hobbies); // Create new list
        return copy;
    }
}
```

### **Trap 6**: "How do you handle serialization with inheritance?"
```java
class Parent implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String parentField;
}

class Child extends Parent {
    private static final long serialVersionUID = 1L;
    private transient String temporaryField; // Won't be serialized
    private String childField;
    
    // Custom serialization
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // Custom serialization logic
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        // Custom deserialization logic
        this.temporaryField = "reconstructed";
    }
}
```

---

## 📋 Complete Pre-Interview Checklist

### **Core OOP (Must Know Cold)** ❄️
- [ ] 4 OOP pillars with complex real-world examples
- [ ] Abstract class vs Interface (including Java 8+ features)
- [ ] Method overloading vs overriding (all rules and edge cases)
- [ ] Constructor chaining, super() keyword, initialization order
- [ ] All access modifiers and their exact scope
- [ ] Static vs Instance members (including static blocks)
- [ ] final keyword (class, method, variable, parameter)
- [ ] Object class methods (equals, hashCode, toString, clone)

### **Advanced OOP Concepts** 🔥
- [ ] Generics (bounded types, wildcards, type erasure)
- [ ] Annotations and reflection basics
- [ ] Functional interfaces and lambda expressions
- [ ] Method references (static, instance, constructor)
- [ ] Enum with methods and constructor
- [ ] Records (Java 14+) and their use cases
- [ ] Sealed classes (Java 17+) and pattern matching
- [ ] Inner classes (static, non-static, local, anonymous)
- [ ] Immutable object design patterns

### **Memory & Concurrency** ⚡
- [ ] Object lifecycle and garbage collection
- [ ] Method hiding vs method overriding
- [ ] Thread-safe singleton patterns
- [ ] Immutable objects and defensive copying
- [ ] Volatile keyword and its relation to OOP
- [ ] Synchronization in OOP context

### **Design Patterns Integration** 🎨
- [ ] Singleton (all variations)
- [ ] Factory pattern (simple, abstract factory)
- [ ] Builder pattern for complex object creation
- [ ] Observer pattern with modern Java features
- [ ] Strategy pattern with functional interfaces
- [ ] Decorator pattern vs inheritance
- [ ] Chain of Responsibility pattern

### **Expert Level Topics** 🎓
- [ ] Covariant return types and contravariance
- [ ] Default methods in interfaces and diamond problem
- [ ] Serialization with inheritance hierarchies
- [ ] Custom annotations and annotation processing
- [ ] Reflection API for OOP analysis
- [ ] Lambda expressions vs anonymous inner classes
- [ ] Stream API integration with OOP principles

---

## 🎯 Platform-Specific Focus Areas

### **Google/Alphabet**
- Focus on: Clean code principles, SOLID principles integration, generic programming
- Common ask: "Design a extensible framework using OOP principles"

### **Amazon**
- Focus on: Scalability patterns, composition over inheritance, builder patterns  
- Common ask: "Design a system that can handle millions of objects efficiently"

### **Meta/Facebook**
- Focus on: Performance implications of OOP choices, memory management
- Common ask: "Optimize this OOP design for mobile applications"

### **Apple**
- Focus on: Design patterns, protocol-oriented programming concepts
- Common ask: "How would you design iOS-like delegation patterns in Java?"

### **Netflix/Microsoft**
- Focus on: Reactive programming integration, functional programming with OOP
- Common ask: "Combine OOP with functional programming paradigms"

### **Startups (20+ LPA)**
- Focus on: Practical applications, rapid prototyping with clean architecture
- Common ask: "Build a MVP using proper OOP design that can scale later"

---

## 🎯 Core OOP Principles (The Foundation)

### 1. **Encapsulation** 🔒
**Definition**: Data hiding + bundling data with methods that operate on it

**Key Interview Points**:
- **Access Modifiers**: `private`, `protected`, `public`, `default`
- **Getter/Setter Design**: Validation, immutability patterns
- **Benefits**: Security, Maintainability, Modularity

```java
public class BankAccount {
    private double balance;  // Encapsulated
    private final String accountNumber;  // Immutable
    
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;  // Validation in setter logic
    }
    
    public double getBalance() { return balance; }
    // No setter for balance - controlled access only
}
```

**FAANG Interview Trap**: "Why not make everything public?"
- **Answer**: Violates encapsulation, breaks contract, makes debugging harder, security risks

---

### 2. **Inheritance** 🧬
**Definition**: IS-A relationship, code reuse through parent-child hierarchy

**Critical Interview Concepts**:
- **Single vs Multiple**: Java supports single class inheritance, multiple interface inheritance
- **Constructor Chaining**: `super()` calls
- **Method Resolution**: How JVM resolves method calls

```java
// Base class
abstract class Vehicle {
    protected String brand;
    protected int year;
    
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    public abstract void start();
    public void displayInfo() {
        System.out.println(brand + " " + year);
    }
}

// Derived class
class ElectricCar extends Vehicle {
    private int batteryCapacity;
    
    public ElectricCar(String brand, int year, int batteryCapacity) {
        super(brand, year);  // Constructor chaining
        this.batteryCapacity = batteryCapacity;
    }
    
    @Override
    public void start() {
        System.out.println("Electric car starts silently");
    }
    
    // Additional method specific to ElectricCar
    public void chargeBattery() {
        System.out.println("Charging battery...");
    }
}
```

**MAANG Follow-up**: "What's the diamond problem and how does Java solve it?"
- **Answer**: Multiple inheritance ambiguity. Java uses interfaces with default methods (Java 8+)

---

### 3. **Polymorphism** 🎭
**Definition**: One interface, multiple implementations

**Two Types**:
1. **Compile-time** (Static): Method Overloading
2. **Runtime** (Dynamic): Method Overriding

#### Compile-time Polymorphism
```java
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c) { return a + b + c; }
    
    // Overloading rules: different parameters (number, type, order)
}
```

#### Runtime Polymorphism
```java
class Shape {
    public double calculateArea() { return 0; }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) { this.radius = radius; }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Runtime polymorphism in action
public class PolymorphismDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Circle(3)
        };
        
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
            // Method resolution happens at runtime
        }
    }
}
```

**Senior Level Question**: "How does JVM achieve runtime polymorphism?"
- **Answer**: Virtual Method Invocation, Method Table lookup, Dynamic Binding

---

### 4. **Abstraction** 🎨
**Definition**: Hiding implementation complexity, showing only essential features

**Implementation Ways**:
- **Abstract Classes**: 0-100% abstraction
- **Interfaces**: 100% abstraction (pre-Java 8)

```java
// Abstract class example
abstract class DatabaseConnection {
    protected String connectionString;
    
    public DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }
    
    // Concrete method
    public void logConnection() {
        System.out.println("Connected to: " + connectionString);
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract boolean connect();
    public abstract void disconnect();
    public abstract ResultSet executeQuery(String query);
}

class MySQLConnection extends DatabaseConnection {
    public MySQLConnection(String connectionString) {
        super(connectionString);
    }
    
    @Override
    public boolean connect() {
        // MySQL-specific connection logic
        System.out.println("MySQL connection established");
        return true;
    }
    
    @Override
    public void disconnect() {
        System.out.println("MySQL connection closed");
    }
    
    @Override
    public ResultSet executeQuery(String query) {
        // MySQL-specific query execution
        return null; // Simplified
    }
}
```

---

## 🏗️ Advanced OOP Concepts (FAANG Level)

### **Interface Evolution (Java 8+)**
```java
interface PaymentProcessor {
    // Abstract method (traditional)
    boolean processPayment(double amount);
    
    // Default method (Java 8+)
    default void logTransaction(double amount) {
        System.out.println("Processing payment: $" + amount);
    }
    
    // Static method (Java 8+)
    static boolean validateAmount(double amount) {
        return amount > 0;
    }
    
    // Private method (Java 9+)
    private void internalLog(String message) {
        System.out.println("Internal: " + message);
    }
}
```

### **Multiple Inheritance via Interfaces**
```java
interface Flyable {
    void fly();
    default void takeOff() {
        System.out.println("Taking off...");
    }
}

interface Swimmable {
    void swim();
    default void dive() {
        System.out.println("Diving...");
    }
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck flying");
    }
    
    @Override
    public void swim() {
        System.out.println("Duck swimming");
    }
}
```

### **Composition vs Inheritance**
```java
// Composition (HAS-A relationship) - Preferred approach
class Engine {
    private String type;
    
    public Engine(String type) { this.type = type; }
    public void start() { System.out.println(type + " engine started"); }
}

class Car {
    private Engine engine;  // Composition
    private String model;
    
    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }
    
    public void startCar() {
        engine.start();  // Delegating to composed object
        System.out.println(model + " is ready to drive");
    }
}
```

---

## 🔥 MAANG Interview Deep Dive Questions

### **Q1: Explain the difference between `==` and `.equals()` in the context of OOP**

```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

**Answer**: 
- `==` compares references (memory addresses)
- `.equals()` compares object content (must be overridden)
- Always override `hashCode()` when overriding `equals()`

### **Q2: How would you design a class hierarchy for a shape drawing application?**

```java
// Strategy pattern with OOP
interface DrawingStrategy {
    void draw();
}

abstract class Shape {
    protected String color;
    protected DrawingStrategy strategy;
    
    public Shape(String color) {
        this.color = color;
    }
    
    public void setDrawingStrategy(DrawingStrategy strategy) {
        this.strategy = strategy;
    }
    
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    public void render() {
        if (strategy != null) {
            strategy.draw();
        }
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

### **Q3: Explain method overriding rules and common pitfalls**

**Overriding Rules**:
1. Same method signature (name, parameters, return type)
2. Cannot reduce visibility (`public` → `private` ❌)
3. Can increase visibility (`protected` → `public` ✅)
4. Cannot override `static`, `final`, or `private` methods
5. Must handle same or fewer checked exceptions

```java
class Parent {
    protected void display() throws IOException {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    @Override
    public void display() {  // Increased visibility ✅
        System.out.println("Child display");
        // Removed IOException - fewer exceptions ✅
    }
}
```

---

## 🎯 Design Patterns with OOP

### **Singleton Pattern**
```java
public class DatabaseManager {
    private static volatile DatabaseManager instance;
    private DatabaseManager() {}  // Private constructor
    
    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }
}
```

### **Factory Pattern**
```java
abstract class Vehicle {
    public abstract void start();
}

class Car extends Vehicle {
    @Override
    public void start() { System.out.println("Car started"); }
}

class Bike extends Vehicle {
    @Override
    public void start() { System.out.println("Bike started"); }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car": return new Car();
            case "bike": return new Bike();
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
```

---

## 🚨 Common Interview Traps & Solutions

### **Trap 1**: "Can you override a static method?"
**Answer**: No, static methods belong to the class, not instance. You can **hide** them, not override.

### **Trap 2**: "What happens if you don't call `super()` in constructor?"
**Answer**: Java automatically calls `super()` with no arguments. If parent doesn't have default constructor, compilation fails.

### **Trap 3**: "Is Java pass-by-reference or pass-by-value?"
**Answer**: Always pass-by-value. For objects, we pass the reference value (memory address), not the reference itself.

```java
public void modifyObject(Person person) {
    person.setName("Modified");  // Changes original object
    person = new Person("New");  // Only changes local reference
}
```

---

## 🧬 Advanced Java OOP Concepts (Frequently Missed)

### **Generics & Type Safety**
```java
// Generic class with bounded type parameters
public class Repository<T extends Serializable> {
    private List<T> items = new ArrayList<>();
    
    public void add(T item) {
        items.add(item);
    }
    
    public Optional<T> findById(int id) {
        return id < items.size() ? Optional.of(items.get(id)) : Optional.empty();
    }
    
    // Generic method with wildcard
    public static void printItems(List<? extends Number> numbers) {
        for (Number num : numbers) {
            System.out.println(num);
        }
    }
}

// Usage with different types
Repository<String> stringRepo = new Repository<>();
Repository<Integer> intRepo = new Repository<>();
```

**FAANG Question**: "Explain type erasure and why `List<String>` and `List<Integer>` are same at runtime"
- **Answer**: Java uses type erasure - generic type info is removed at runtime for backward compatibility

### **Annotations & Reflection**
```java
// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Benchmarkable {
    String value() default "";
    int iterations() default 1;
}

// Using reflection with OOP
public class PerformanceAnalyzer {
    public static void analyzeClass(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmarkable.class)) {
                Benchmarkable benchmark = method.getAnnotation(Benchmarkable.class);
                System.out.println("Benchmarking: " + method.getName() + 
                                 " for " + benchmark.iterations() + " iterations");
            }
        }
    }
}

class Service {
    @Benchmarkable(iterations = 1000)
    public void performTask() {
        // Task implementation
    }
}
```

### **Functional Interfaces & Lambda Expressions**
```java
// Custom functional interface
@FunctionalInterface
public interface DataProcessor<T, R> {
    R process(T input);
    
    // Default method - allowed in functional interfaces
    default void log(String message) {
        System.out.println("Processing: " + message);
    }
}

// Using with lambda expressions
public class DataService {
    public static <T, R> List<R> processData(List<T> data, DataProcessor<T, R> processor) {
        return data.stream()
                   .map(processor::process)
                   .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Lambda expression implementing functional interface
        List<Integer> lengths = processData(names, name -> name.length());
        
        // Method reference
        List<String> upperNames = processData(names, String::toUpperCase);
    }
}
```

### **Enum with OOP Features**
```java
public enum PaymentMethod {
    CREDIT_CARD("Credit Card", 2.5) {
        @Override
        public double calculateFee(double amount) {
            return amount * (getRate() / 100);
        }
    },
    DEBIT_CARD("Debit Card", 1.0) {
        @Override
        public double calculateFee(double amount) {
            return Math.max(amount * (getRate() / 100), 0.50); // Minimum fee
        }
    },
    PAYPAL("PayPal", 3.0) {
        @Override
        public double calculateFee(double amount) {
            return amount * (getRate() / 100) + 0.30; // Fixed fee + percentage
        }
    };
    
    private final String displayName;
    private final double rate;
    
    PaymentMethod(String displayName, double rate) {
        this.displayName = displayName;
        this.rate = rate;
    }
    
    public abstract double calculateFee(double amount);
    
    public String getDisplayName() { return displayName; }
    protected double getRate() { return rate; }
}
```

### **Records (Java 14+) - Modern OOP**
```java
// Immutable data class with built-in methods
public record Person(String name, int age, String email) {
    // Compact constructor for validation
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
    
    // Additional methods
    public boolean isAdult() {
        return age >= 18;
    }
    
    // Static factory method
    public static Person createChild(String name, int age) {
        return new Person(name, age, "no-email@example.com");
    }
}

// Usage
Person person = new Person("John", 25, "john@example.com");
System.out.println(person.name()); // Auto-generated getter
```

### **Sealed Classes (Java 17+) - Controlled Inheritance**
```java
// Sealed class - restricted inheritance
public sealed class Shape permits Circle, Rectangle, Triangle {
    protected final String color;
    
    protected Shape(String color) {
        this.color = color;
    }
    
    public abstract double calculateArea();
}

// Permitted subclasses
public final class Circle extends Shape {
    private final double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public final class Rectangle extends Shape {
    private final double length, width;
    
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Pattern matching with sealed classes
public class ShapeCalculator {
    public static String getShapeInfo(Shape shape) {
        return switch (shape) {
            case Circle c -> "Circle with radius: " + c.radius;
            case Rectangle r -> "Rectangle: " + r.length + "x" + r.width;
            case Triangle t -> "Triangle with base: " + t.base;
        };
    }
}
```

---

## 🏆 Expert Level Concepts

### **Covariant Return Types**
```java
class Animal {
    public Animal reproduce() {
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    public Dog reproduce() {  // Covariant return type
        return new Dog();
    }
}
```

### **Inner Classes & Encapsulation**
```java
public class OuterClass {
    private String outerField = "Outer";
    
    class InnerClass {
        public void accessOuter() {
            System.out.println(outerField);  // Direct access to private field
        }
    }
    
    static class StaticNestedClass {
        // Cannot access non-static outer members directly
    }
}
```

---

## 📋 Pre-Interview Checklist

### **Must Know Cold** ❄️
- [ ] 4 OOP pillars with real-world examples
- [ ] Abstract class vs Interface (with Java 8+ features)
- [ ] Method overloading vs overriding rules
- [ ] Constructor chaining and `super()` keyword
- [ ] Access modifiers and their scope
- [ ] Static vs Instance members
- [ ] `final` keyword usage (class, method, variable)

### **Advanced Topics** 🔥
- [ ] Composition vs Inheritance trade-offs
- [ ] Covariant return types
- [ ] Method hiding vs Method overriding
- [ ] Inner classes and their types
- [ ] Default methods in interfaces
- [ ] Diamond problem resolution

### **Design Patterns** 🎨
- [ ] Singleton (thread-safe implementation)
- [ ] Factory pattern
- [ ] Strategy pattern
- [ ] Observer pattern basics

---

## 🎯 Sample FAANG Questions

### **Google/Microsoft Style**
"Design a class hierarchy for a media player that can play different formats (MP3, MP4, AVI). Consider extensibility and maintainability."

### **Amazon Style**
"Implement a caching system using OOP principles. How would you handle cache eviction policies?"

### **Meta/Apple Style**
"Explain how you would use composition to design a flexible notification system for different platforms (Email, SMS, Push)."

---

## 💡 Pro Tips for Interview Success

1. **Start with Real-world Analogy**: "Abstraction is like driving a car - you use steering wheel without knowing engine internals"

2. **Code First, Explain Later**: Write clean, compilable code snippets

3. **Discuss Trade-offs**: "Inheritance provides code reuse but creates tight coupling. Composition offers flexibility but requires more code"

4. **Show Depth**: Mention related concepts like SOLID principles, design patterns

5. **Ask Clarifying Questions**: "Should this be thread-safe?" "Are there performance constraints?"

---

## 🚀 Ready for MAANG Success!

**Remember**: OOP is not just about syntax - it's about designing maintainable, scalable, and robust software systems. Focus on the **why** behind each concept, not just the **how**.

Good luck with your interviews! 🍀