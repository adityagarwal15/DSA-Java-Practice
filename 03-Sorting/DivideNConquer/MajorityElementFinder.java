// Optimal Solution (Moore’s Voting Algorithm)
// Time Complexity: O(n) — Single pass through the array
// Space Complexity: O(1) — Only two variables used

import java.util.*;

public class MajorityElementFinder {

    public static int majorityElement(int[] nums) {
        int count = 0;        // Counter to track "support" for current candidate
        int candidate = 0;    // Current candidate for majority element

        // Loop through all elements in the array
        for (int num : nums) {

            // If count drops to 0, assume the current element might be the new majority
            if (count == 0) {
                candidate = num;
            }

            // If current element matches the candidate, increase count (support)
            if (num == candidate) {
                count++;
            }
            // If different, reduce count (cancel out one support)
            else {
                count--;
            }
        }

        // At the end, candidate will be the majority element (guaranteed by problem)
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Input: Array elements
        int[] nums = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find and display the majority element
        int result = majorityElement(nums);
        System.out.println("Majority Element: " + result);

        sc.close();
    }
}
