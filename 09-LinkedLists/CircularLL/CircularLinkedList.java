class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class CircularLinkedList {
    Node last;

    // Add to empty list
    Node addToEmpty(int data) {
        if (last != null) return last;

        Node newNode = new Node(data);
        newNode.next = newNode;  // Point to itself
        last = newNode;
        return last;
    }

    // Insert at beginning
    Node insertAtBeginning(int data) {
        if (last == null) return addToEmpty(data);

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        return last;
    }

    // Insert at end
    Node insertAtEnd(int data) {
        if (last == null) return addToEmpty(data);

        Node newNode = new Node(data);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        return last;
    }

    // Delete a node by value
    Node delete(int key) {
        if (last == null) return null;

        Node curr = last.next, prev = last;

        // Single node
        if (curr == last && curr.data == key) {
            last = null;
            return null;
        }

        // Traverse to find node
        do {
            if (curr.data == key) {
                if (curr == last) last = prev;
                prev.next = curr.next;
                return last;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != last.next);

        System.out.println("Value not found.");
        return last;
    }

    // Print the list
    void traverse() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = last.next;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.last = cll.addToEmpty(10);
        cll.insertAtBeginning(5);
        cll.insertAtEnd(15);
        cll.insertAtEnd(20);

        cll.traverse(); // 5 -> 10 -> 15 -> 20 -> (back to head)

        cll.delete(10);
        cll.traverse(); // 5 -> 15 -> 20 -> (back to head)
    }
}
