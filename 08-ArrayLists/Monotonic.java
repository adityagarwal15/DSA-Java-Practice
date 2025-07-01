import java.util.*;

public class Monotonic {

    // Function to check if the ArrayList is monotonic
    public static boolean check(ArrayList<Integer> list, int n) {
        // We assume both increasing and decreasing are true initially
        boolean increasing = true;
        boolean decreasing = true;

        // Loop through the list to compare each element with its next one
        for (int i = 0; i < n - 1; i++) {
            // If current element is less than next, it's not decreasing
            if (list.get(i) < list.get(i + 1)) {
                decreasing = false;
            }
            // If current element is greater than next, it's not increasing
            else if (list.get(i) > list.get(i + 1)) {
                increasing = false;
            }
            // If elements are equal, we don't update anything as it's valid for both cases
        }

        // If either increasing or decreasing is true, then it's monotonic
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of ArrayList
        System.out.print("Enter size: ");
        int n = sc.nextInt();

        // Input elements into ArrayList
        System.out.print("Enter elements: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Call the check function and print result
        boolean result = check(list, n);
        System.out.println("Is the list monotonic? " + result);
    }
}
