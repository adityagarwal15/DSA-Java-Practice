import java.util.*;

public class IncOrder {
    public static void Inc(int start, int end) {
        if (start == end) {
            System.out.print(end);
            return;
        }
        System.out.print(start + " ");
        Inc(start + 1, end);  // pass both start and end
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting number for inc order: ");
        int start = sc.nextInt();

        System.out.print("Enter ending number for inc order: ");
        int end = sc.nextInt();

        if (start <= end) {
            Inc(start, end);
        } else {
            System.out.println("Invalid range. Start should be less than or equal to end.");
        }

        sc.close(); 
    }
}
