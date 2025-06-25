import java.util.*;

public class MajorityElementFinder {

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            // if current element == candidate, increase count
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // No need to verify because problem guarantees majority element exists
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find majority element
        int result = majorityElement(nums);
        System.out.println("Majority Element: " + result);

        sc.close();
    }
}
