import java.util.*;

public class QueueUsingDeque {
    Deque<Integer> dq = new ArrayDeque<>();

    // Add element to rear of queue
    public void enqueue(int x) {
        dq.addLast(x);
    }

    // Remove and return front element
    public int dequeue() {
        if (dq.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return dq.removeFirst();
    }

    // Peek front element without removing
    public int peek() {
        if (dq.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return dq.peekFirst();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return dq.isEmpty();
    }

    // Display front of queue
    public void displayFront() {
        int front = peek();
        if (front != -1) {
            System.out.println("Front of Queue → " + front);
        }
    }

    public static void main(String[] args) {
        QueueUsingDeque queue = new QueueUsingDeque();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.displayFront(); // Front of Queue → 10

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        queue.displayFront(); // Front of Queue → 20

        System.out.println("Dequeued: " + queue.dequeue()); // 20
        System.out.println("Dequeued: " + queue.dequeue()); // 30

        System.out.println("Is Queue Empty? " + queue.isEmpty()); // true
    }
}
