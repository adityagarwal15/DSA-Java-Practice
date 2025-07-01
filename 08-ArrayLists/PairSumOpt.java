import java.util.*;

public class PairSumOpt {

    // Optimized function using two-pointer approach works on SORTED ARRAY ONLY
    public static void Sum(ArrayList<Integer> list, int n, int target) {

        boolean found = false;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) {
                System.out.println("( " + list.get(left) + ", " + list.get(right) + " )");
                found = true;
                // Required: Move both pointers to avoid infinite loop and check for next possible pair
                left++;
                right--;
            } else if (sum < target) {
                left++; // Move right to get a bigger number
            } else {
                right--; // Move left to get a smaller number
            }
        }

        if (!found) {
            System.out.println("No pair found with the given target.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        System.out.print("Enter elements (sorted): ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        Sum(list, n, target);
    }
}
