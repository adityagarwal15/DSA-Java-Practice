import java.util.*;

public class SearchElementSorted {

    // Method to search for a key in a sorted 2D matrix using Staircase Search
    public static boolean staircase(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;

        // ---------------------------
        // METHOD 1 - Top-Right Corner (O(n + m))
        // ---------------------------
        // int row = 0;
        // int col = m - 1;
        //
        // while (row < n && col >= 0) {
        //     if (matrix[row][col] == key) {
        //         System.out.println("Key found at: (" + row + ", " + col + ")");
        //         return true;
        //     } else if (key < matrix[row][col]) {
        //         col--; // Move left
        //     } else {
        //         row++; // Move down
        //     }
        // }

        // ---------------------------
        // METHOD 2 - Bottom-Left Corner (O(n + m))
        // ---------------------------
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < m) {
            if (matrix[row][col] == key) {
                System.out.println("Key found at: (" + row + ", " + col + ")");
                return true;
            } else if (matrix[row][col] > key) {
                row--; // Move up
            } else {
                col++; // Move right
            }
        }

        // If not found
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];

        int n = matrix.length;
        int m = matrix[0].length;

        // Input the key to search
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        // Input matrix elements
        System.out.println("Enter elements for the 3x3 sorted matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Display the matrix
        System.out.println("Matrix you entered:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Search for the key
        staircase(matrix, key);

        sc.close(); // Good practice to close Scanner
    }
}
