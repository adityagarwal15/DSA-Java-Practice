# ⏱️ Time & Space Complexity - Quick Interview Revision

**Essential DSA concepts for coding interviews - memorize these patterns!**

---

## 🎯 Must-Know Big-O Rankings (Best to Worst)

```
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ) < O(n!)
```

| Complexity | Name | Speed | Examples |
|------------|------|-------|----------|
| `O(1)` | Constant | ⚡ Instant | Array access, HashMap get |
| `O(log n)` | Logarithmic | 🚀 Very Fast | Binary search, balanced tree ops |
| `O(n)` | Linear | ✅ Good | Single loop, linear search |
| `O(n log n)` | Linearithmic | 👍 Acceptable | Merge sort, heap sort |
| `O(n²)` | Quadratic | 🐌 Slow | Nested loops, bubble sort |
| `O(2ⁿ)` | Exponential | 💀 Very Slow | Recursive fibonacci |
| `O(n!)` | Factorial | ☠️ Extremely Slow | All permutations |

---

## 🔥 Common Interview Questions

### Q1: "What's the time complexity of this code?"

**Pattern Recognition:**
```java
// O(1) - Constant
arr[0] = 5;
map.get(key);

// O(n) - Linear  
for(int i = 0; i < n; i++) { }

// O(n²) - Quadratic
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) { }
}

// O(log n) - Logarithmic
while(n > 1) { n = n/2; }  // Binary search pattern
```

### Q2: "How do you optimize this O(n²) solution?"

**Common Optimizations:**
- **Hash Map/Set:** O(n²) → O(n)
- **Two Pointers:** O(n²) → O(n)
- **Sorting first:** O(n²) → O(n log n)
- **Binary Search:** O(n²) → O(n log n)

---

## 📊 Quick Pattern Recognition

### Time Complexity Patterns
```java
// O(1) - Direct access
return arr[index];
return map.get(key);

// O(log n) - Divide by half each time
int binary_search(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}

// O(n) - Visit each element once
for(int i = 0; i < n; i++) {
    // constant work
}

// O(n log n) - Sort or divide-and-conquer
Arrays.sort(arr);  // Merge sort
mergeSort(arr);

// O(n²) - Nested loops
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        // constant work
    }
}
```

### Space Complexity Patterns
```java
// O(1) - Constant extra space
int temp = arr[i];
int sum = 0;

// O(n) - Linear extra space
int[] temp = new int[n];
List<Integer> list = new ArrayList<>();

// O(n) - Recursive call stack
public int fibonacci(int n) {
    if(n <= 1) return n;
    return fibonacci(n-1) + fibonacci(n-2);  // O(2ⁿ) calls, O(n) depth
}
```

---

## 🚨 Interview Red Flags to Avoid

### ❌ Don't Say This:
- "I think it's O(n)" (be confident!)
- "Time complexity doesn't matter"
- Just giving the answer without explanation

### ✅ Say This Instead:
- "The time complexity is O(n) because we iterate through the array once"
- "We can optimize this from O(n²) to O(n) using a HashMap"
- "Trade-off: O(n) space for O(n) time improvement"

---

## 🎯 Data Structure Complexities (Memorize These!)

### Array/ArrayList
| Operation | Time | Space |
|-----------|------|-------|
| Access | O(1) | - |
| Search | O(n) | - |
| Insert (end) | O(1) | - |
| Insert (middle) | O(n) | - |
| Delete | O(n) | - |

### HashMap/HashSet
| Operation | Average | Worst Case |
|-----------|---------|------------|
| Get/Put | O(1) | O(n) |
| Delete | O(1) | O(n) |
| Space | O(n) | O(n) |

### Binary Search Tree (Balanced)
| Operation | Time | Space |
|-----------|------|-------|
| Search | O(log n) | O(log n) |
| Insert | O(log n) | O(log n) |
| Delete | O(log n) | O(log n) |

---

## 🏆 Problem-Solving Framework

### Step-by-Step Approach:
1. **Understand the problem**
2. **Think of brute force** (usually O(n²) or O(2ⁿ))
3. **Identify bottlenecks**
4. **Apply optimization techniques**:
   - Hash Map for lookups
   - Two pointers for sorted arrays
   - Binary search for searching
   - Divide and conquer
5. **Calculate complexity** and explain trade-offs

### Common Optimization Patterns:
```java
// Pattern 1: Two Sum (O(n²) → O(n))
// Brute force: nested loops
// Optimized: HashMap

// Pattern 2: Find duplicates (O(n²) → O(n))
// Brute force: compare all pairs  
// Optimized: HashSet

// Pattern 3: Sorted array operations (O(n²) → O(n))
// Brute force: nested loops
// Optimized: Two pointers
```

---

## 💡 Quick Practice Problems

### Problem 1: Two Sum
```java
// ❌ Brute Force: O(n²) time, O(1) space
public int[] twoSum(int[] nums, int target) {
    for(int i = 0; i < nums.length; i++) {
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[i] + nums[j] == target) 
                return new int[]{i, j};
        }
    }
    return new int[]{};
}

// ✅ Optimized: O(n) time, O(n) space
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if(map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
```

### Problem 2: Find Maximum
```java
// O(n) time, O(1) space
public int findMax(int[] arr) {
    int max = arr[0];
    for(int i = 1; i < arr.length; i++) {  // O(n)
        if(arr[i] > max) max = arr[i];     // O(1)
    }
    return max;
}
```

---

## 🧠 Memory Tricks

### **"SAIL" Method for Analysis:**
- **S**ize of input (what's n?)
- **A**lgorithm steps (loops, recursion)
- **I**dentify the dominant operation
- **L**ook for optimization opportunities

### **Space Complexity Checklist:**
- Variables: O(1)
- Arrays/Lists of size n: O(n)
- 2D arrays: O(n²)
- Recursion depth: O(depth)
- Hash maps with n elements: O(n)

---

## 🎯 Interview Success Tips

### Always Mention Both:
```java
"This solution has O(n) time complexity because we visit each element once,
and O(1) space complexity because we only use a few extra variables."
```

### Show Optimization Thinking:
```java
"The brute force approach would be O(n²), but we can optimize it to O(n) 
by using a HashMap to store elements we've seen, trading space for time."
```

### Handle Follow-up Questions:
- "What if memory is limited?" → Discuss space-time trade-offs
- "What if the array is sorted?" → Mention binary search or two pointers
- "Can we do better?" → Explain why current solution is optimal

---

## 🔥 Last-Minute Checklist

**Before coding interviews:**

- [ ] **Big-O order:** O(1) < O(log n) < O(n) < O(n log n) < O(n²)
- [ ] **Common patterns:** Hash maps for O(1) lookup, two pointers for sorted arrays
- [ ] **Space-time trade-offs:** Can sacrifice space for better time complexity
- [ ] **Always analyze:** State both time and space complexity
- [ ] **Optimization mindset:** Start with brute force, then optimize

**Ready to crush those complexity questions! 🚀**