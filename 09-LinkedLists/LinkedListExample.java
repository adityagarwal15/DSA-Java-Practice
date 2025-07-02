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
class LinkedLists {
    Node head;
    Node tail;

    // Add a new node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    // Add a new node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print all elements in the Linked List
    public void printList() {
        if(head == null){
            System.out.print("linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Main class (must match filename)
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();
        list.addFirst(10);
        list.addFirst(5);
        list.addLast(20);
        list.addLast(25);
        list.printList(); // Expected: 5 -> 10 -> 20 -> 25 -> null
    }
}
