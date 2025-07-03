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

    // Efficient add from last
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Create cycle at pos (1-based index)
    public void makeCycle(int pos) {
        Node temp = head;
        Node startNode = null;
        int count = 1;

        while (temp.next != null) {
            if (count == pos) {
                startNode = temp;
            }
            temp = temp.next;
            count++;
        }

        temp.next = startNode;
    }

    // Floyd's Cycle Detection
    public boolean checkCycle() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

public class DetectCycle {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        ll.makeCycle(3); // create a cycle from node 5 to node 3

        System.out.println("Cycle present? " + ll.checkCycle()); // should return true
    }
}
