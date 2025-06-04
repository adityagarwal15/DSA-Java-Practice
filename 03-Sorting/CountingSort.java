public class CountingSort {

    // Function to perform counting sort
    public static void countingSort(int arr[]) {
        // Step 1: Find the maximum value in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Step 2: Create a count array of size (largest + 1)
        int count[] = new int[largest + 1];

        // Step 3: Count the frequency of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Step 4: Put elements back into original array in sorted order
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    // Helper method to print the array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original Array:");
        printArray(arr);

        countingSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
