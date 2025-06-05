import java.util.*;

public class CountElement {

    // Method to count the occurrences of a key in a 2D array
    public static int count(int arr[][], int key) {
        int count = 0;
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == key) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[2][3];

        int n = arr.length;
        int m = arr[0].length;

        // Input key to count
        System.out.print("Enter key to count: ");
        int key = sc.nextInt();

        // Input matrix elements
        System.out.println("Enter 6 elements for the 2x3 array:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Print the matrix
        System.out.println("Array you entered:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Count and display result
        int result = count(arr, key);
        System.out.println("Number of " + key + "'s in the array: " + result);

        sc.close();
    }
}
