# 📘 HashMap & HashSet - Quick Placement Reference

**DSA Interview Prep | 4th Year | 15-20+ LPA Target**

---

## 🎯 Why Learn This?
**High-frequency topics:** O(1) lookups, Frequency counting, Duplicate detection  
**Companies:** Google, Microsoft, Amazon, Meta, Netflix, Goldman Sachs

**Key Advantage:** Converts O(n²) nested loops to O(n) single pass solutions

---

## 🧠 Core Concepts

### **HashMap** - Key-Value pairs, O(1) average operations
### **HashSet** - Unique elements only, O(1) average operations

**When to use:** Need fast lookups, counting, or duplicate checking

---

## 🔸 HashMap Patterns

### **1. Frequency Counting** ⭐ **Most Common**
**Use case:** Count occurrences, find duplicates, anagrams

```java
// Character Frequency in String
public Map<Character, Integer> getFrequency(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    
    for (char c : s.toCharArray()) {
        freq.put(c, freq.getOrDefault(c, 0) + 1);
    }
    return freq;
}

// Find First Non-Repeating Character
public char firstNonRepeating(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    
    // Count frequencies
    for (char c : s.toCharArray()) {
        freq.put(c, freq.getOrDefault(c, 0) + 1);
    }
    
    // Find first non-repeating
    for (char c : s.toCharArray()) {
        if (freq.get(c) == 1) {
            return c;
        }
    }
    return '\0';  // Not found
}
```

### **2. Two Sum Pattern**
**Use case:** Find pairs, complement search

```java
// Two Sum - O(n) Solution
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        
        map.put(nums[i], i);
    }
    return new int[]{-1, -1};
}
```

### **3. Subarray Sum Pattern**
**Use case:** Prefix sum + HashMap for range queries

```java
// Subarray Sum Equals K
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> prefixSumCount = new HashMap<>();
    prefixSumCount.put(0, 1);  // Empty subarray
    
    int count = 0, prefixSum = 0;
    
    for (int num : nums) {
        prefixSum += num;
        
        // Check if (prefixSum - k) exists
        if (prefixSumCount.containsKey(prefixSum - k)) {
            count += prefixSumCount.get(prefixSum - k);
        }
        
        prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
}
```

### **4. Group Anagrams**
**Use case:** Grouping by transformation/signature

```java
// Group Anagrams
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> groups = new HashMap<>();
    
    for (String str : strs) {
        // Create signature by sorting characters
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String signature = String.valueOf(chars);
        
        groups.computeIfAbsent(signature, k -> new ArrayList<>()).add(str);
    }
    
    return new ArrayList<>(groups.values());
}
```

---

## 🔹 HashSet Patterns

### **1. Duplicate Detection**
**Use case:** Find duplicates, unique elements

```java
// Contains Duplicate
public boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    
    for (int num : nums) {
        if (seen.contains(num)) {
            return true;
        }
        seen.add(num);
    }
    return false;
}

// Longest Consecutive Sequence
public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
        numSet.add(num);
    }
    
    int maxLength = 0;
    
    for (int num : numSet) {
        // Start of sequence (no num-1 exists)
        if (!numSet.contains(num - 1)) {
            int currentNum = num;
            int currentLength = 1;
            
            // Extend sequence
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
    }
    return maxLength;
}
```

### **2. Set Operations**
**Use case:** Intersection, union, difference

```java
// Intersection of Two Arrays
public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> result = new HashSet<>();
    
    for (int num : nums1) {
        set1.add(num);
    }
    
    for (int num : nums2) {
        if (set1.contains(num)) {
            result.add(num);
        }
    }
    
    return result.stream().mapToInt(i -> i).toArray();
}
```

---

## 🧩 Complete Example - Valid Anagram

```java
import java.util.*;

public class HashMapExample {
    // Valid Anagram - Multiple approaches
    
    // Approach 1: HashMap frequency count
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> freq = new HashMap<>();
        
        // Count characters in s
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Subtract characters in t
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) - 1);
            if (freq.get(c) == 0) {
                freq.remove(c);
            }
        }
        
        return freq.isEmpty();
    }
    
    // Approach 2: Array frequency (for lowercase letters only)
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] freq = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int count : freq) {
            if (count != 0) return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println("HashMap approach: " + isAnagram1(s, t));
        System.out.println("Array approach: " + isAnagram2(s, t));
        // Both output: true
    }
}
```

---

## 🚀 Pattern Recognition Guide

### **When to Use HashMap:**
| **Problem Clue** | **Pattern** | **Example** |
|------------------|-------------|-------------|
| **"Count frequency of..."** | Frequency counting | Character/word frequency |
| **"Find pairs that sum to..."** | Two sum pattern | Two sum, 3sum |
| **"Subarray sum equals..."** | Prefix sum + HashMap | Subarray sum problems |
| **"Group by property..."** | Group anagrams | Group by signature |
| **"Index mapping needed"** | Value-to-index map | Two sum with indices |

### **When to Use HashSet:**
| **Problem Clue** | **Pattern** | **Example** |
|------------------|-------------|-------------|
| **"Contains duplicate"** | Duplicate detection | Contains duplicate |
| **"Unique elements only"** | Deduplication | Remove duplicates |
| **"Intersection/Union"** | Set operations | Array intersection |
| **"Consecutive sequence"** | O(1) lookups | Longest consecutive |
| **"Visited/seen check"** | Fast membership | Graph traversal |

---

## 🎯 Essential Templates

### **HashMap Frequency Template**
```java
Map<KeyType, Integer> freq = new HashMap<>();
for (KeyType key : collection) {
    freq.put(key, freq.getOrDefault(key, 0) + 1);
}
```

### **HashSet Duplicate Check Template**
```java
Set<Type> seen = new HashSet<>();
for (Type item : collection) {
    if (seen.contains(item)) {
        // Handle duplicate
    }
    seen.add(item);
}
```

### **Two Sum Template**
```java
Map<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement)) {
        // Found pair
    }
    map.put(nums[i], i);
}
```

---

## ⚠️ Performance Notes

### **Time Complexity:**
- **Average case:** O(1) for get, put, contains
- **Worst case:** O(n) when many hash collisions

### **Space Optimization:**
```java
// For lowercase letters only - use array instead of HashMap
int[] freq = new int[26];  // More efficient than HashMap<Character, Integer>
```

### **Common Mistakes:**
1. **Null checks** - Always check for null keys/values
2. **Concurrent modification** - Don't modify while iterating
3. **Hash collisions** - Rare but can affect performance

---

## 🎯 High-Frequency Problems
1. **Two Sum** - HashMap for O(n) solution
2. **Valid Anagram** - Character frequency counting
3. **Group Anagrams** - HashMap with signature keys
4. **Subarray Sum Equals K** - Prefix sum + HashMap
5. **Longest Consecutive Sequence** - HashSet for O(1) lookups
6. **Contains Duplicate** - HashSet for duplicate detection

**Master these patterns and you'll handle most hashing problems in interviews!**