import java.util.*;

public class InversionCount {

    static int inversionCount = 0; // Global variable to store inversion count

    // Recursive function to divide and sort
    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) return;

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    // Merge two sorted halves and count inversions
    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];

        int i = si;       // Pointer for left half
        int j = mid + 1;  // Pointer for right half
        int k = 0;        // Pointer for temp array

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                
                /*
                 🔍 How merge sort helps:
                 Merge Sort divides the array into two halves, sorts them recursively,
                 and merges the two sorted halves. While merging:
                 
                 - Both halves are already sorted.
                 - If arr[i] > arr[j] and i < j, then arr[i] is out of place.
                 - So are all elements from i to mid (since the left half is sorted).
                 
                 Hence, all (mid - i + 1) elements in the left half form inversions
                 with arr[j], and we count them in one step.
                */
                inversionCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy sorted elements back into original array
        for (i = si, k = 0; i <= ei; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, size - 1);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\nInversion Count = " + inversionCount);

        sc.close();
    }
}
