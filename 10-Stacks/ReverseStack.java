import java.util.*;

public class ReverseStack {

    // Function to push an element at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> st, int x) {
        // Base case: if stack is empty, push x
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        // Step 1: Pop the top element
        int top = st.pop();

        // Step 2: Recurse on the remaining stack
        pushAtBottom(st, x);

        // Step 3: Push the stored top element back after recursion
        st.push(top);
    }

    // Function to reverse the stack using recursion
    public static void reverse(Stack<Integer> st) {
        // Base case: if stack is empty, nothing to reverse
        if (st.isEmpty()) {
            return;
        }

        // Step 1: Pop the top element
        int top = st.pop();

        // Step 2: Reverse the remaining stack recursively
        reverse(st);

        // Step 3: Push the removed element to the bottom of reversed stack
        pushAtBottom(st, top);
    }

    // Function to print the stack from top to bottom
    // Note: This function will empty the stack
    public static void print(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        // Pushing initial elements into the stack
        st.push(1);
        st.push(2);
        st.push(3);

        // Reversing the stack
        reverse(st); // Stack becomes [1, 2, 3] (top to bottom)

        // Printing reversed stack
        System.out.println("Reversed Stack:");
        print(st); // Output: 1 2 3
    }
}
