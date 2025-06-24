import java.util.*;

public class LengthString {

    // Recursive function to calculate length of a string
    public static int len(String str, int index) {
        // Base case: if we reach the end of the string
        if (index == str.length()) {
            return 0;
        }

        // Count this character (1) and move to next
        // Explanation:
        // - Each recursive call processes one character.
        // - The `1 +` means: "Count this character, then count the rest recursively."
        // - The recursion accumulates the count as the call stack unwinds.
        return 1 + len(str, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();

        int length = len(str, 0);  // Start with index 0
        System.out.println("Length of string: " + length);

        sc.close();
    }
}
