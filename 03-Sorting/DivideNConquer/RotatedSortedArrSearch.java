import java.util.*;

public class RotatedSortedArrSearch {

    // Recursive function to search key in rotated sorted array
    public static int Search(int arr[], int key, int si, int ei) {

        // ⚠️ Base case: element not found
        // Use si > ei to ensure all valid subarrays are checked, including when si == ei
        if (si > ei) {
            return -1;
        }

        // Calculate mid index safely
        int mid = si + (ei - si) / 2;

        // Case 1: key found directly at mid
        if (arr[mid] == key) {
            return mid;
        }

        // 💡 KEY IDEA: One half of the rotated array is always sorted.
        // We first identify which half is sorted, then check if the key lies within that half.

        // 🧭 Case 2: Left half is sorted (mid on Line 1)
        if (arr[si] <= arr[mid]) {
            // If key lies within the sorted left half
            if (key >= arr[si] && key <= arr[mid]) {
                return Search(arr, key, si, mid - 1);  // Search left half
            } else {
                return Search(arr, key, mid + 1, ei);  // Search right half
            }
        }

        // 🧭 Case 3: Right half is sorted (mid on Line 2)
        else {
            // If key lies within the sorted right half
            if (key >= arr[mid] && key <= arr[ei]) {
                return Search(arr, key, mid + 1, ei);  // Search right half
            } else {
                return Search(arr, key, si, mid - 1);  // Search left half
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.print("Enter rotated sorted array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        // Function call to search the key
        int result = Search(arr, key, 0, arr.length - 1);

        // Print result
        if (result != -1) {
            System.out.println("Key found at index: " + result);
        } else {
            System.out.println("Key not found.");
        }

        sc.close();
    }
}
