import java.util.*;

public class SpiralMatrix {

    public static void printSpiral(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        System.out.println("Spiral Order:");

        while (startRow <= endRow && startCol <= endCol) {

            // Top row (left to right)
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // Right column (top to bottom)
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // Bottom row (right to left) — only if not same row
            if (startRow < endRow) {
                for (int j = endCol - 1; j >= startCol; j--) {
                    System.out.print(matrix[endRow][j] + " ");
                }

                // Alternative version using break (NOT preferred — just for reference)
                /*
                for (int j = endCol - 1; j >= startCol; j--) {
                    if (startRow == endRow) break;
                    System.out.print(matrix[endRow][j] + " ");
                }
                */
            }

            // Left column (bottom to top) — only if not same column
            if (startCol < endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }

                // Alternative version using break (NOT preferred — just for reference)
                /*
                for (int i = endRow - 1; i > startRow; i--) {
                    if (startCol == endCol) break;
                    System.out.print(matrix[i][startCol] + " ");
                }
                */
            }

            // Move towards inner layer
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix size
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        // Input matrix elements
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Print the spiral order
        printSpiral(matrix);
    }
}
