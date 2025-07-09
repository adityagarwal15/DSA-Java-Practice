import java.util.*;
import java.util.LinkedList;

public class InterleaveTwoHalves {

    public static void interleaveQueue(Queue<Integer> q) {
        int n = q.size();
        if (n % 2 != 0) {
            System.out.println("Queue must have even number of elements");
            return;
        }

        Queue<Integer> firstHalf = new LinkedList<>();

        // Step 1: Move first half to separate queue
        for (int i = 0; i < n / 2; i++) {
            firstHalf.offer(q.poll());
        }

        // Step 2: Interleave elements from both halves
        while (!firstHalf.isEmpty()) {
            q.offer(firstHalf.poll()); // add from first half
            q.offer(q.poll());         // add from second half (which remained in q)
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Example input
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);

        System.out.println("Original Queue: " + q);
        interleaveQueue(q);
        System.out.println("Interleaved Queue: " + q);
    }
}
