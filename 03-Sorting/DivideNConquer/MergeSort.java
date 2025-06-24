import java.util.*;

public class MergeSort {

    // Recursive function to divide the array and sort each half
    public static void mergeSort(int arr[], int si, int ei) {
        // Base case: when only one element or invalid range
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2; // Calculate mid index safely

        // Recursively sort the left half
        mergeSort(arr, si, mid); // goes back find new mid for every new subarray until becomes single elem

        // Recursively sort the right half
        mergeSort(arr, mid + 1, ei);

        // Merge both sorted halves
        merge(arr, si, mid, ei);
    }

    // Function to merge two sorted halves [si...mid] and [mid+1...ei]
    public static void merge(int arr[], int si, int mid, int ei) {
        // Create temporary array to store merged result
        int temp[] = new int[ei - si + 1];

        int i = si;      // Pointer for left half
        int j = mid + 1; // Pointer for right half
        int k = 0;       // Pointer for temp array

        // Merge elements in sorted order
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half (if any)
        // Left  = [2, 6, 8]  for cases like these
        // Right = [3, 7]

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half (if any)
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp array back to original array in correct position
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of the array: ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        // Input array elements
        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Call merge sort
        mergeSort(arr, 0, arr.length - 1);

        // Output the sorted array
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
