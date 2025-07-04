import java.util.LinkedList;

public class JavaCollection {
    public static void main(String[] args) {

        // Creating a LinkedList of integers
        LinkedList<Integer> ll = new LinkedList<>();

        // 1️⃣ Add elements
        ll.add(10);              // add at end
        ll.add(20);
        ll.add(30);
        ll.addFirst(5);          // add at beginning
        ll.addLast(40);          // add at end (same as add())

        // 2️⃣ Get elements
        System.out.println("First element: " + ll.getFirst());
        System.out.println("Last element: " + ll.getLast());
        System.out.println("Element at index 2: " + ll.get(2));

        // 3️⃣ Remove elements
        ll.remove();             // remove first
        ll.removeLast();         // remove last
        ll.remove(Integer.valueOf(20)); // remove by value
        ll.remove(1);            // remove by index

        // 4️⃣ Search
        System.out.println("Contains 30? " + ll.contains(30));
        System.out.println("Index of 3: " + ll.indexOf(3));

        // 5️⃣ Size and isEmpty
        System.out.println("Size: " + ll.size());
        System.out.println("Is empty? " + ll.isEmpty());

        // 6️⃣ Print the list
        System.out.println("Final LinkedList: " + ll);

        // 7️⃣ Iterate
        System.out.print("Using for-each loop: ");
        for (int num : ll) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 8️⃣ Clear the list
        ll.clear();
        System.out.println("After clear: " + ll);
    }
}
