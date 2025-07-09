import java.util.*;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // Insert at both ends
        deque.addFirst(10); // front → [10]
        deque.addLast(20);  // front → [10, 20]
        deque.addFirst(5);  // front → [5, 10, 20]
        deque.addLast(25);  // front → [5, 10, 20, 25]

        System.out.println("Deque: " + deque); // [5, 10, 20, 25]

        // Access front and rear
        System.out.println("Front: " + deque.getFirst()); // 5
        System.out.println("Rear: " + deque.getLast());   // 25

        // Remove from both ends
        deque.removeFirst(); // remove 5
        deque.removeLast();  // remove 25

        System.out.println("Deque after removals: " + deque); // [10, 20]

        // Peek methods
        System.out.println("Peek Front: " + deque.peekFirst()); // 10
        System.out.println("Peek Rear: " + deque.peekLast());   // 20

        // Check if deque is empty
        System.out.println("Is Empty: " + deque.isEmpty()); // false

        // Size
        System.out.println("Size: " + deque.size()); // 2
    }
}
