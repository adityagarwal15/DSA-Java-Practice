import java.util.*;

public class FirstLastOccOptimized {

    static int first = -1;
    static int last = -1;

    //this is optimized but it has the same time and space complexity

    public static void findOccurrence(int arr[], int key, int index) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] == key) {
            if (first == -1) {
                first = index;
            }
            last = index;  // keep updating last
        }

        findOccurrence(arr, key, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        findOccurrence(arr, key, 0);

        if (first == -1) {
            System.out.println("Key not found.");
        } else {
            System.out.println("First occurrence: " + first);
            System.out.println("Last occurrence: " + last);
        }

        sc.close();
    }
}
