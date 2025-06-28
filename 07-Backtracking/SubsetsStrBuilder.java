import java.util.*;

public class SubsetsStrBuilder {

    public static void sets(String str, StringBuilder ans, int i) {
        // base case
        if (i == str.length()) {
            System.out.println(ans.toString());
            return;
        }

        // Include current character
        ans.append(str.charAt(i));
        sets(str, ans, i + 1);

        // Backtrack (remove the last character to undo the append)
        ans.deleteCharAt(ans.length() - 1);

        // Exclude current character
        sets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        System.out.println("Subsets:");
        sets(str, new StringBuilder(), 0);
    }
}
