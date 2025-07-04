// Node class for DLL
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

// Main Doubly Linked List class
public class DoubleList {
    Node head;
    Node tail;
    int size = 0;

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Insert at specific position (0-based)
    public void insertAtPosition(int data, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("❌ Invalid position.");
            return;
        }

        if (pos == 0) {
            insertAtHead(data);
            return;
        }

        if (pos == size) {
            insertAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;

        size++;
    }

    // Delete from head
    public void deleteHead() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Delete from tail
    public void deleteTail() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Delete at position (0-based)
    public void deleteAtPosition(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("❌ Invalid position.");
            return;
        }

        if (pos == 0) {
            deleteHead();
            return;
        }

        if (pos == size - 1) {
            deleteTail();
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--;
    }

    // Delete by value (first occurrence)
    public void deleteByValue(int data) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == data) {
                if (temp == head) {
                    deleteHead();
                } else if (temp == tail) {
                    deleteTail();
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    size--;
                }
                return;
            }
            temp = temp.next;
        }

        System.out.println("❌ Value not found.");
    }

    // Search for a value
    public boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    // Reverse the DLL
    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            // Swap next and prev
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        // Swap head and tail
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Get current size
    public int getSize() {
        return size;
    }

    // Print forward
    public void printForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Print backward
    public void printBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}
public class Basics {
    public static void main(String[] args) {
        DoubleList dll = new DoubleList();

        // Insertions
        dll.insertAtHead(30);
        dll.insertAtHead(20);
        dll.insertAtTail(40);
        dll.insertAtPosition(25, 2); // Between 20 and 30

        System.out.println("🔁 Forward:");
        dll.printForward();  // 20 ⇄ 30 ⇄ 25 ⇄ 40 ⇄ null

        System.out.println("🔁 Backward:");
        dll.printBackward(); // 40 ⇄ 25 ⇄ 30 ⇄ 20 ⇄ null

        // Deletions
        dll.deleteAtPosition(2);   // deletes 25
        dll.deleteByValue(20);     // deletes 20
        dll.deleteTail();          // deletes 40

        System.out.println("📉 After deletions:");
        dll.printForward(); // Should show 30 ⇄ null

        // Reverse
        dll.insertAtTail(50);
        dll.insertAtTail(60);
        dll.reverse();

        System.out.println("🔄 After Reversal:");
        dll.printForward(); // 60 ⇄ 50 ⇄ 30 ⇄ null

        // Search
        System.out.println("🔍 Search 50: " + dll.search(50)); // true
        System.out.println("🔍 Search 99: " + dll.search(99)); // false

        // Size
        System.out.println("📏 Size: " + dll.getSize()); // 3
    }
}
