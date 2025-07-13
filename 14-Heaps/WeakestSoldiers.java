import java.util.*;

public class WeakestSoldiers {

    public static int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> b[0] - a[0]
        );

       for (int i = 0; i < mat.length; i++) { // i = row // j = elem in each row
            int count = countSoldiers(mat[i]);  // Count 1s in the row
            maxHeap.offer(new int[]{count, i});

            // Keep only k weakest rows
            if (maxHeap.size() > k) {
                maxHeap.poll();  // Remove the strongest
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll()[1]; // only return rowIndex
        }
            return result;
    }

    // Helper to count soldiers in a row (number of 1s)
    //this binary search trick (reduces time from O(n*m) to O(n*log m))

    private static int countSoldiers(int[] row) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;  // move right
            } else {
                high = mid - 1; // move left
            }
        }
        return low; // index of first 0 = count of 1s
    }

public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };

        int k = 3;

        int[] result = kWeakestRows(matrix, k);
        System.out.println("K weakest rows: " + Arrays.toString(result));
    }
}