// Node class represents each element of the linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class to manage all operations
class LinkedList {

    Node head;
    Node tail;
    int size;

    // Adds a new node at the beginning (head)
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }

        size++;
    }

    // Adds a new node at the end (tail)
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Prints the entire linked list
    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Inserts a node at a specific position (0-based index)
    public void insertAtPosition(int data, int index) {
        // Invalid index case
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }

        // If inserting at head
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        // Move to node at (index - 1)
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        // If inserted at the end, update tail
        if (newNode.next == null) {
            tail = newNode;
        }

        size++;
    }

    // Returns size of the list
    public int getSize() {
        return size;
    }
}

// Main class to test the linked list
public class InsertSizeElem {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(20);
        ll.addFirst(10);
        ll.addLast(30);
        ll.addLast(40);

        ll.printList();  // 10 -> 20 -> 30 -> 40 -> null

        ll.insertAtPosition(25, 2);
        ll.printList();  // 10 -> 20 -> 25 -> 30 -> 40 -> null

        ll.insertAtPosition(5, 0);
        ll.printList();  // 5 -> 10 -> 20 -> 25 -> 30 -> 40 -> null

        ll.insertAtPosition(50, 10);  // Invalid index
        System.out.println("Size: " + ll.getSize());  // Should print 6
        System.out.println("Size: " + ll.size); // THIS IS ALSO CORRECT
    }
}
