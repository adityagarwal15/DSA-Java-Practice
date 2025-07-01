import java.util.*;

public class ContainerWMostWater {

    public static int calWater(ArrayList<Integer> heights) {
        int maxWater = 0;

        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {
                int height = Math.min(heights.get(i), heights.get(j));
                int width = j - i;
                int totalWater = height * width;
                maxWater = Math.max(maxWater, totalWater);
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
