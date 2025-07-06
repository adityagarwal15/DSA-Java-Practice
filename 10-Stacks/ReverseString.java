import java.util.*;

public class ReverseString {
    public static String rev(String str) {
        Stack<Character> st = new Stack<>();

        // Push every character into the stack
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }

        // Pop and build reversed string
        StringBuilder reversed = new StringBuilder();
        while (!st.isEmpty()) {
            reversed.append(st.pop()); //reversed.append(char or string);
        }

        return reversed.toString(); // Converts StringBuilder → String
    }

    public static void main(String[] args) {
        String str = "aditya";

        String rev = rev(str);

        System.out.println("Original: " + str);
        System.out.println("Reversed: " + rev);
    }
}
