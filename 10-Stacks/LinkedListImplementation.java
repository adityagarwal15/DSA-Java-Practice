import java.util.LinkedList;
class MyStack {
    private Node head;
    private int size;

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public MyStack() {
        head = null;
        size = 0;
    }

    // Push operation - add to the beginning
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Pop operation - remove from beginning
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int top = head.data;
        head = head.next;
        size--;
        return top;
    }

    // Peek operation - return top without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Return size of the stack
    public int size() {
        return size;
    }
}

public class LinkedListImplementation {
    public static void main(String[] args) {
        MyStack st = new MyStack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element: " + st.peek()); // 30
        System.out.println("Popped element: " + st.pop()); // 30
        System.out.println("Top after pop: " + st.peek()); // 20
        System.out.println("Stack size: " + st.size()); // 2
        System.out.println("Is stack empty? " + st.isEmpty()); // false 

        st.pop();
        st.pop();
        System.out.println("Is stack empty after popping all? " + st.isEmpty()); // true
        st.pop(); // Underflow
    }
}

