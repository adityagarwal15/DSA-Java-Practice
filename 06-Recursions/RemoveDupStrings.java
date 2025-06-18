import java.util.*;

public class RemoveDupStrings {

    public static String removeDuplicates(String str, int index, StringBuilder result, boolean[] map) {
        if (index == str.length()) {
            return result.toString();
        }

        char currChar = str.charAt(index);
        if (!map[currChar - 'a']) {
            map[currChar - 'a'] = true;
            result.append(currChar);
        }

        return removeDuplicates(str, index + 1, result, map);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string to remove duplicates: ");
        String str = sc.nextLine();

        boolean[] map = new boolean[26];  // for lowercase a-z
        String result = removeDuplicates(str, 0, new StringBuilder(), map);
        System.out.println("After removing duplicates: " + result);

        sc.close();
    }
}
