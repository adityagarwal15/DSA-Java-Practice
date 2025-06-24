import java.util.*;

public class QuickSort {

    // Main QuickSort function
    public static void sort(int arr[], int si, int ei) {
        // Base case: when the subarray has 0 or 1 element
        if (si >= ei) {
            return;
        }

        // Step 1: Partition the array
        int pIndex = partition(arr, si, ei);

        // Step 2: Recursively sort the left part
        sort(arr, si, pIndex - 1);

        // Step 3: Recursively sort the right part
        sort(arr, pIndex + 1, ei);
    }

    // Partition function: places pivot at correct position and arranges elements
    public static int partition(int[] arr, int si, int ei) {        
        int pivot = arr[ei]; // Choosing last element as pivot
        int i = si - 1; // basically i=-1 //position boundary

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j] // put smaller values to the left
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot to its correct position (i+1)
        // finally put pivot in its correct position
        // swap(arr[i+1], arr[ei]);
        int temp = arr[i + 1];
        arr[i + 1] = arr[ei];
        arr[ei] = temp;

        return i + 1; // Return the index of the pivot
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.print("Enter elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr, 0, arr.length - 1); // Call QuickSort

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
