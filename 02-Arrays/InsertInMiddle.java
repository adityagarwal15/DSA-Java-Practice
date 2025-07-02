import java.util.Arrays;

public class InsertInMiddle {

    public static int[] insertInMiddle(int[] original, int element) {
        int n = original.length;
        int middle = n / 2;

        // Create a new array of size n+1
        int[] newArray = new int[n + 1];

        // Copy elements before the middle
        for (int i = 0; i < middle; i++) {
            newArray[i] = original[i];
        }

        // Insert the new element at middle
        newArray[middle] = element;

        // Copy remaining elements after the middle
        for (int i = middle; i < n; i++) {
            newArray[i + 1] = original[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int elementToAdd = 25;

        int[] newArr = insertInMiddle(arr, elementToAdd);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("New Array: " + Arrays.toString(newArr));
    }
}
