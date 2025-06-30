import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create an empty ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Step 2: Ask user how many elements to input
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Step 3: Take user input and add to the list
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(num);
        }

        // Step 4: Print the original list
        System.out.println("Original list is: " + list);

        // Step 5: Print the reversed list using a manual reverse loop
        System.out.print("Manual reverse (without modifying list): ");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println(); // New line

        // Step 6: Reverse the list in-place using Collections.reverse()
        Collections.reverse(list);

        // Step 7: Print the modified list
        System.out.println("Reversed list (in-place using Collections.reverse()): " + list);
    }
}
