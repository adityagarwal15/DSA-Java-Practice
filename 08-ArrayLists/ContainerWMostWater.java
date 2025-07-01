import java.util.*;

public class ContainerWMostWater {

    // Function to calculate the maximum area of water that can be contained
    public static int calWater(ArrayList<Integer> heights) {
        int maxWater = 0; // Stores the maximum water area found so far

        // Loop through all possible pairs of lines
        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {
                // Height is determined by the shorter of the two lines
                int height = Math.min(heights.get(i), heights.get(j));
                // Width is the distance between the two lines
                int width = j - i;
                // Area = height * width
                int totalWater = height * width;
                // Update maxWater if this area is larger
                maxWater = Math.max(maxWater, totalWater);
            }
        }

        return maxWater; // Return the maximum area found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> heights = new ArrayList<>();

        // Take input for the number of elements
        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        // Take input values into the ArrayList
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            heights.add(sc.nextInt());
        }

        // Calculate the result and print it
        int result = calWater(heights);
        System.out.println("Area of container with most water: " + result);
    }
}
