import java.util.*;

public class SlidingWindowMax {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];  // Output array
        Deque<Integer> deque = new LinkedList<>();  // Stores indices only

        for (int i = 0; i < n; i++) {
            // Step 1: Remove out of bound indices (left side of window)
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();  // remove from front
            }

            // Step 2: Remove smaller elements from back(no point of storing smaller elem than curr index but only if it last)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();  // remove from back
            }

            // Step 3: Add current index to the deque
            deque.offerLast(i);

            // Step 4: Record result if window is formed
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];  // front holds max
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Sliding window max: " + Arrays.toString(result));
    }
}
