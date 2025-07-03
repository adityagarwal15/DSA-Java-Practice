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

    // Add node at the end (efficient way)
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Print linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse the list from given node
    public Node reverse(Node head) { // taking a node as input
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // New head of the reversed list 
    }

    // Check if the linked list is a palindrome
    public boolean isPalindrome() {
        // Step 1: Handle edge cases like list is 0 || 1 element 
        if (head == null || head.next == null) {
            return true;
        }

        // Step 2: Find middle using slow and fast pointers
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node secondHalfStart = reverse(slow); //stores the head of reveresed list
        Node firstHalfStart = head;
        Node secondHalfCopy = secondHalfStart; // to restore list later

        // Step 4: Compare both halves
        while (secondHalfStart != null) { //why secondHalfStart? -> cuz we want to compare the second half(reversed) w the first one, not the entire list
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }

        // Step 5: Optional - Restore original list
        reverse(secondHalfCopy);

        return true;
    }
}

public class Palindrome {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Add elements
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(2);
        ll.add(1);

        ll.print();

        // Check if palindrome
        System.out.println("Is Palindrome? " + ll.isPalindrome());
    }
}
