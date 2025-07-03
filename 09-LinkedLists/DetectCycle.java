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

    //method to add elem from last(effecient way)
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    //method to print
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public boolean checkCycle(){
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next!=null){

            //always first move then check if cycle detection (IMP) 
            //cuz if checked at initial stage then obviously they are at same point
            slow = slow.next;
            fast = fast.next.next;

            //now check
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

}
    public class DetectCycle {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        System.out.print("is cycle there? " + ll.checkCycle());



    }
}
