package StuckArray;
import java.util.*;

public class SmallestNum {

    public static int getSmallest(int arr[]) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    public static int getSmallestIndex(int arr[], int smallest) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == smallest) {
                return i;
            }
        }
        return -1; // Shouldn't happen if smallest exists in array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter the length of the array
        System.out.print("Enter the length of array: ");
        int len = sc.nextInt();

        // Validate length
        if (len <= 0) {
            System.out.println("Invalid array length. Length must be greater than 0.");
            sc.close();
            return; // exit early
        }

        // Initialize and take input in array
        int arr[] = new int[len];
        System.out.println("Enter elements in the array:");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        // Get smallest value
        int smallest = getSmallest(arr);
        int index = getSmallestIndex(arr, smallest);

        System.out.println("Smallest number is: " + smallest);
        System.out.println("It is found at index: " + index);

        sc.close();
    }
}
