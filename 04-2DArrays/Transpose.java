import java.util.*;

public class Transpose {

    public static int[][] trans(int arr[][]) { // NEW DECLARATION 
        int n = arr.length;        // Number of rows in original matrix
        int m = arr[0].length;     // Number of columns in original matrix

        // Transpose will have m rows and n columns (OPPOSITE)
        int transpose[][] = new int[m][n];

        // Swap rows with columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transpose[j][i] = arr[i][j]; // row becomes column
            }
        }
        return transpose; //Return the transposed matrix
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter number of cols: ");
        int col = sc.nextInt();

        // Declare 2D matrix of size row x col
        int arr[][] = new int[row][col];

        // Input elements of the matrix from user
        System.out.println("Enter elements in array:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Print original matrix
        System.out.println("Array before transpose:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " "); // Add space between numbers
            }
            System.out.println(); // Move to next row
        }

        // Call transpose method and store result in new matrix
        int result[][] = trans(arr);

        // Print transposed matrix
        System.out.println("Array after transpose:");
        for (int i = 0; i < result.length; i++) {          // result.length = new number of rows
            for (int j = 0; j < result[0].length; j++) {   // result[0].length = new number of cols
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close(); //
    }
}
