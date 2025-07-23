import java.util.*;

public class ContainerWMostWaterOpt {

    // Optimized function using two-pointer approach
    public static int calWater(ArrayList<Integer> heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.size() - 1;

        // Move two pointers toward each other
        while (left < right) {
            // Height is the minimum of the two lines
            int height = Math.min(heights.get(left), heights.get(right));
            int width = right - left;
            int area = height * width;
            maxWater = Math.max(maxWater, area);

            // Move the pointer at the shorter line(means move the shorter line)
            if (heights.get(left) < heights.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> heights = new ArrayList<>();

        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            heights.add(sc.nextInt());
        }

        int result = calWater(heights);
        System.out.println("Area of container with most water: " + result);
    }
}
