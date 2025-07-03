// Node class representing an element in the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize node with data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class containing linked list operations
class LinkedList {

    Node head;  // Points to the start of the list
    Node tail;  // Points to the end of the list
    int size;   // Keeps track of the size of the list

    // Method to add a node at the beginning of the list
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            // If list is empty, new node becomes both head and tail
            head = tail = newNode;
        } else {
            // Insert at beginning (natural addFirst)
            newNode.next = head;
            head = newNode;
        }

        size++; // Increase size of the list
    }

    // Method to add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            // If list is empty, new node becomes both head and tail
            head = tail = newNode;
        } else {
            // Link the new node at the end and update tail
            tail.next = newNode;
            tail = newNode;
        }

        size++; // Increase size of the list
    }

    // Method to print the entire linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    // Method to remove the nth node from the end of the list
    public void removeNthFromEnd(int n) {
        // Dummy node helps in edge cases like deleting the head
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast != null)
                fast = fast.next;
        }

        // Move both fast and slow until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node from the end
        if (slow.next != null)
            slow.next = slow.next.next;

        // Update head in case the removed node was the head
        head = dummy.next;

        // Decrement size (optional if you want to maintain size)
        size--;
    }
}

// Main class to test LinkedList operations
public class FindRemoveEnd {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Sample operations
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        
        System.out.print("Original List: ");
        list.print();

        // Remove 2nd node from end (expected: 40 removed)
        list.removeNthFromEnd(2);
        
        System.out.print("After Removing 2nd node from end: ");
        list.print();
    }
}
