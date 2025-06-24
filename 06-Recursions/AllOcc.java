import java.util.*;

public class AllOcc {

    // Recursive function to print all occurrences of a key in the array
    public static void Occ(int[] arr, int i, int key) {
        //  Base case: If index reaches end of array, stop recursion
        if (i == arr.length) {
            return;
        }

        //  If current element matches the key, print its index
        if (arr[i] == key) {
            System.out.print(i + " ");  // Don't return — keep looking for more matches
        }

        //  Recursive call to check the next element
        Occ(arr, i + 1, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Input array elements
        System.out.print("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Input the key to search
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        // Print all indices where key is found
        System.out.print("Indices where key is found: ");
        Occ(arr, 0, key);  // Start from index 0

        sc.close();
    }
}
