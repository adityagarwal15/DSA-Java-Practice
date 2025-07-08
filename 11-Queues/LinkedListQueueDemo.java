import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Enqueue
        q.offer(10);  // Preferred (returns false if fails)
        q.add(20);    // Throws exception if fails
        q.offer(30);

        System.out.println("Queue: " + q); // [10, 20, 30]

        // Peek (check front without removing)
        System.out.println("Peek: " + q.peek());     // 10
        System.out.println("Element: " + q.element()); // 10

        // Dequeue
        System.out.println("Poll: " + q.poll());   // 10 (removes it)
        System.out.println("Remove: " + q.remove()); // 20 (removes it)

        System.out.println("Queue after removals: " + q); // [30]

        // Empty check
        System.out.println("Is Empty? " + q.isEmpty()); // false

        // Clear remaining
        q.poll(); // removes 30
        System.out.println("After clearing all: " + q);
        System.out.println("Is Empty? " + q.isEmpty()); // true

        // Safe peek/poll on empty queue
        System.out.println("Peek on empty: " + q.peek());   // null
        System.out.println("Poll on empty: " + q.poll());   // null

        // Uncomment below to see exceptions:
        // System.out.println(q.remove()); // throws NoSuchElementException
        // System.out.println(q.element()); // throws NoSuchElementException
    }
}
