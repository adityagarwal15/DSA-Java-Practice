# ☕ Java Time & Space Complexity Guide
## **Simple & Complete for FAANG Interviews**

---

## 🎯 **Quick Pattern Recognition**

```java
// LOOPS → Count iterations (Time) + Count variables (Space)
for(int i = 0; i < n; i++) { }

// RECURSION → Master's Theorem (Time) + Call stack depth (Space)  
public int solve(int n) { return solve(n/2); }

// DATA STRUCTURES → Know operation costs + memory usage
ArrayList, HashMap, TreeMap operations
```

---

## 🔧 **Method 1: Loop Analysis (70% of problems)**

### **Basic Patterns**
```java
// Time: O(n), Space: O(1) - Single loop
for(int i = 0; i < n; i++) {
    // O(1) work, no extra space
}

// Time: O(n²), Space: O(1) - Nested loops
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        // O(1) work, no extra space
    }
}

// Time: O(log n), Space: O(1) - Halving
while(n > 1) {
    n = n / 2;  // Binary search pattern, constant space
}

// Time: O(n), Space: O(n) - Creating array
int[] result = new int[n];  // Space grows with input
for(int i = 0; i < n; i++) {
    result[i] = i * 2;
}
```

### **Tricky Patterns**
```java
// Time: O(n²), Space: O(1) - Triangle pattern
for(int i = 0; i < n; i++) {
    for(int j = 0; j < i; j++) {  // 0 to i-1
        // O(1) work, no extra space
    }
}
// Total: 1 + 2 + 3 + ... + n = n²/2 = O(n²)

// Time: O(n log n), Space: O(1) - Outer n, inner log n
for(int i = 0; i < n; i++) {
    int j = n;
    while(j > 1) {
        j = j / 2;  // log n iterations, constant space
    }
}

// Time: O(n), Space: O(n) - Building result
List<Integer> result = new ArrayList<>();
for(int i = 0; i < n; i++) {
    result.add(i);  // Space grows with each addition
}
```

---

## 🌳 **Method 2: Recursion Analysis**

### **Master's Theorem** (Most Important!)
**Pattern:** `T(n) = a*T(n/b) + f(n)`

```java
// Case 1: T(n) = 4T(n/2) + O(n) → O(n²)
// Case 2: T(n) = 2T(n/2) + O(n) → O(n log n)  
// Case 3: T(n) = 2T(n/2) + O(n²) → O(n²)
```

### **Common Examples**
```java
// Time: O(n log n), Space: O(n) - Merge Sort
public void mergeSort(int[] arr, int l, int r) {
    if(l < r) {
        int mid = l + (r-l)/2;
        mergeSort(arr, l, mid);      // T(n/2)
        mergeSort(arr, mid+1, r);    // T(n/2)
        merge(arr, l, mid, r);       // O(n) + O(n) temp array
    }
} // Time: T(n) = 2T(n/2) + O(n) → O(n log n)
  // Space: O(n) for merge + O(log n) call stack = O(n)

// Time: O(log n), Space: O(log n) - Binary Search (Recursive)
public int binarySearch(int[] arr, int target, int low, int high) {
    if(low > high) return -1;
    int mid = low + (high - low) / 2;
    if(arr[mid] == target) return mid;
    else if(arr[mid] > target)
        return binarySearch(arr, target, low, mid-1);    // Call stack
    else
        return binarySearch(arr, target, mid+1, high);   // Call stack
} // Time: T(n) = T(n/2) + O(1) → O(log n)
  // Space: O(log n) for call stack

// Time: O(log n), Space: O(1) - Binary Search (Iterative)
public int binarySearchIterative(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while(low <= high) {
        int mid = low + (high - low) / 2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] < target) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
} // Space: O(1) - only few variables

// Time: O(2ⁿ), Space: O(n) - Bad Fibonacci
public int fibonacci(int n) {
    if(n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);  // 2 calls each time
} // Time: T(n) = T(n-1) + T(n-2) → O(2ⁿ)
  // Space: O(n) - maximum call stack depth
```

---

## 💾 **Method 3: Java Collections (Time + Space)**

