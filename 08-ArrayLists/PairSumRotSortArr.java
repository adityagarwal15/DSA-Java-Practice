import java.util.*;

public class PairSumRotSortArr {

    public static void Pair(ArrayList<Integer> list, int n, int target) {
        int left = 0;  // smallest element index
        int right = 0; // largest element index (pivot)
        boolean found = false;

        // Step 1: Find the pivot (point of rotation)
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                right = i;       // pivot (largest element)
                left = (i + 1);  // next element is the smallest
                break;
            }
        }

        // Step 2: Use modified two-pointer logic in circular manner
        while (left != right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                System.out.println("Pair found: (" + list.get(left) + ", " + list.get(right) + ")");
                found = true;
                // Move in circular fashion
                left = (left + 1) % n;
                right = (n + right - 1) % n;
            } else if (sum < target) {
                left = (left + 1) % n; // move to next bigger element
            } else {
                right = (n + right - 1) % n; // move to smaller element
            }
        }

        if (!found) {
            System.out.println("No pair found with the given sum.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        System.out.print("Enter elements (sorted & rotated): ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        Pair(list, n, target);
    }
}
