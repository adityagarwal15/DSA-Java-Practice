import java.util.*;

public class StackUsingDeque {
    Deque<Integer> dq = new ArrayDeque<>();

    // Push element to top of stack
    public void push(int x) {
        dq.addFirst(x);
    }

    // Remove and return top element
    public int pop() {
        if (dq.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return dq.removeFirst();
    }

    // Peek top element without removing
    public int peek() {
        if (dq.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return dq.peekFirst();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return dq.isEmpty();
    }

    // Display stack top
    public void displayTop() {
        int top = peek();
        if (top != -1) {
            System.out.println("Top of Stack → " + top);
        }
    }

    public static void main(String[] args) {
        StackUsingDeque stack = new StackUsingDeque();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.displayTop(); // Top of Stack → 30

        System.out.println("Popped: " + stack.pop()); // 30
        stack.displayTop(); // Top of Stack → 20

        System.out.println("Popped: " + stack.pop()); // 20
        System.out.println("Popped: " + stack.pop()); // 10

        System.out.println("Is Stack Empty? " + stack.isEmpty()); // true
    }
}