### **ArrayList Operations**
```java
List<Integer> list = new ArrayList<>(); // Space: O(1) initially
list.add(x);         // Time: O(1) amortized, Space: +O(1) per element
list.add(0, x);      // Time: O(n), Space: +O(1)
list.get(i);         // Time: O(1), Space: O(1)
list.remove(i);      // Time: O(n), Space: O(1)
list.contains(x);    // Time: O(n), Space: O(1)
Collections.sort(list); // Time: O(n log n), Space: O(1) or O(log n)

// Creating ArrayList of size n
List<Integer> list = new ArrayList<>(n); // Space: O(n)
```

### **HashMap Operations**
```java
Map<String, Integer> map = new HashMap<>(); // Space: O(1) initially
map.put(key, value); // Time: O(1) average, Space: +O(1) per entry
map.get(key);        // Time: O(1) average, Space: O(1)
map.remove(key);     // Time: O(1) average, Space: O(1)
map.containsKey(key); // Time: O(1) average, Space: O(1)

// After adding n entries
// Total space: O(n)

// Iteration
for(String key : map.keySet()) { } // Time: O(n), Space: O(1)
```

### **TreeMap Operations** 
```java
Map<String, Integer> treeMap = new TreeMap<>(); // Space: O(1) initially
treeMap.put(key, value);  // Time: O(log n), Space: +O(1) per entry
treeMap.get(key);         // Time: O(log n), Space: O(1)
treeMap.remove(key);      // Time: O(log n), Space: O(1)

// After adding n entries
// Total space: O(n)
```

### **Space Complexity Patterns**
```java
// O(1) Space - Constant
int sum = 0;
for(int i = 0; i < n; i++) {
    sum += arr[i];  // Only using existing variables
}

// O(n) Space - Linear with input
int[] copy = new int[n];  // New array of size n

// O(n) Space - Recursive call stack
public int factorial(int n) {
    if(n <= 1) return 1;
    return n * factorial(n-1);  // n recursive calls on stack
}

// O(log n) Space - Divide and conquer call stack
public int binarySearch(int[] arr, int target, int low, int high) {
    // ... recursive binary search
    // Maximum log n calls on stack
}
```

---

## 🎯 **Quick Decision Process**

### **Step 1: What do you see?**
```java
// Single loop? → Time: O(n), Space: O(1) usually
for(int i = 0; i < n; i++)

// Nested loops? → Time: O(n²), Space: O(1) usually
for(int i = 0; i < n; i++)
    for(int j = 0; j < n; j++)

// Creating new array? → Space: +O(n)
int[] newArray = new int[n];

// Recursion calling itself? → Time: Master's Theorem, Space: Call stack depth
return solve(n/2) + solve(n/2);

// Using ArrayList.contains()? → Time: O(n), Space: O(1)
// Using HashMap.get()? → Time: O(1), Space: O(1)
```

### **Step 2: Count operations AND memory**
- **Time:** Multiply the iterations, apply Master's Theorem
- **Space:** Count new data structures + recursion depth
```java
// Example: Time O(n), Space O(n)
int[] result = new int[n];  // O(n) space
for(int i = 0; i < n; i++) { // O(n) time
    result[i] = arr[i] * 2;
}
```

---

## 🔥 **Common Interview Patterns**

### **Sorting Algorithms**
```java
// Bubble Sort - Time: O(n²), Space: O(1)
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n-1; j++) {
        if(arr[j] > arr[j+1]) swap(arr, j, j+1); // In-place swapping
    }
}

// Arrays.sort() - Time: O(n log n), Space: O(log n)
Arrays.sort(arr); // Uses quicksort/mergesort hybrid

// Collections.sort() - Time: O(n log n), Space: O(1) or O(log n)
Collections.sort(list); // Timsort algorithm
```

### **Searching Patterns**
```java
// Linear Search - Time: O(n), Space: O(1)
for(int i = 0; i < n; i++) {
    if(arr[i] == target) return i; // No extra space
}

// Binary Search (Iterative) - Time: O(log n), Space: O(1)
int left = 0, right = n-1;
while(left <= right) {
    int mid = left + (right - left) / 2; // Few variables only
    if(arr[mid] == target) return mid;
    else if(arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}

// Binary Search (Recursive) - Time: O(log n), Space: O(log n)
// Space is O(log n) due to call stack depth
```

### **Two Pointer Technique**
```java
// Time: O(n), Space: O(1) - Single pass, constant space
int left = 0, right = n-1;
while(left < right) {
    // Process arr[left] and arr[right]
    left++;
    right--;
}
```

---

## 🧠 **Memory Shortcuts**

