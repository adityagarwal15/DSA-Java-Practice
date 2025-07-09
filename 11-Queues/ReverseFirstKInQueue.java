import java.util.*;

public class ReverseFirstKInQueue {

    public static void reverseKElements(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) return;

        Stack<Integer> st = new Stack<>();

        // Step 1: Move first k elements from queue to stack
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }

        // Step 2: Add them back to queue (in reversed order)
        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        // Step 3: Move the remaining (n-k) elements to back
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int k = 3;

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Original Queue: " + q);
        reverseKElements(q, k);
        System.out.println("After Reversing first " + k + " elements: " + q);
    }
}
