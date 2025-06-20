import java.util.*;

public class DecOrder {

    public static void dec(int start, int end) {
        // Base case
        if (start == end) {
            System.out.print(end);  // No space after last numbers
            return;
        }

        System.out.print(start + " ");
        dec(start - 1, end);  // Recursive call
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting number for dec order: ");
        int start = sc.nextInt();

        System.out.print("Enter ending number for dec order: ");
        int end = sc.nextInt();

        if (start >= end) {
            dec(start, end);
        } else {
            System.out.println("Invalid range. Start should be greater than or equal to end.");
        }

        sc.close();
    }
}
