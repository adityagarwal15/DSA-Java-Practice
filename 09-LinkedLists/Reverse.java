class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    Node head;
    Node tail;
    int size;

    // Add at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) { // empty list
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Print the list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse the linked list
    public void reverse() {
        Node prev = null;       // initially, nothing before head
        Node curr = head;       // start at head
        Node next;              // to store next node temporarily because once we change curr.next, we lose access to the rest of the list if we don’t store it

        while (curr != null) {
            next = curr.next;   // Save the next node before breaking the link
            curr.next = prev;   // reverse the link
            prev = curr;        // move prev forward
            curr = next;        // move curr forward
        }

        // After reversal, prev will be at the new head
        head = prev;
    }
}
public class Reverse {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);

        ll.print(); // 10 -> 20 -> 30 -> null

        ll.reverse();

        ll.print(); // 30 -> 20 -> 10 -> null
    }
}
