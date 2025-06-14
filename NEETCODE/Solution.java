import java.util.*;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int total = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            while (nums[right] * (right - left + 1) - total > k) {
                total -= nums[left];
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}

public static void main(String[])
