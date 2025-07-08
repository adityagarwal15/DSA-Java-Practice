import java.util.*;

public class ArrayDequeQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        // Enqueue
        q.offer(100);
        q.add(200);
        q.offer(300);

        System.out.println("Queue: " + q); // [100, 200, 300]

        // Peek
        System.out.println("Peek: " + q.peek());     // 100
        System.out.println("Element: " + q.element()); // 100

        // Dequeue
        System.out.println("Poll: " + q.poll());   // 100
        System.out.println("Remove: " + q.remove()); // 200

        System.out.println("Queue after removals: " + q); // [300]

        // Empty check
        System.out.println("Is Empty? " + q.isEmpty()); // false

        // Clear remaining
        q.poll(); // removes 300
        System.out.println("After clearing all: " + q);
        System.out.println("Is Empty? " + q.isEmpty()); // true

        // Safe peek/poll on empty queue
        System.out.println("Peek on empty: " + q.peek());   // null
        System.out.println("Poll on empty: " + q.poll());   // null
    }
}
