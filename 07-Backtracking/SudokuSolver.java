public class SudokuSolver {

    // Main solver function using backtracking
    public static boolean sudoku(char[][] board) {

        // Traverse each cell in the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // If cell is empty
                if (board[row][col] == '.') {

                    // Try placing digits from '1' to '9'
                    for (char num = '1'; num <= '9'; num++) {

                        // Check if it's safe to place the number
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num; // Place the number

                            // Recursively solve the rest of the board
                            if (sudoku(board)) {
                                return true; // If solved, return true
                            }

                            board[row][col] = '.'; // Backtrack if not valid
                        }
                    }

                    // If no number can be placed, return false
                    return false;
                }
            }
        }

        // If no empty cell is found, board is solved
        return true;
    }

    // Check if it's safe to place num at board[row][col]
    public static boolean isSafe(char[][] board, int row, int col, char num) {

        // Check current row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Print the board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        char[][] board = {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        if (sudoku(board)) {
            System.out.println("Sudoku solved:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
