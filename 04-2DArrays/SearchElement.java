import java.util.*;

public class SearchElement {

    // Method to search for a key in a 2D matrix
    public static boolean Search(int matrix[][], int key) {
        int n = matrix.length;        // Number of rows
        int m = matrix[0].length;     // Number of columns

        // Traverse through the entire 2D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If key is found, print its position
                if (matrix[i][j] == key) {
                    System.out.println("Key found at: (" + i + ", " + j + ")");
                    return true;
                }
            }
        }

        // If key is not found after full traversal
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define a 3x3 matrix (2D array)
        int matrix[][] = new int[3][3];

        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();

        int n = matrix.length;        // Rows
        int m = matrix[0].length;     // Columns

        System.out.println("Matrix size: " + n + " rows and " + m + " columns");

        // Input: Reading values into the 2D array
        System.out.println("Enter 9 elements for the 3x3 matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output: Printing the 2D array
        System.out.println("Matrix you entered:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to next line after each row
        }

        // Call the search function to find the key
        Search(matrix, key);
    }
}
