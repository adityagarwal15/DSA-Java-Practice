import java.util.*;

public class DuplicateParenthesis {

    public static boolean check(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            // Push all characters to stack except closing bracket ')'
            if (curr != ')') {
                st.push(curr);
            } else {
                // When a closing bracket is found, count how many elements were inside
                int count = 0;

                // Pop elements until opening bracket '(' is found
                while (!st.isEmpty() && st.peek() != '(') {
                    st.pop();
                    count++;
                }

                // Pop the opening bracket '(' itself
                if (!st.isEmpty()) {
                    st.pop();
                }

                // If there were 0 or 1 characters between '(', ')' → it's duplicate
                // Example: ((a)) → count = 1 → duplicate
                if (count <= 1) {
                    return true;
                }
            }
        }

        // If the loop finishes and no duplicate found, return false
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";

        if (check(str)) {
            System.out.println("Duplicate Parentheses found");
        } else {
            System.out.println("No Duplicate Parentheses");
        }
    }
}
