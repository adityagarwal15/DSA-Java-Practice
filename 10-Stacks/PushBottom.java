import java.util.*;

public class PushBottom {

    // Function to push an element at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> st, int x) {

        // Base case: if stack is empty, push x and return
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int top = st.pop();             // Remove top element
        pushAtBottom(st, x);            // Recurse on the remaining stack

        /*
         * 🔍 Recursion Insight:
         * - Each time you call this function, Java stores:
         *      - The local variables (like 'top')
         *      - The return address (where to continue after recursion)
         * - So even if 'top' holds only one value, 
         *   each call has its own version of 'top' in memory.
         * - That's why nothing gets lost.
         * - Recursion + Call Stack = Powerful memory handling
         */

        st.push(top);                   // Push back the stored top element
    }

    // Function to print stack from top to bottom
    // ⚠ Note: This empties the stack (since we pop everything)
    public static void print(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        // Push initial elements into the stack
        st.push(10);
        st.push(20);
        st.push(30);

        // Push 99 at the bottom of the stack
        pushAtBottom(st, 99);

        System.out.println("Stack after pushing at bottom (Top to Bottom):");
        print(st);  // Final output: 30, 20, 10, 99
    }
}
