# 📘 Two Pointers & Sliding Window - Quick Placement Reference

**DSA Interview Prep | 4th Year | 15-20+ LPA Target**

---

## 🎯 Why Learn This?
**High-frequency topics:** Array/String problems, Subarray optimization, O(n) solutions  
**Companies:** Google, Microsoft, Amazon, Meta, Netflix, Uber

**Key Advantage:** Converts O(n²) brute force to O(n) optimal solutions

---

## 🧠 Two Techniques, One Goal

### **Two Pointers** - Navigate from opposite ends or same direction
### **Sliding Window** - Dynamic subarray/substring with conditions

---

## 🔸 Two Pointers Patterns

### **1. Opposite Direction** ⭐ **Most Common**
**Use case:** Sorted array, find pairs, palindrome check

```java
// Two Sum in Sorted Array
public int[] twoSum(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    
    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
            return new int[]{left, right};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return new int[]{-1, -1};
}
```

### **2. Same Direction** 
**Use case:** Remove duplicates, fast-slow pointer

```java
// Remove Duplicates from Sorted Array
public int removeDuplicates(int[] nums) {
    int slow = 0;
    
    for (int fast = 1; fast < nums.length; fast++) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        }
    }
    return slow + 1;  // Length of unique elements
}
```

### **3. Fast-Slow Pointer**
**Use case:** Cycle detection, find middle element

```java
// Find Middle of Linked List
public ListNode findMiddle(ListNode head) {
    ListNode slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

---

## 🔹 Sliding Window Patterns

### **1. Fixed Size Window**
**Use case:** Maximum/minimum in subarrays of size k

```java
// Maximum Sum of Subarray of Size K
public int maxSumSubarray(int[] nums, int k) {
    int windowSum = 0, maxSum = 0;
    
    // Calculate sum of first window
    for (int i = 0; i < k; i++) {
        windowSum += nums[i];
    }
    maxSum = windowSum;
    
    // Slide the window
    for (int i = k; i < nums.length; i++) {
        windowSum = windowSum - nums[i - k] + nums[i];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
```

### **2. Variable Size Window** ⭐ **Interview Favorite**
**Use case:** Substring with conditions, longest/shortest subarray

```java
// Longest Substring Without Repeating Characters
public int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0, maxLen = 0;
    
    for (int right = 0; right < s.length(); right++) {
        // Shrink window until no duplicates
        while (window.contains(s.charAt(right))) {
            window.remove(s.charAt(left));
            left++;
        }
        
        window.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

### **3. Subarray with Target Sum**
**Use case:** Positive numbers, find subarray with exact sum

```java
// Subarray with Given Sum
public int[] subarraySum(int[] nums, int target) {
    int left = 0, currentSum = 0;
    
    for (int right = 0; right < nums.length; right++) {
        currentSum += nums[right];
        
        // Shrink window if sum exceeds target
        while (currentSum > target && left <= right) {
            currentSum -= nums[left];
            left++;
        }
        
        if (currentSum == target) {
            return new int[]{left, right};
        }
    }
    return new int[]{-1, -1};
}
```

---

## 🧩 Complete Example - Longest Substring with At Most K Distinct

```java
import java.util.*;

public class SlidingWindowExample {
    // Longest Substring with At Most K Distinct Characters
    public static int longestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Expand window
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            
            // Shrink window if more than k distinct characters
            while (window.size() > k) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println("Longest substring: " + longestSubstringKDistinct(s, k));
        // Output: 3 (substring "ece")
    }
}
```

---

## 🚀 Pattern Recognition Guide

### **When to Use Two Pointers:**
| **Problem Clue** | **Pattern** | **Example** |
|------------------|-------------|-------------|
| **Sorted array + target** | Opposite direction | Two Sum, 3Sum |
| **Remove/modify in-place** | Same direction | Remove duplicates |
| **Find middle/cycle** | Fast-slow | Linked list problems |
| **Palindrome check** | Opposite direction | Valid palindrome |

### **When to Use Sliding Window:**
| **Problem Clue** | **Pattern** | **Example** |
|------------------|-------------|-------------|
| **"Subarray/substring of size k"** | Fixed window | Max sum subarray |
| **"Longest/shortest subarray with..."** | Variable window | Longest substring |
| **"Contains all/at most k..."** | Variable window | Min window substring |
| **"Subarray with target sum"** | Variable window | Subarray sum |

---

## 🎯 Essential Templates

### **Two Pointers (Opposite)**
```java
int left = 0, right = nums.length - 1;
while (left < right) {
    if (condition_met) {
        // Process result
        left++; right--;
    } else if (need_larger) {
        left++;
    } else {
        right--;
    }
}
```

### **Sliding Window (Variable)**
```java
int left = 0, result = 0;
for (int right = 0; right < nums.length; right++) {
    // Add nums[right] to window
    
    while (window_invalid) {
        // Remove nums[left] from window
        left++;
    }
    
    // Update result with current window
    result = Math.max(result, right - left + 1);
}
```

---

## ⚠️ Common Mistakes
1. **Boundary conditions** - Always check `left <= right`
2. **Window state** - Update data structures correctly when shrinking
3. **Edge cases** - Empty arrays, single elements
4. **Integer overflow** - Use `long` for large sums

---

## 🎯 High-Frequency Problems
1. **Two Sum** - Two pointers on sorted array
2. **Longest Substring Without Repeating Characters** - Variable sliding window
3. **Minimum Window Substring** - Variable sliding window with HashMap
4. **3Sum** - Two pointers with outer loop
5. **Subarray Sum Equals K** - Sliding window with prefix sum
6. **Container With Most Water** - Two pointers opposite direction

**Master these patterns and you'll solve 80% of array/string problems optimally!**