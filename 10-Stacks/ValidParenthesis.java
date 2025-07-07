import java.util.*;

public class ValidParenthesis {

    public static void check(String str) {

        Stack<Character> st = new Stack<>();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            char currChar = str.charAt(i);

            // 1. Push opening brackets onto the stack
            if (currChar == '{' || currChar == '[' || currChar == '(') {
                st.push(currChar);
            }

            // 2. For closing brackets
            else{
                // a. Stack empty → nothing to match → invalid
                if (st.isEmpty()) {
                    System.out.println("invalid");
                    return;
                }

                char top = st.pop();

                // b. Matching pairs logic
                if ((currChar == ')' && top != '(') ||
                    (currChar == '}' && top != '{') ||
                    (currChar == ']' && top != '[')) {
                    System.out.println("invalid");
                    return;
                }
            }
        }

        // 3. After full traversal, if stack is empty → valid
        if (st.isEmpty()) {
            System.out.println("valid");
        } else {
            System.out.println("invalid"); // Unmatched opening brackets left
        }
    }

    public static void main(String[] args) {
        String str = "({[})"; // Try with other test cases too
        check(str);
    }
}
