### 🧠 Time & Space Complexity Cheat Sheet (DSA Revision)

---

#### 🔍 What is **Time Complexity**?

Time Complexity measures **how the number of operations grows** with input size `n`.

It's written using **Big-O notation**:

| Notation     | Description       | Examples                         |
| ------------ | ----------------- | -------------------------------- |
| `O(1)`       | Constant time     | Accessing an array element       |
| `O(log n)`   | Logarithmic time  | Binary Search                    |
| `O(n)`       | Linear time       | Looping through an array         |
| `O(n log n)` | Efficient sorting | Merge Sort, QuickSort            |
| `O(n²)`      | Quadratic time    | Nested loops                     |
| `O(2ⁿ)`      | Exponential time  | Recursive Fibonacci              |
| `O(n!)`      | Factorial time    | Permutations, Traveling Salesman |

---

#### 🔸 **Time Complexity Example in Java**

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
// Time Complexity: O(n)
```

---

#### 🧠 What is **Space Complexity**?

Space Complexity measures how much **extra memory** your code uses based on input size `n`.

It includes:

* Variables
* Function calls
* Data structures (arrays, hashmaps, etc.)

---

#### 🔸 **Space Complexity Example in Java**

```java
int[] arr = new int[n]; 
// Space Complexity: O(n)
```

---

### ✅ Why It Matters (Especially for MAANG/FAANG Interviews)

* ✅ Your solution must **work correctly**
* ✅ Your solution must be **efficient**

For the same problem:

* ❌ Brute-force: `O(n²)`
* ✅ Optimized: `O(n log n)`

---

### 🚦 Quick Analogy: The *Pen Search*

* **O(n²)** – Ask every friend about every other friend (brute force).
* **O(n)** – Ask each friend one by one (linear search).
* **O(log n)** – Split group & ask smartly (binary search).
* **O(1)** – You already know who has the pen (instant).

---

### 📝 Summary Table

| Notation     | Description       | Example               |
| ------------ | ----------------- | --------------------- |
| `O(1)`       | Constant time     | Array access          |
| `O(log n)`   | Logarithmic time  | Binary Search         |
| `O(n)`       | Linear time       | Single loop           |
| `O(n log n)` | Efficient sorting | Merge Sort, QuickSort |
| `O(n²)`      | Quadratic time    | Nested loops          |
| `O(2ⁿ)`      | Exponential time  | Recursive Fibonacci   |

---

### 💡 Final Tip for Interviews

> 🔁 **Always mention Time & Space Complexity** when explaining a solution.

🗣 **Example**:

> “This approach runs in `O(n log n)` time and `O(1)` space as we’re not using any extra data structures.”

---

