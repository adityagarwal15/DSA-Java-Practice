// Node class for LinkedList
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

    // Add new node at the end (efficient way)
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode; // first node
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to print the Linked List
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }
/*📌 Key Revision Points
1) Why we reset slow = head?

-> After the meeting point inside the loop, both slow (from start) and fast (from meeting  point) take the same number of steps to reach the start of the cycle.

2) Why prev.next = null?

prev is one step behind fast, so it points to the last node of the cycle, and we break the cycle by pointing prev.next to null.

3) Why fast == slow means a cycle?

If two pointers (one faster than the other) meet, it can only happen if the faster one has looped around and caught up — which only happens in a cycle. */
    // ✅ Step-by-step: Detect and Remove a Cycle in Linked List
    public void removeCycle() {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect if cycle exists using Floyd's Cycle Detection Algorithm
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move by 1
            fast = fast.next.next;    // move by 2

            if (slow == fast) {       // cycle detected
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            System.out.println("❌ No cycle found in the list.");
            return;
        }

        // Step 2: Find the starting point of the cycle
        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;             // stores the last node before loop starts
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Break the cycle
        prev.next = null;
        System.out.println("✅ Cycle removed at node: " + slow.data);
    }

    // 🔁 Create a cycle in the linked list at the given position (0-based)
    public void makeCycle(int pos) {
        Node temp = head; //temp start w head
        Node startNode = null; //startNode will be at null
        int count = 0; //start w 0-based indexing

        while (temp.next != null) {
            if (count == pos) {
                startNode = temp; // store the node at position 'pos' cuz temp is at head intially and moving 1-by-1 so when we get the (count==pos), temp is at pos, this pointing (STARTNODE = TEMP) to make a start node of cycle
            }
            temp = temp.next;
            count++;
        }
        //temp will stop at last node becasue while will stop once temp is at last
        temp.next = startNode; // connect last node to startNode to form cycle
    }
}
public class RemoveCycle {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

        ll.makeCycle(2);         // Create a cycle at node with value 3 (pos = 2)
        ll.removeCycle();        // Detects and removes the cycle
        ll.print();              // Now prints normally without infinite loop
    }
}
