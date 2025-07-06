import java.util.*;

public class NextGreaterElem {

    // Function to fill nge[] with the Next Greater Element for each arr[i]
    public static void greater(int[] arr, int[] nge) {
        Stack<Integer> st = new Stack<>();  // Stack stores potential NGE candidates

        int n = arr.length;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Step 1: Remove all elements from stack <= current
            // Because they can't be the next greater for this element
            // and they also can't help any element to the left of current
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // Step 2: Set the next greater element
            if (st.isEmpty()) {
                nge[i] = -1; // No greater element found on right
            } else {
                nge[i] = st.peek(); // Top of stack is next greater
            }

            // Step 3: Push current element for future comparisons
            st.push(arr[i]);

            /*
             Example: arr = [6, 8, 0, 1, 3]
             When processing 8, we pop 0, 1, 3 (all smaller than 8).
             Now the stack has only 8.
             For 6, we only see 8 in the stack, and that's enough.
             
             Why?
             Because even though elements like 0,1,3 existed after 6,
             they are all smaller than 6, and even smaller than 8,
             so they are irrelevant when looking for "next greater" for 6.

             If 8 is greater and directly comes after 6, it's the best and only answer.
             Any smaller elements that come after 8 can't help now or later, 
             so popping them doesn't lose anything important.
            */
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        int nge[] = new int[arr.length];

        greater(arr, nge);

        System.out.print("Original Arr: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.print("Next Greater Elements: ");
        // Looping on nge because this array was filled in the function above
        for (int i : nge) {
            System.out.print(i + " ");
        }
    }
}
