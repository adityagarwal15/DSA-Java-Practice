import java.util.Scanner;

public class SubsetsArr {

    public static void printSubsets(int[] arr, int i, int[] subset, int j) {
        // base case: we've reached the end of original array
        if (i == arr.length) {
            System.out.print("[");
            for (int k = 0; k < j; k++) {
                System.out.print(subset[k]);
                if (k < j - 1) System.out.print(", ");
            }
            System.out.println("]");
            return;
        }

        // include arr[i] in subset
        subset[j] = arr[i]; //includes current element
        printSubsets(arr, i + 1, subset, j + 1);  //(yes case)

        // exclude arr[i] from subset
        printSubsets(arr, i + 1, subset, j);  //(no case)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] subset = new int[n];  // temp array to hold current subset
        System.out.println("Subsets:");
        printSubsets(arr, 0, subset, 0);

        // i: index in original array
        // j: index in subset array
    }
}
