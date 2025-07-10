import java.util.*;

public class MinAbsDifferencePairs {

    public static int getMinAbsDifference(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A); // Sort both arrays
        Arrays.sort(B);

        int totalDifference = 0;

        System.out.println("Optimal pairs:");
        for (int i = 0; i < n; i++) {
            System.out.println("(" + A[i] + ", " + B[i] + ")");
            totalDifference += Math.abs(A[i] - B[i]);
        }

        return totalDifference;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 3, 4};

        int result = getMinAbsDifference(A, B);
        System.out.println("Minimum total absolute difference = " + result);
    }
}
