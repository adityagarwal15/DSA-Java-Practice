import java.util.*;

public class RemoveConsecutiveDuplicates {

    public static String removeConsecutive(String str, int index, StringBuilder result) {
        // Base case
        if (index == str.length()) {
            return result.toString();
        }

        // If it's the first character, always add
        if (index == 0 || str.charAt(index) != str.charAt(index - 1)) {
            result.append(str.charAt(index));
        }

        // Recursive call
        return removeConsecutive(str, index + 1, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();

        String result = removeConsecutive(str, 0, new StringBuilder());
        System.out.println("After removing consecutive duplicates: " + result);

        sc.close();
    }
}
