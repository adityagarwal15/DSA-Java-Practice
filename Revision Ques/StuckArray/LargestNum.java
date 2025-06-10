package StuckArray;
import java.util.*;

public class LargestNum {

    public static int getLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int getLargestIndex(int arr[], int largest) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == largest) {
                return i;
            }
        }
        return -1; // shouldn't happen if largest exists in the array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Enter the length of the array
        System.out.print("Enter the length of the array: ");
        int len = sc.nextInt();

        // Handle invalid length
        if (len <= 0) {
            System.out.println("Invalid array length. Must be greater than 0.");
            sc.close();
            return;
        }

        // Initialize array and take input
        int[] arr = new int[len];
        System.out.println("Enter elements in the array:");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = getLargest(arr);
        int index = getLargestIndex(arr, largest);

        System.out.println("The largest number in the array is: " + largest);
        System.out.println("It is found at index: " + index);

        sc.close();
    }
}