### **Time Complexity - Instant Recognition:**
- **One loop through n** → `O(n)`
- **Two nested loops** → `O(n²)`
- **Divide by 2 each time** → `O(log n)`
- **Call function twice recursively** → Usually `O(2ⁿ)` or check Master's
- **ArrayList.get()** → `O(1)`
- **ArrayList.contains()** → `O(n)`
- **HashMap.get()** → `O(1)`

### **Space Complexity - Instant Recognition:**
- **Few variables only** → `O(1)`
- **Create array of size n** → `O(n)`
- **HashMap with n entries** → `O(n)`
- **Recursive calls n deep** → `O(n)` stack space
- **Recursive calls log n deep** → `O(log n)` stack space

### **Red Flags (Avoid These!):**
```java
// Time: O(2ⁿ), Space: O(n) - Exponential time, linear space
public int badFib(int n) {
    if(n <= 1) return n;
    return badFib(n-1) + badFib(n-2);
}

// Time: O(n!), Space: O(n!) - Factorial, extremely slow!
public void generatePermutations(String str) {
    // Generates all permutations - avoid unless n is very small
}

// Space: O(n²) - Avoid creating 2D arrays unnecessarily
int[][] matrix = new int[n][n];
```

---

## 🏆 **Interview Strategy**

### **1. Identify (10 seconds)**
```
Loops? → Count iterations (Time) + Check for new arrays (Space)
Recursion? → Master's theorem (Time) + Call stack depth (Space)
Collections? → Know operation costs (Time) + Storage size (Space)
```

### **2. Calculate (20 seconds)**
```
Single loop: Time O(n), Space O(1) usually
Nested loops: Time O(n²), Space O(1) usually
Divide & conquer: Time O(n log n), Space O(log n) usually
New array: Space +O(n)
```

### **3. Verify (10 seconds)**
```
Does O(n²) time make sense for nested loops? ✓
Does O(n) space make sense for new array? ✓
Does O(log n) space make sense for recursion depth? ✓
```

### **4. State both complexities**
```
"Time complexity is O(n log n), Space complexity is O(n)"
"Time complexity is O(1), Space complexity is O(1)"
```

---

## 📝 **Practice Examples**

```java
// What's the complexity?
for(int i = 1; i < n; i *= 2) {        // How many times? log n
    for(int j = 0; j < n; j++) {       // n times
        System.out.println(i + j);     // O(1) work, no extra space
    }
}
// Answer: Time O(n log n), Space O(1)

// What's the complexity?
public int mystery(int n) {
    if(n <= 1) return 1;
    return mystery(n/2) + mystery(n/2);
}
// T(n) = 2T(n/2) + O(1) → Master's Case 1 → Time O(n)
// Space: O(log n) for call stack depth

// What's the complexity?
Map<Integer, String> map = new HashMap<>();
for(int i = 0; i < n; i++) {           // n times
    map.put(i, "value" + i);           // O(1) each
}
// Answer: Time O(n), Space O(n) for storing n entries

// What's the complexity?
int[] result = new int[n];             // O(n) space
for(int i = 0; i < n; i++) {          // O(n) time
    for(int j = 0; j < n; j++) {      // O(n) time
        result[i] += arr[j];          // O(1) work
    }
}
// Answer: Time O(n²), Space O(n)

// What's the complexity?
public List<Integer> solve(int[] arr) {
    List<Integer> result = new ArrayList<>();  // O(1) initially
    for(int i = 0; i < arr.length; i++) {     // O(n) time
        if(arr[i] > 0) {
            result.add(arr[i]);               // O(1) amortized
        }
    }
    return result;
}
// Answer: Time O(n), Space O(k) where k = number of positive elements
//         Worst case: Space O(n) if all elements are positive
```

---

## 💡 **Final Tips**

✅ **Do:**
- Think step by step for both time AND space
- Count the dominant loops AND new data structures
- Know your collection operations AND their memory usage
- Practice mental math for Master's Theorem
- Always mention both complexities in interviews

❌ **Don't:**  
- Guess without reasoning
- Forget about nested operations
- Ignore space complexity (very common mistake!)
- Forget about recursion call stack space
- Panic - follow the process!

---

> 🎯 **Master these 3 methods for both time AND space, and you'll solve 95% of complexity questions!**
> 
> **Quick Memory Aid:** 
> - **Time** = How many operations?  
> - **Space** = How much extra memory?