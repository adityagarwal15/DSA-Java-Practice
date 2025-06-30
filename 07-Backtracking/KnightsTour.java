import java.util.*;

public class KnightsTour {

    static int count = 0;

    // 8 possible moves a knight can make (L-shaped)
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    // Check if it's safe to move to (x, y)
    public static boolean isSafe(int[][] board, int x, int y) {
        int n = board.length;
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }

    // Recursive function to solve Knight’s Tour
    public static void knightTour(int[][] board, int x, int y, int move) {
        int n = board.length;

        // Base case: if knight has visited all cells
        if (move == n * n) {
            count++;
            printBoard(board, count);
            return;
        }

        // Try all 8 knight moves
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isSafe(board, nextX, nextY)) {
                board[nextX][nextY] = move; // place knight with move number
                knightTour(board, nextX, nextY, move + 1); // move ahead
                board[nextX][nextY] = -1; // backtrack
            }
        }
    }

    // Function to print the board
    public static void printBoard(int[][] board, int count) {
        System.out.println("Solution #" + count);
        System.out.println("---------- Chess Board ----------");

        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N (NxN chessboard): ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        // Initialize all cells as -1 (unvisited)
        for (int[] row : board) {
            Arrays.fill(row, -1);
        }

        // Start from top-left corner with move 0
        board[0][0] = 0;

        knightTour(board, 0, 0, 1);

        System.out.println("Total number of Knight's Tours: " + count);
    }
}
