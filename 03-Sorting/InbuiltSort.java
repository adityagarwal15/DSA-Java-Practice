import java.util.*;

public class InbuiltSort {

    // Method to print the elements of the array
    public static void printArr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        // Note: For using Collections.reverseOrder(), we must use the wrapper class Integer instead of int
        Integer arr[] = {5, 2, 8, 6, 1, 3, 9};

        /*
         * Arrays.sort(arr)
         * ---------------------------------------------
         * ✅ METHOD 1 - Sorts the entire array in ASCENDING order by default.
         * 🔸 Works in-place: directly modifies the original array.
         * 🔸 Returns void — so you can't assign its result to a variable.
         */
        // Arrays.sort(arr);  // Ascending order

        // ❌ This is invalid because Arrays.sort() returns void:
        // System.out.println(Arrays.sort(arr));  

        // ✅ Correct way to print sorted array:
        // System.out.println(Arrays.toString(arr));  

        /*
         * ✅ METHOD 2 - Sort a specific range (from index `fromIndex` to `toIndex - 1`)
         * 🔸 Example: Sort elements from index 0 to 2 (i.e., indices 0, 1, 2) it is      *     non-inclusive
         */
        // Arrays.sort(arr, 0, 3);  // Sorts only first 3 elements in ascending order

        /*
         * ✅ METHOD 3 - Sort in DESCENDING order
         * 🔸 Requires using Integer[] instead of int[] because Collections.reverseOrder() needs objects.
         */
        Arrays.sort(arr, Collections.reverseOrder());

        /*
         * ✅ METHOD 4 - Sort a specific range in DESCENDING order
         * 🔸 Sorts from index 0 to 2 (not inclusive of 3)
         */
        Arrays.sort(arr, 0, 3, Collections.reverseOrder());

        /*
         * Print the final sorted array using custom method
         */
        printArr(arr);  // Output depends on which sort method is active
    }
}
