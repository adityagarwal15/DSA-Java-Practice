import java.util.PriorityQueue;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeKSortedLists {

    public static Node mergeKLists(Node[] lists) {
        // Min-heap that compares nodes by data
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Step 1: Add the first node of each list into the heap
        for (Node node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Step 2: Dummy node to build result
        Node dummy = new Node(0);
        Node current = dummy;

        // Step 3: Process the heap
        while (!minHeap.isEmpty()) {
            Node smallest = minHeap.poll();     // Remove smallest node
            current.next = smallest;            // Append to result list
            current = current.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);   // Add next node from the same list
            }
        }

        return dummy.next;
    }

    // Utility function to print a linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    // Main method to test the function
    public static void main(String[] args) {
        // List 1: 1 -> 3 -> 7
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(7);

        // List 2: 2 -> 4 -> 8
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(8);

        // List 3: 9 -> 10 -> 11
        Node list3 = new Node(9);
        list3.next = new Node(10);
        list3.next.next = new Node(11);

        Node[] lists = {list1, list2, list3};

        Node mergedHead = mergeKLists(lists);
        System.out.println("Merged Sorted List:");
        printList(mergedHead);
    }
}
