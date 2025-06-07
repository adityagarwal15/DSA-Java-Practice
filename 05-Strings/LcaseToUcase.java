import java.util.*;

public class LcaseToUcase {

    // Method to convert the first letter of each word to uppercase
    public static String upperCase(String str) {
        // Trim leading/trailing whitespace
        str = str.trim();

        // Return empty string if input is empty
        if (str.isEmpty()) return "";

        // Initialize StringBuilder to build the result
        StringBuilder sb = new StringBuilder();

        // Convert the first character to uppercase
        sb.append(Character.toUpperCase(str.charAt(0)));

        // Loop through the rest of the string
        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // If current character is a space and next character exists
            if (currentChar == ' ' && i+1 < str.length()) {
                sb.append(' '); // Append the space
                i++; // Move to the next character
                // Append the uppercase version of the next character
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                // Otherwise, append the current character as-is
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hi, i am aditya";
        System.out.println(upperCase(str)); // Output: Hi, I Am Aditya
    }
}
