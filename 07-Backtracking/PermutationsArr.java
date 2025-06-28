import java.util.Scanner;

public class PermutationsArr {

    // Swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Recursive function to generate permutations
    public static void permute(int[] arr, int index) {
        //  Base case: reached end of array → print current permutation
        if (index == arr.length) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) System.out.print(", ");
            }
            System.out.println("]");
            return;
        }

        // Try all possible swaps at current index
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i); // fix one element
            permute(arr, index + 1); // recurse for remaining
            swap(arr, index, i); // 🔁 backtrack (undo swap)
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Generate permutations
        System.out.println("Permutations:");
        permute(arr, 0);
    }
}
