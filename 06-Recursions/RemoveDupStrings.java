import java.util.*;

public class RemoveDupStrings {

    public static String removeDuplicates(String str, int index, StringBuilder result) {
        if (index == str.length()) {
            return result.toString();
        }

        char currChar = str.charAt(index);

        //this is for all test cases upperCase, lowerCase, digits, symbols

        // Check if the character is already in result
        if (result.indexOf(String.valueOf(currChar)) == -1) {
            result.append(currChar);
        }

        return removeDuplicates(str, index + 1, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string to remove duplicates: ");
        String str = sc.nextLine();

        String result = removeDuplicates(str, 0, new StringBuilder());

        System.out.println("After removing duplicates: " + result);

        sc.close();
    }
}
