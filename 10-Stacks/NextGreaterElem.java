import java.util.*;

public class NextGreaterElem {

    // Function to fill nge[] with the Next Greater Element for each arr[i]
    public static void greater(int[] arr, int[] nge) {
        Stack<Integer> st = new Stack<>();  // Stack stores potential NGE candidates

        int n = arr.length;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Step 1: Remove all elements from stack <= current
            // Why? Because they can't be the next greater for this element or any left of it
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // Step 2: Set the next greater element
            if (st.isEmpty()) {
                nge[i] = -1; // No greater element found on right
            } else {
                nge[i] = st.peek(); // Top of stack is next greater
            }

            // Step 3: Push current element for next iterations to use
            st.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        int nge[] = new int[arr.length];

        greater(arr, nge);

        System.out.print("Next Greater Elements: ");

        //looping on nge, becasue in that arr only changes made in the above function
        for (int i : nge) {
            System.out.print(i + " ");
        }
    }
}
