public class CircularQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    public CircularQueue(int k) {
        arr = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    // Enqueue (add element)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        arr[rear] = data;
        rear = (rear + 1) % capacity;
        size++;
    }

    // Dequeue (remove element)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    // Peek front
    public int peek() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        q.enqueue(60); // Should go to front position (wrap around)
        q.display();

        System.out.println("Front Element: " + q.peek());
    }
}
