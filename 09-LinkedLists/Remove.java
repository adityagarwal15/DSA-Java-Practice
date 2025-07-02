// Node class represents each element of the linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class to manage the list
class LinkedList {

    Node head;
    Node tail;
    int size;

    // Add node at the beginning
    public void firstAdd(int data) {
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
    public void lastAdd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // Print all elements
    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Insert node at a specific index (0-based)
    public void Insertion(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }

        if (index == 0) {
            firstAdd(data); // already increases size
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }

        size++;
    }

    // Return current size of the list
    public int getSize() {
        return size;
    }

   // Removes the first node
public void removeFirst() {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    head = head.next;
    size--;

    if (head == null) {
        tail = null;
    }
}

// Removes the last node
public void removeLast() {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    if (head.next == null) {
        head = tail = null;
        size--;
        return;
    }

    // Traverse to the second last node
    Node temp = head;
    while (temp.next != tail) {
        temp = temp.next;
    }

    temp.next = null;
    tail = temp;
    size--;
}

}
public class Remove {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.firstAdd(1);
        ll.lastAdd(2);
        ll.lastAdd(4);
        ll.Insertion(3, 2); // Insert 3 at index 2

        ll.print(); // Expected: 1 -> 2 -> 3 -> 4 -> null
    }
}
