// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class
class LinkedList {

    Node head;
    Node tail;
    int size;

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add node at the end
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

    // Print entire list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Public method to start recursive search
    public int search(int key) {
        return searchRecursive(head, key, 0);
    }

    // Recursive helper function (PRIVATE)
    private int searchRecursive(Node current, int key, int index) {
        if (current == null) {
            return -1; // Base case: end of list, not found
        }
        if (current.data == key) {
            return index; // Base case: key found
        }
        return searchRecursive(current.next, key, index + 1); // Recursive call
    }
}

// Main class
public class RecursiveSearch {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);

        ll.print(); // 10 -> 20 -> 30 -> 40 -> null

        int result1 = ll.search(30);
        if (result1 != -1) {
            System.out.println("Key 30 found at index: " + result1);
        } else {
            System.out.println("Key 30 not found");
        }

        int result2 = ll.search(50);
        if (result2 != -1) {
            System.out.println("Key 50 found at index: " + result2);
        } else {
            System.out.println("Key 50 not found");
        }
    }
}
