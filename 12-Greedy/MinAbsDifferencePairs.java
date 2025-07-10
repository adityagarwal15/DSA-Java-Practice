import java.util.*;

public class MinAbsDifferencePairs {

    // Function to calculate the minimum sum of absolute differences of pairs
    public static int getMinAbsDifference(int[] A, int[] B) {
        int n = A.length;

        // Step 1: Sort both arrays in ascending order
        // This helps match smallest with smallest, second smallest with second smallest, etc.
        Arrays.sort(A);
        Arrays.sort(B);

        int totalDifference = 0;

        // Step 2: Pair elements at the same index and calculate absolute difference
        // This greedy strategy ensures minimum total difference
        System.out.println("Optimal pairs:");
        for (int i = 0; i < n; i++) {
            System.out.println("(" + A[i] + ", " + B[i] + ")");
            totalDifference += Math.abs(A[i] - B[i]);
        }

        // Step 3: Return the total of all absolute differences
        return totalDifference;
    }

    public static void main(String[] args) {
        // Input arrays
        int[] A = {1, 2, 3};
        int[] B = {2, 3, 4};

        // Call the function and print the result
        int result = getMinAbsDifference(A, B);
        System.out.println("Minimum total absolute difference = " + result);
    }
}
