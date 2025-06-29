import java.util.*;

public class Nqueen {

    // Function to check if it's safe to place a queen at board[row][col]
    public static boolean isSafe(char board[][], int row, int col) {
        // Check vertically upward (same column)
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false; // Queen already exists in the same column
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false; // Queen already exists in the left diagonal
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false; // Queen already exists in the right diagonal
            }
        }

        // If no queen is threatening this cell, it's safe
        return true;
    }

    // Recursive function to try placing queens row by row
    public static void nQueens(char board[][], int row) {
        // Base case: if all rows are filled with queens
        if (row == board.length) {
            printBoard(board); // Print the current valid board configuration
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board[0].length; col++) {
            // Check if it's safe to place a queen at board[row][col]
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place queen
                nQueens(board, row + 1); // Recur to place queen in next row
                board[row][col] = 'x';   // Backtrack: remove queen and try next column
            }
        }
    }

    // Function to print the current state of the chess board
    public static void printBoard(char board[][]) {
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
        int n = sc.nextInt(); // Size of the chessboard

        char[][] board = new char[n][n]; // Create an NxN board

        // Initialize the board with 'x' representing empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        // Start placing queens from the 0th row
        nQueens(board, 0);
    }
}
