// Node class for Doubly Linked List
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Doubly Linked List class
class DoubleDLL {
    Node head;
    Node tail;

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Print the list forward
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse the doubly linked list
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
}

//  Main class with main() method
public class Reverse {
    public static void main(String[] args) {
        DoubleDLL dll = new DoubleDLL();

        dll.insertAtTail(10);
        dll.insertAtTail(20);
        dll.insertAtTail(30);
        dll.insertAtTail(40);

        System.out.println("Original DLL:");
        dll.print(); // 10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ null

        dll.reverse();

        System.out.println("Reversed DLL:");
        dll.print(); // 40 ⇄ 30 ⇄ 20 ⇄ 10 ⇄ null
    }
}
