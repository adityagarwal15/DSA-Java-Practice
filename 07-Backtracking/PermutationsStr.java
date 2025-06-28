import java.util.*;

public class PermutationsStr {

    public static void permute(String str, String ans) {
        // base case: if string is empty, we've formed one permutation
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // loop through the string
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            // remaining string after removing current character
            String remaining = str.substring(0, i) + str.substring(i + 1, str.length());

            // recursive call
            permute(remaining, ans + curr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Permutations:");
        permute(input, "");
    }
}
