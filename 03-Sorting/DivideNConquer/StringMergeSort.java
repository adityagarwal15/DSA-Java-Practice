import java.util.*;

public class StringMergeSort {

    // Merge Sort function to sort array of strings
    public static void mergeSort(String[] arr, int si, int ei) {
        // Base case: if only one element
        if (si >= ei) return;

        int mid = si + (ei - si) / 2;

        // Sort the left and right halves
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        // Merge sorted halves
        merge(arr, si, mid, ei);
    }

    // Function to merge two sorted parts of string array
    public static void merge(String[] arr, int si, int mid, int ei) {
        String[] temp = new String[ei - si + 1];

        int i = si;       // pointer for left half
        int j = mid + 1;  // pointer for right half
        int k = 0;        // pointer for temp array

        // Merge in lexicographical order
        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half (if any)
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half (if any)
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy sorted temp back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[si + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample input
        String[] arr = { "sun", "earth", "mars", "mercury" };

        System.out.println("Original array: " + Arrays.toString(arr));

        // Call merge sort
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        sc.close();
    }
}
