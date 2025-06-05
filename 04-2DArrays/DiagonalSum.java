public class DiagonalSum {

    // Method to calculate the sum of diagonals in a square matrix
    public static int diagonal(int matrix[][]) {
        int sum = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        // --------------------------
        // METHOD 1 - BRUTE FORCE (O(n^2))
        // --------------------------
        /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Primary diagonal
                if (i == j) {
                    sum += matrix[i][j];
                }
                // Secondary diagonal
                else if (i + j == n - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        */

        // --------------------------
        // METHOD 2 - OPTIMIZED (O(n))
        // --------------------------
        for (int i = 0; i < n; i++) {
            // Primary diagonal
            sum += matrix[i][i];

            // Secondary diagonal (avoid double-counting the center element)
            if (i != n - 1 - i) {   // i+j = n-1 => j = n-1-i 
                sum += matrix[i][n - 1 - i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // Defining a 4x4 matrix
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Calculating diagonal sum
        int result = diagonal(matrix);

        // Displaying the result
        System.out.println("The diagonal sum of the matrix: " + result);
    }
}
