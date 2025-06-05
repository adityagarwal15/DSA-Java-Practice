// Print out the sum of the numbers in the second row of the “nums” array. 
// Example : 
// Input - int[][] nums = { {1,4,9},{11,4,3},{2,2,3} }; 
// Output - 18

import java.util.*;

public class SumSecondRow {

    // Method to calculate the sum of the second row
    public static int SumSecond(int nums[][]) {
        int sum = 0;

        // Check if the second row exists
        if (nums.length >= 2) {
            for (int j = 0; j < nums[1].length; j++) {
                sum += nums[1][j];
            }
        } else {
            System.out.println("Matrix doesn't have a second row.");
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nums[][] = new int[3][3];
        int n = nums.length;
        int m = nums[0].length;

        // Input elements in an array
        System.out.println("Enter elements in a 3x3 array:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        // Output entered elements
        System.out.println("Matrix you entered:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

        // Call the method to print sum of 2nd row
        int result = SumSecond(nums);
        System.out.println("Sum of the second row is: " + result);

        sc.close();
    }
}
