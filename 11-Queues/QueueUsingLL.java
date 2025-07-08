public class QueueUsingLL {

    // Inner Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue pointers
    Node front, rear; //similar to head,tail

    // Constructor
    public QueueUsingLL() {
        front = rear = null;
    }

    // Enqueue (insert at rear)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            // First element
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue (remove from front)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int val = front.data;
        front = front.next;

        // If queue becomes empty after dequeue
        if (front == null) {
            rear = null;
        }

        return val;
    }

    // Peek front element
    public int peek() {
        if (isEmpty()) return -1;
        return front.data;
    }

    // Check if empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        QueueUsingLL q = new QueueUsingLL();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Queue: 10 20 30

        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.display(); // Queue: 20 30

        System.out.println("Front: " + q.peek()); // 20
    }
}
