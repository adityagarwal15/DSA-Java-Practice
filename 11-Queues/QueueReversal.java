import java.util.*;
import java.util.LinkedList;

public class QueueReversal {

    // Method to reverse a queue using a stack
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Remove all elements from queue and push to stack
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }

        // Step 2: Pop from stack and add back to queue
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Example input
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

        System.out.println("Original Queue: " + q);

        reverseQueue(q);

        System.out.println("Reversed Queue: " + q);
    }
}
