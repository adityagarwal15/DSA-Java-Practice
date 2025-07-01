import java.util.*;

public class TrappedWaterOpt {

    // Function to calculate trapped water using two-pointer approach
    public static int Water(int[] heights, int n) {
        // Initialize two pointers at both ends of the array
        int left = 0;
        int right = n - 1;

        // These variables will track the maximum height seen so far from the left and right
        int leftMax = 0;
        int rightMax = 0;

        // Variable to store total trapped water
        int trapped = 0;

        // Loop until the two pointers meet
        while (left <= right) {
            // If the height at left is smaller or equal to the height at right
            if (heights[left] <= heights[right]) {
                // If current height is greater than or equal to leftMax, update leftMax
                if (heights[left] >= leftMax) {
                    leftMax = heights[left];
                } else {
                    // Otherwise, water can be trapped above this bar
                    trapped += leftMax - heights[left];
                }
                // Move left pointer one step to the right
                left++;
            } else {
                // If current height is greater than or equal to rightMax, update rightMax
                if (heights[right] >= rightMax) {
                    rightMax = heights[right];
                } else {
                    // Otherwise, water can be trapped above this bar
                    trapped += rightMax - heights[right];
                }
                // Move right pointer one step to the left
                right--;
            }
        }

        // Return the total trapped water
        return trapped;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take the number of buildings as input
        System.out.print("Enter number of buildings: ");
        int n = sc.nextInt();

        // Create and fill the heights array
        int heights[] = new int[n];
        System.out.print("Enter heights for " + n + " buildings: ");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        // Call the function and print the result
        int result = Water(heights, n);
        System.out.println("Total trapped water: " + result);
    }
}
