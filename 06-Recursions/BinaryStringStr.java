import java.util.*;

public class BinaryStringStr {

    // ✅ SAME LOGIC using normal `String` instead of StringBuilder.
    //
    // Strings in Java are IMMUTABLE, so `str + "0"` creates a new string automatically.
    // This ensures that each recursive call works with a separate string, avoiding side effects.
    // This approach is simpler and safer, especially for beginners.

    public static void generate(int n, String str, int lastDigit) {
        // Base case: if the desired length is reached, print the string
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // You can always add '0'
        generate(n - 1, str + "0", 0);

        // You can add '1' only if last digit was not '1'
        if (lastDigit == 0) {
            generate(n - 1, str + "1"3, 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        System.out.println("Binary strings of size " + n + " without consecutive 1s:");
        generate(n, "", 0);  // Start with empty string and lastDigit = 0

        sc.close();
    }
}
