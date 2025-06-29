import java.util.*;

public class NqueenOneSol {

    // Flag to track if one solution has been found
    static boolean found = false;

    // Function to check if it's safe to place a queen at board[row][col]
    public static boolean isSafe(char board[][], int row, int col) {
        // Check vertically upward (same column)
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; // Safe to place queen
    }

    // Recursive function to try placing queens row by row
    public static boolean nQueens(char board[][], int row) {
        if (row == board.length) {
            printBoard(board); // Print the first valid board configuration
            found = true; // Mark that we found a solution
            return true;  // Exit all recursion
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place queen
                if (nQueens(board, row + 1)) {
                    return true; // Stop if solution found
                }
                board[row][col] = 'x'; // Backtrack
            }
        }

        return false; // No valid position in this row
    }

    // Print the board
    public static void printBoard(char board[][]) {
        System.out.println("One possible solution:");
        System.out.println("---------- Chess Board ----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N (NxN chessboard): ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        // Initialize the board with 'x'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], 'x');
        }

        // Start solving
        boolean solved = nQueens(board, 0);

        if (!solved) {
            System.out.println("No solution exists for N = " + n);
        }
    }
}
