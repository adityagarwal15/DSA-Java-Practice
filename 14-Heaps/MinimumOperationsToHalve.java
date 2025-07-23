import java.util.*;

public class MinimumOperationsToHalve {

    public static int minOperations(double[] arr) {
        // Step 1: Create a MaxHeap using PriorityQueue with reverse order.
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        double totalSum = 0;

        // Step 2: Calculate total sum and add all elements to MaxHeap
        for (double num : arr) {
            totalSum += num;
            maxHeap.add(num);
        }

        double currentSum = totalSum;
        int operations = 0;

        // Step 3: Keep halving the largest element until the sum is <= half of the original sum
        while (currentSum > totalSum / 2) {
            double largest = maxHeap.poll();    // Get largest number
            double half = largest / 2;          // Halve it
            currentSum -= half;                 // Reduce current sum
            maxHeap.add(half);                  // Add halved value back to heap
            operations++;                       // Count the operation
        }

        return operations;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5, 8, 19};

        int result = minOperations(arr);
        System.out.println("Minimum operations: " + result);  // Expected output: 3
    }
}
