public class HeapSortMaxHeap {

    // Main function to sort array using MaxHeap
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build MaxHeap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap max element (at root) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Restore heap property in reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify subtree rooted at index i (assumes subtrees are already heaps)
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;         // Initialize largest as root
        int left = 2 * i + 1;    // left child
        int right = 2 * i + 2;   // right child

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If root is not largest, swap and heapify the affected subtree
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Driver code to test heap sort
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
