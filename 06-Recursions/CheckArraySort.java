import java.util.*;

public class CheckArraySort {

    // Recursive function to check if array is sorted in ascending order
    public static boolean checkArr(int arr[], int index) {
        // Base case: if we reach the second last element, stop
        if (index == arr.length - 1) {
            return true;
        }

        // If current element is greater than next, not sorted
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // Recursive check for next index
        return checkArr(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        // Initialize and take input in array
        int arr[] = new int[size];
        System.out.print("Enter " + size + " elements in array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Call recursive check function
        if (checkArr(arr,0)) {
            System.out.println("Array is sorted in ascending order.");
        } else {
            System.out.println("Array is NOT sorted.");
        }

        sc.close();
    }
}
