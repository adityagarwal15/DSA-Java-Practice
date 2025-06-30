import java.util.*;

public class RatMaze {

    // Count total number of paths from (i,j) to (n-1,n-1)
    public static int countPaths(int[][] maze, int n, int i, int j) {
        // Base case: reached destination
        if (i == n - 1 && j == n - 1) {
            return 1;
        }

        // Boundary cases or cell is blocked
        if (i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0) {
            return 0;
        }

        // Mark current cell as visited
        maze[i][j] = 0;

        // Move in 4 directions
        int down = countPaths(maze, n, i + 1, j);
        int right = countPaths(maze, n, i, j + 1);
        int up = countPaths(maze, n, i - 1, j);
        int left = countPaths(maze, n, i, j - 1);

        // Backtrack → unmark cell as visited
        maze[i][j] = 1;

        // Total ways from this cell
        return down + right + up + left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of maze (N x N): ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];

        System.out.println("Enter maze values (1 for open, 0 for blocked): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            System.out.println("No path exists.");
        } else {
            int totalWays = countPaths(maze, n, 0, 0);
            System.out.println("Total ways from (0,0) to (" + (n - 1) + "," + (n - 1) + "): " + totalWays);
        }
    }
}
