import java.util.*;

public class SubsetsStr {

    public static void sets(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            System.out.println(ans);  // Print subset followed by newline
            return;
        }

        // recursion (choices)
        // Include current character(basically says yes add the current char)
        sets(str, ans + str.charAt(i), i + 1);  //includes the character

        // Exclude current character(says no, do not add the current char)
        sets(str, ans, i + 1);    //skips the character
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        System.out.println("Subsets:");
        sets(str, "", 0);
    }
}
