/*
Problem Statement:
Given an n x m grid, count the number of ways to go from cell (0,0) to (n-1,m-1) only moving right or down.
*/

import java.util.*;

public class GridWays {

    // Function to count the number of ways to reach (n-1, m-1) from (i, j)
    public static int Ways(int n, int m, int i, int j) {
        
        // Base case: when we reach the destination cell (bottom-right corner)
        // Even though we are already at the destination, we consider it a valid path → return 1
        if (i == n - 1 && j == m - 1) {
            return 1; // There's exactly 1 way if we're already standing on the target
        }

        // Boundary case: if we go outside the grid
        if (i >= n || j >= m) {
            return 0; // No valid way if outside the grid
        }

        // Recursive calls: Try to move in two directions
        // Move one cell down (i+1, j)
        int downWays = Ways(n, m, i + 1, j);

        // Move one cell right (i, j+1)
        int rightWays = Ways(n, m, i, j + 1);

        // Total ways from current cell = ways from down + ways from right
        return downWays + rightWays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions for the grid
        System.out.print("enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("enter number of columns: ");
        int m = sc.nextInt();

        // Start from the top-left cell (0,0)
        int totalWays = Ways(n, m, 0, 0);

        // Print the total number of valid paths
        System.out.println("Total ways from (0,0) to (" + (n - 1) + "," + (m - 1) + "): " + totalWays);
    }
}
