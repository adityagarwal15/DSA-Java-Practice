import java.util.*;

public class RemoveDupStrings {

    public static String removeDuplicates(String str, int index, StringBuilder result) {
        // Base case: if we've checked all characters, return the final result
        if (index == str.length()) {
            return result.toString();
        }

        // Get the current character at the given index
        char currChar = str.charAt(index);

        // Check if the character is already present in 'result'
        // Convert char to string and use indexOf to see if it's already been added
        // If indexOf returns -1, it means the character is NOT present in result yet
        if (result.indexOf(String.valueOf(currChar)) == -1) {
            // Not a duplicate — append it to the result
            result.append(currChar);
        }

        // Move to the next character in the input string
        return removeDuplicates(str, index + 1, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string to remove duplicates: ");
        String str = sc.nextLine();

        // Call the recursive function with starting index 0 and empty result builder
        String result = removeDuplicates(str, 0, new StringBuilder());

        System.out.println("After removing duplicates: " + result);

        sc.close();
    }
}
