import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList of Integer type
        ArrayList<Integer> list = new ArrayList<>();

        // Step 2: Add elements to the list
        list.add(10);        // Index 0
        list.add(20);        // Index 1
        list.add(30);        // Index 2
        list.add(1, 100);    // Insert 100 at index 1, shifts others to the right

        // Step 3: Print entire list using built-in toString()
        System.out.println("List is: " + list);  // Output: [10, 100, 20, 30]

        // Step 4: Print elements using index-based loop
        System.out.print("Elements using for loop: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(); // for newline

        // Step 5: Access element at a specific index
        System.out.println("Element at index 0: " + list.get(0));  // Output: 10

        // Step 6: Update element at a specific index
        list.set(1, 25);  // Replaces 100 with 25 at index 1 → list becomes [10, 25, 20, 30]

        // Step 7: Remove element at a specific index
        list.remove(2);   // Removes element at index 2 (which is 20) → list becomes [10, 25, 30]

        // Step 8: Check and print size of the list
        System.out.println("Size of list: " + list.size());  // Output: 3

        // Step 9: Loop through list using enhanced for-each loop
        System.out.println("Elements using for-each loop:");
        for (int num : list) {
            System.out.println(num);
        }

        // Step 10: Check if a value exists in the list
        System.out.println("List contains 10? " + list.contains(10));  // Output: true
    }
}
