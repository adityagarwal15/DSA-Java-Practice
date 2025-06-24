import java.util.*;

public class SameCharSubstrings {

    public static int countSubstrings(String str) {
        int count = 0;
        int n = str.length();

        // Generate all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Check if the first and last characters match
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        int result = countSubstrings(str);
        System.out.println("Count of substrings starting and ending with same character: " + result);

        sc.close();
    }
}
