public class QueueUsingArray {
    int[] arr;
    int front;
    int rear;
    int capacity;

    public QueueUsingArray(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    // Enqueue (add element)
    public void enqueue(int data) {
        if (rear == capacity - 1) {
            System.out.println("Queue is Full (Overflow)");
            return;
        }
        arr[++rear] = data;
    }

    // Dequeue (remove element)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty (Underflow)");
            return -1;
        }
        return arr[front++];
    }

    // Peek (front element)
    public int peek() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // isEmpty
    public boolean isEmpty() {
        return front > rear;
    }

    // Display queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Size of queue
    public int size() {
        return rear - front + 1;
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        System.out.println("Front Element: " + q.peek());
        System.out.println("Size: " + q.size());
    }
}
