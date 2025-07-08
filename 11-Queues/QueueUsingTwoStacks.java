import java.util.Stack;

public class QueueUsingTwoStacks {

    // Two stacks: s1 for enqueue, s2 for dequeue
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation: always push to s1
    public void enqueue(int data) {
        s1.push(data);
    }

    // Dequeue operation: always pop from s2
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        shiftStacksIfNeeded();
        return s2.pop();
    }

    // Peek operation: return the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        shiftStacksIfNeeded();
        return s2.peek();
    }

    // Helper method: move elements from s1 to s2 only if s2 is empty
    private void shiftStacksIfNeeded() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Display the front element of the queue
    public void display() {
        int front = peek(); //call peek fnc and stores s2.peek() into front
        if (front != -1) {
            System.out.println("Front → " + front);
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks(); //making obj of class only

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display(); // Should print Front → 10

        System.out.println("Dequeued: " + q.dequeue()); // Should remove and print 10

        q.enqueue(40);
        q.display(); // Should print Front → 20

        System.out.println("Dequeued: " + q.dequeue()); // Should remove and print 20
        System.out.println("Dequeued: " + q.dequeue()); // Should remove and print 30
        System.out.println("Dequeued: " + q.dequeue()); // Should remove and print 40

        System.out.println("Is Queue Empty? " + q.isEmpty()); // Should print true
    }
}
