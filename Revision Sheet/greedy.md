# 📘 Greedy Algorithm - Quick Placement Reference

**DSA Interview Prep | 4th Year | 15-20+ LPA Target**

---

## 🎯 Why Learn This?
**High-frequency topics:** Interval scheduling, Activity selection, Minimum coins  
**Companies:** Google, Microsoft, Amazon, Goldman Sachs, Flipkart

---

## 🧠 What is Greedy?
**Core Idea:** Make the **locally optimal choice** at each step, hoping it leads to a global optimum.

**When to use:** When the problem has **optimal substructure** and **greedy choice property**.

---

## 🔸 Common Greedy Patterns

### **1. Activity Selection / Meeting Rooms**
**Problem:** Schedule maximum non-overlapping activities  
**Strategy:** Sort by end time, pick earliest ending first

```java
class Interval {
    int start, end;
    Interval(int start, int end) { this.start = start; this.end = end; }
}

public int maxMeetings(Interval[] intervals) {
    // Sort by end time
    Arrays.sort(intervals, (a, b) -> a.end - b.end);
    
    int count = 1;
    int lastEnd = intervals[0].end;
    
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i].start >= lastEnd) {
            count++;
            lastEnd = intervals[i].end;
        }
    }
    return count;
}
```

### **2. Fractional Knapsack**
**Problem:** Maximize value with weight constraint  
**Strategy:** Sort by value/weight ratio, pick highest first

```java
class Item {
    int value, weight;
    Item(int value, int weight) { this.value = value; this.weight = weight; }
}

public double fractionalKnapsack(Item[] items, int capacity) {
    // Sort by value/weight ratio (descending)
    Arrays.sort(items, (a, b) -> Double.compare(
        (double)b.value/b.weight, (double)a.value/a.weight));
    
    double totalValue = 0;
    int currentWeight = 0;
    
    for (Item item : items) {
        if (currentWeight + item.weight <= capacity) {
            totalValue += item.value;
            currentWeight += item.weight;
        } else {
            int remainingWeight = capacity - currentWeight;
            totalValue += item.value * ((double)remainingWeight / item.weight);
            break;
        }
    }
    return totalValue;
}
```

### **3. Minimum Coins Change**
**Problem:** Make change using minimum coins  
**Strategy:** Use largest denomination first

```java
public int minCoins(int[] coins, int amount) {
    // Sort coins in descending order
    Arrays.sort(coins);
    reverseArray(coins);
    
    int count = 0;
    
    for (int coin : coins) {
        if (amount >= coin) {
            count += amount / coin;
            amount %= coin;
        }
    }
    
    return amount == 0 ? count : -1;  // -1 if not possible
}
```

---

## 🔹 Advanced Greedy Problems

### **4. Jump Game**
**Problem:** Can you reach the last index?  
**Strategy:** Track maximum reachable position

```java
public boolean canJump(int[] nums) {
    int maxReach = 0;
    
    for (int i = 0; i < nums.length; i++) {
        if (i > maxReach) return false;  // Can't reach this position
        maxReach = Math.max(maxReach, i + nums[i]);
    }
    
    return maxReach >= nums.length - 1;
}
```

### **5. Gas Station**
**Problem:** Find starting gas station to complete circular tour  
**Strategy:** Track current tank and total deficit

```java
public int canCompleteCircuit(int[] gas, int[] cost) {
    int totalTank = 0, currentTank = 0, start = 0;
    
    for (int i = 0; i < gas.length; i++) {
        totalTank += gas[i] - cost[i];
        currentTank += gas[i] - cost[i];
        
        if (currentTank < 0) {
            start = i + 1;
            currentTank = 0;
        }
    }
    
    return totalTank >= 0 ? start : -1;
}
```

---

## 🧩 Complete Example - Activity Selection

```java
import java.util.*;

class Activity {
    int start, end;
    Activity(int start, int end) { this.start = start; this.end = end; }
    
    @Override
    public String toString() { return "[" + start + "," + end + "]"; }
}

public class GreedyExample {
    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 3),
            new Activity(2, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9)
        };
        
        // Sort by end time
        Arrays.sort(activities, (a, b) -> a.end - b.end);
        
        List<Activity> selected = new ArrayList<>();
        selected.add(activities[0]);
        int lastEnd = activities[0].end;
        
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastEnd) {
                selected.add(activities[i]);
                lastEnd = activities[i].end;
            }
        }
        
        System.out.println("Selected activities: " + selected);
        // Output: [[1,3], [3,5], [5,7], [8,9]]
    }
}
```

---

## 🚀 Interview Cheat Sheet

| **Problem Type** | **Strategy** | **Sort By** |
|------------------|--------------|-------------|
| **Activity Selection** | Pick earliest ending | End time (asc) |
| **Fractional Knapsack** | Pick highest value/weight | Value/weight ratio (desc) |
| **Minimum Coins** | Use largest denomination | Coin value (desc) |
| **Interval Scheduling** | Minimize overlaps | End time (asc) |
| **Job Scheduling** | Maximize profit | Deadline or profit/penalty ratio |

---

## ⚠️ When Greedy Fails
```java
// Example: 0/1 Knapsack - Greedy doesn't work!
// Items: {value: 10, weight: 5}, {value: 20, weight: 4}, {value: 30, weight: 6}
// Capacity: 10
// Greedy by value/weight: picks items 2,1 = value 30 (wrong!)
// Optimal: picks items 1,2 = value 50 (correct!)
```

**Rule:** Greedy works when **local optimum = global optimum**

---

## 🎯 High-Frequency Problems
1. **Meeting Rooms** - Activity selection pattern
2. **Jump Game** - Track maximum reachable position
3. **Gas Station** - Circular array with deficit tracking
4. **Minimum Coins** - Denomination-based greedy
5. **Interval Merging** - Sort by start time

**Master these patterns and you'll handle most greedy questions in interviews!**