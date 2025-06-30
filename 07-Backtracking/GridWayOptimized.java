import java.util.*;

public class GridWayOptimized {

    // This function computes nCr (n choose r) efficiently without calculating full factorials.
    // It avoids overflow by simplifying terms step by step.
    // For example: C(5, 2) = (5 × 4) / (2 × 1) = 10
    public static long nCr(int n, int r) {
        long res = 1;

        // C(n, r) is same as C(n, n - r); we pick the smaller of r or n - r to reduce the number of iterations
        r = Math.min(r, n - r);

        // Multiplicative formula: C(n, r) = (n - r + 1)/1 × (n - r + 2)/2 × ... × n/r
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
        }

        return res;
    }

    // This function calculates the number of unique paths from (0,0) to (n-1,m-1) in an n×m grid
    public static long gridWays(int n, int m) {
        // Explanation of formula:
        // To reach from (0,0) to (n-1,m-1), you must make (n-1) down moves and (m-1) right moves.
        // So total moves = (n - 1) + (m - 1) = n + m - 2
        // Out of these total moves, choose positions for either down or right moves.
        // So the answer = C(n + m - 2, n - 1) or C(n + m - 2, m - 1)
        return nCr(n + m - 2, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 4; // Number of rows in the grid
        int m = 3; // Number of columns in the grid

        // Calculate the total number of unique paths using combinatorics
        long totalWays = gridWays(n, m);

        // Output the result
        System.out.println("Total ways (efficient combinatorics): " + totalWays);
    }
}
