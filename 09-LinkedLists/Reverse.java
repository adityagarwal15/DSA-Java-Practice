// Node class represents a single node in the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize the node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class contains all operations on the linked list
class LinkedList {

    Node head;
    Node tail;
    int size;

    // 🔼 Adds a new node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {           // If list is empty
            head = tail = newNode;
        } else {
            newNode.next = head;      // Point new node to current head
            head = newNode;           // Update head to new node
        }
        size++;
    }

    // 📄 Prints the entire linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 🔁 Reverses the linked list in-place using 3-pointer technique
    public void reverse() {
        Node prev = null;     // Previous node starts as null
        Node curr = head;     // Current node starts at head
        Node next;            // Placeholder for the next node

        // Traverse the list and reverse pointers
        while (curr != null) {
            next = curr.next;     // Save next node
            curr.next = prev;     // Reverse the link
            prev = curr;          // Move prev forward
            curr = next;          // Move curr forward
        }

        head = prev;  // After loop, prev is the new head
    }
}

// 🔁 Main class to test reversal of linked list
public class Reverse {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Add elements to list: 10 -> 20 -> 30
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);

        System.out.println("Original List:");
        ll.print(); // 10 -> 20 -> 30 -> null

        ll.reverse(); // Reverse the list

        System.out.println("Reversed List:");
        ll.print(); // 30 -> 20 -> 10 -> null
    }
}
