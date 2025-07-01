import java.util.*;

public class PairSum {

    // Function to find and print all pairs with the given sum
    public static void Sum(ArrayList<Integer> list, int n, int target) {
        boolean found = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(i) + list.get(j) == target) {
                    System.out.println("(" + list.get(i) + ", " + list.get(j) + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No pair found with the given target.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the ArrayList: ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " elements: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        Sum(list, n, target);
    }
}
