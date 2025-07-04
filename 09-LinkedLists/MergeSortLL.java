// Node class for Linked List
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List class with Merge Sort implementation
class LinkedList {
    Node head;

    // ✅ Add element to the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // ✅ Print the entire linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 🔸 Step 1: Get the middle node of the list
    // TIP: Use slow and fast pointer method (Tortoise-Hare)
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next; // start fast one step ahead for even-sized lists

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // returns the middle node
    }

    // 🔸 Step 2: Merge two sorted lists into a single sorted list
    // Very similar to the merge step in merge sort (array version)
    private Node merge(Node left, Node right) {
        Node dummy = new Node(-1); // Dummy node to simplify code
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next; // move the tail forward
        }

        // Attach the remaining part (whichever is not null)
        tail.next = (left != null) ? left : right;

        return dummy.next; // return merged list starting after dummy
    }

    // 🔸 Step 3: Recursive Merge Sort on Linked List
    public Node mergeSort(Node head) {
        // ✅ Base case: 0 or 1 element list is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the mid-point and split list
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null; // break the list into two halves

        // Step 2: Recursively sort both halves
        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        // Step 3: Merge the sorted halves and return
        return merge(left, right);
    }

    // 🚀 Call this method to sort the linked list using merge sort
    public void sort() {
         head = mergeSort(head); // paased my org. unsorted lists head, and updated the head by haed=mergeSort(head)
    }
}
public class MergeSortLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(4);
        ll.add(2);
        ll.add(5);
        ll.add(1);
        ll.add(3);

        System.out.println("Original List:");
        ll.print();

        ll.sort(); // 🔄 Sort the linked list using merge sort

        System.out.println("Sorted List:");
        ll.print();
    }
}
