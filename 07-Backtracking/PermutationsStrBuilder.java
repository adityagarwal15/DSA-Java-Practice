import java.util.Scanner;

public class PermutationsStrBuilder {

    public static void permute(StringBuilder str, StringBuilder ans) {
        // Base case: when input string is empty
        if (str.length() == 0) {
            System.out.println(ans.toString());
            return;
        }

        // Try all characters one by one
        for (int i = 0; i < str.length(); i++) {
            // Choose character at index i
            char ch = str.charAt(i);

            // Remove character from original (simulate picking)
            str.deleteCharAt(i);
            ans.append(ch); // Add to current permutation

            // Recurse on remaining characters
            permute(str, ans);

            // Backtrack: undo changes
            ans.deleteCharAt(ans.length() - 1); // Remove last char added
            str.insert(i, ch); // Put back the removed character
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Permutations:");
        permute(new StringBuilder(input), new StringBuilder());
    }
}
