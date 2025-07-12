import java.util.*;

public class NearbyCarsOptimized {

    // Function to return the K closest cars to the origin (0, 0)
    public static List<int[]> getKClosestCars(int[][] cars, int k) {
        // PriorityQueue as MaxHeap.
        // Each element is an int array of 3 values: [distance, x, y]
        // Comparator b[0] - a[0] means: larger distance has higher priority (MaxHeap)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        // Loop through all the cars
        for (int[] car : cars) {
            int x = car[0];
            int y = car[1];

            // Calculate squared distance from origin to avoid using square root
            int distSq = x * x + y * y;

            // Offer a new int[] to the heap: [distance, x, y]
            maxHeap.offer(new int[]{distSq, x, y});

            // If the heap size exceeds k, remove the farthest car
            // This works because the farthest car is always at the top (MaxHeap)
            if (maxHeap.size() > k) {
                maxHeap.poll(); //after removal it automatically resizes
            }
        }

        // Prepare the final list of k closest cars
        List<int[]> result = new ArrayList<>();

        // Extract from heap and add only x and y to the result
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();  // top is an int[]: [distance, x, y]
            result.add(new int[]{top[1], top[2]});  // add only x and y to result
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] cars = {
            {1, 2},
            {3, 4},
            {2, -1},
            {5, 8},
            {0, 1}
        };
        int k = 3;

        // Get k closest cars to the origin
        List<int[]> nearest = getKClosestCars(cars, k);

        System.out.println("K nearest cars:");
        for (int[] car : nearest) {
            // Arrays.toString converts the array to readable string like [x, y]
            System.out.println(Arrays.toString(car));
        }
    }
}
