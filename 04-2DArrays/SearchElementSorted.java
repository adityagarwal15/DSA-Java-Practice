import java.util.*;

public class SearchElementSorted {

    // Staircase Search: Efficient for sorted row-wise & column-wise matrices
    public static boolean staircase(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1; // Start from top-right corner

        while (row < n && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Key found at: (" + row + ", " + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];

        int n = matrix.length;
        int m = matrix[0].length;

        // Enter key to search
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        // Input matrix elements
        System.out.println("Enter elements for the 3x3 sorted matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Print the entered matrix
        System.out.println("Matrix you entered:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to next line after each row
        }

        // Perform the search
        staircase(matrix, key);

        sc.close(); // Close scanner to avoid resource leak
    }
}
