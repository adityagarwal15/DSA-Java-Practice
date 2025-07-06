import java.util.*;

public class NextSmallerElem {

    // Function to find the Next Smaller Element for each arr[i]
    public static void smaller(int[] arr, int[] nse) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        // 1. Traverse from right to left (because we want "next" smaller)
        for (int i = n - 1; i >= 0; i--) {

            // 2. Pop elements from stack that are >= current
            // These are not smaller, so they can't be the answer
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            // 3. Top of stack is the next smaller element (if any)
            if (st.isEmpty()) {
                nse[i] = -1;  // No smaller element to the right
            } else {
                nse[i] = st.peek();
            }

            // 4. Push current element for use in future comparisons
            st.push(arr[i]);

            /*
             Stack stores candidates for "next smaller element" from right to left.
             For each element, we remove anything >= it (not helpful),
             then check top of the stack — if it's smaller, it’s our answer.
             Then push current element to help for elements on the left.
            */
        }
    }

    public static void main(String[] args) {

        int arr[] = {6, 8, 0, 1, 3};
        int nse[] = new int[arr.length];

        smaller(arr, nse);

        System.out.print("Original Arr: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.print("Next Smaller Elements: ");
        for (int i : nse) {
            System.out.print(i + " ");
        }
    }
}
