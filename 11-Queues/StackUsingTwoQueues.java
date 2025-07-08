import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation: costly push, so latest always at front of q1
    public void push(int x) {
        q2.offer(x); // add new element to q2

        // move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop operation: just remove from front of q1
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return q1.poll();
    }

    // Peek operation: see top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return q1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Display top
    public void displayTop() {
        int top = peek();
        if (top != -1) {
            System.out.println("Top → " + top);
        }
    }

    public static void main(String[] args) {
        StackUsingTwoQueues s = new StackUsingTwoQueues();

        s.push(10);
        s.push(20);
        s.push(30);

        s.displayTop(); // Top → 30

        System.out.println("Popped: " + s.pop()); // 30
        s.displayTop(); // Top → 20

        s.push(40);
        s.displayTop(); // Top → 40

        System.out.println("Popped: " + s.pop()); // 40
        System.out.println("Popped: " + s.pop()); // 20
        System.out.println("Popped: " + s.pop()); // 10

        System.out.println("Is Empty: " + s.isEmpty()); // true
    }
}
