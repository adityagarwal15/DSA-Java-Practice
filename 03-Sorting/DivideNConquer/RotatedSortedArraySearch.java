import java.util.*;

public class RotatedSortedArraySearch {

    // Function to search for a key in a rotated sorted array
    public static int search(int[] arr, int key) {
        int si = 0, ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            //  Case 1: Found key at mid
            if (arr[mid] == key) {
                return mid;
            }

            //  Case 2: Left half is sorted
            if (arr[si] <= arr[mid]) {
                // If key lies within the sorted left half
                if (key >= arr[si] && key <= arr[mid]) {
                    ei = mid - 1;  // Search left
                } else {
                    si = mid + 1;  // Search right
                }
            }

            //  Case 3: Right half is sorted
            else {
                // If key lies within the sorted right half
                if (key >= arr[mid] && key <= arr[ei]) {
                    si = mid + 1;  //  Search right
                } else {
                    ei = mid - 1;  // Search left
                }
            }

            //  After modifying si or ei, control goes back to the top of the loop,
            // and a new mid is calculated based on the updated search window.
        }

        return -1;  //  Key not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.print("Enter rotated sorted array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        int result = search(arr, key);
        if (result != -1) {
            System.out.println(" Key found at index: " + result);
        } else {
            System.out.println(" Key not found.");
        }

        sc.close();
    }
}
