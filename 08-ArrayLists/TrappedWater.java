import java.util.*;

public class TrappedWater {

    public static int Water(ArrayList<Integer> heights, int n) {
        // Initialize two pointers
        int left = 0;
        int right = n - 1;

        // Track max height from left and right
        int leftmax = 0;
        int rightmax = 0;

        // Store total trapped water
        int trappedwater = 0;

        // Loop until both pointers meet
        while (left <= right) {
            if (heights.get(left) <= heights.get(right)) {
                // If current left height >= leftmax, update leftmax
                if (heights.get(left) >= leftmax) {
                    leftmax = heights.get(left);
                } else {
                    // Otherwise, water can be trapped
                    trappedwater += leftmax - heights.get(left);
                }
                left++; // move left pointer
            } else {
                // If current right height >= rightmax, update rightmax
                if (heights.get(right) >= rightmax) {
                    rightmax = heights.get(right);
                } else {
                    // Otherwise, water can be trapped
                    trappedwater += rightmax - heights.get(right);
                }
                right--; // move right pointer
            }
        }

        return trappedwater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of buildings: ");
        int n = sc.nextInt();

        ArrayList<Integer> heights = new ArrayList<>();
        System.out.print("Enter heights: ");
        for (int i = 0; i < n; i++) {
            heights.add(sc.nextInt());
        }

        int result = Water(heights, n);
        System.out.println("Trapped water is: " + result);
    }
}
