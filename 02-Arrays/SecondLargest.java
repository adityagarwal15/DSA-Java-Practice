public class SecondLargest {
    public static int secondLargest(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax && nums[i] < max) {
                secondMax = nums[i];
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            return -1; // No second largest found
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 8, 6};
        System.out.println("Second largest: " + secondLargest(arr)); // Output: 10
    }
}
