class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{

    Node head;
    Node tail;

    //method to add
    public void add(int data){

        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Detect and remove the cycle
    public void removeCycle() {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect cycle
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            System.out.println("No cycle detected.");
            return;
        }

        // Step 2: Find the starting node of the cycle
        slow = head;
        Node prev = null; // to track last node in the cycle

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Break the cycle
        prev.next = null;
        System.out.println("Cycle removed at node: " + slow.data);
    }


    //method to make a cycle
    public void makeCycle(int pos){

        Node temp = head;
        Node startNode = null;
        int count = 0;

        while(temp!=null){
            if(count == pos){
                startNode = temp; //save the node where cycle should begin
            }
            temp  = temp.next;
            count++;
        }

        temp.next = startNode;
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

        ll.makeCycle(3);  // create cycle at node 3
        ll.removeCycle(); // should remove the cycle
        ll.print();       // should print full list without looping
    }
}

