// Question:
// You are given an integer array `nums` and an integer `k`. 
// You can increment any element in the array by 1 any number of times, up to a total of `k` increments across all elements.
// Return the maximum possible frequency of an element after performing at most `k` increment operations.
// Example:
// Input: nums = [1,2,4], k = 5
// Output: 3
// Explanation: Increment 1 two times and 2 three times to make all elements equal to 4. The frequency of 4 is 3.

import java.util.*;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long total = 0;  // long to prevent overflow
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            while ((long) nums[right] * (right - left + 1) - total > k) {
                total -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 2, 4};
        int k = 5;

        int maxFreq = sol.maxFrequency(nums, k);
        System.out.println("Maximum Frequency: " + maxFreq);
    }
}
