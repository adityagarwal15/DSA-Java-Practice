import java.util.*;

public class PermutationsStr {

    public static void permute(String str, String ans) {
        
        // Base case:
        // If the input string is empty, we have built one full permutation in 'ans'
        if (str.length() == 0) {
            System.out.println(ans); // Print the completed permutation
            return; // Go back to previous call
        }

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {

            // Pick one character to fix at current position
            char curr = str.charAt(i);

            // Build the remaining string (exclude the character at index i)
            // Example: str = "abc", i = 1 → remaining = "ac"
            String remaining = str.substring(0, i) + str.substring(i + 1,str.length());

            // Recursive call:
            // Fix 'curr' at this position, and permute the remaining characters
            // Example: curr = 'b', ans = "a" → next call = permute("c", "ab")
            permute(remaining, ans + curr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Permutations:");
        permute(input, ""); // Start with empty answer string
    }
}
