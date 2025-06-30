import java.util.*;

public class Swap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        // Step 1: Input size and elements
        System.out.print("Enter size: ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(num);
        }

        // Step 2: Input the two indices to swap
        System.out.print("Enter index 1: ");
        int idx1 = sc.nextInt();

        System.out.print("Enter index 2: ");
        int idx2 = sc.nextInt();

        // Step 3: Display list before swap
        System.out.println("ArrayList before swapping: " + list);

        // Step 4: Perform the swap using a temporary variable
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

        // Step 5: Display list after swap
        System.out.println("ArrayList after swapping: " + list);
    }
}
