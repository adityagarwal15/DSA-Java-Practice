import java.util.*;

public class SmallestElement {

    // Method to find the smallest element in a 2D matrix
    public static int Smallest(int matrix[][]) {
        int smallest = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (smallest > matrix[i][j]) {
                    smallest = matrix[i][j];
                }
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        int n = matrix.length;
        int m = matrix[0].length;

        // Input
        System.out.println("Enter 9 elements for the 3x3 matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output matrix in clean format
        System.out.println("Matrix you entered:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Find and print smallest element
        System.out.println("Smallest element is: " + Smallest(matrix));
    }
}
