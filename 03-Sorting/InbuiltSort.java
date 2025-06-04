import java.util.*;

public class InbuiltSort {

    // Method to print the elements of the array
    public static void printArr(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 2, 8, 6, 1, 3, 9};

        // Arrays.sort(arr) sorts the array IN-PLACE.
        // This means it modifies the original array directly — it doesn't return a new sorted array.
        // It also RETURNS VOID — so you can't do something like arr = Arrays.sort(arr), that will cause an error.
        Arrays.sort(arr);  

        // If you try to print Arrays.sort(arr), it won't work because it returns void.
        // System.out.println(Arrays.sort(arr));  // ❌ This is invalid.

        // You can print the sorted array like this:
        // System.out.println(Arrays.toString(arr));  // ✅ Using built-in method

        // Or using a custom method like this:
        printArr(arr);  // ✅ Prints: 1 2 3 5 6 8 9
    }
}
