import java.util.*;

public class MultiDimList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create outer ArrayList
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        // Step 2: Initialize each row (inner list)
        for (int i = 0; i < rows; i++) {
            list.add(new ArrayList<>());
        }

        // Step 3: Fill data row by row
        System.out.println("Enter elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = sc.nextInt();
                list.get(i).add(val); // get i-th row, add value to it
            }
        }

        // Step 4: Print the 2D ArrayList using enhanced for-each loop
        System.out.println("Your 2D ArrayList (for-each):");
        for (ArrayList<Integer> row : list) {
            System.out.println(row);
        }

        // Step 5: Print using traditional nested for loops
        System.out.println("\nYour 2D ArrayList (traditional loop):");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

        // Step 6: Accessing a specific element
        System.out.println("\nAccessing element at row 1, column 2:");
        if (rows > 1 && cols > 2) {
            System.out.println("Value: " + list.get(1).get(2));
        } else {
            System.out.println("Not enough rows or columns to access [1][2].");
        }

        // Step 7: Updating an element
        if (rows > 0 && cols > 1) {
            list.get(0).set(1, 99); // sets [0][1] to 99
            System.out.println("\nAfter updating [0][1] to 99:");
            System.out.println(list);
        }

        // Step 8: Removing an element from a row
        if (rows > 2 && !list.get(2).isEmpty()) {
            list.get(2).remove(0); // removes first element from row 2
            System.out.println("\nAfter removing first element from row 2:");
            System.out.println(list);
        }

        // Step 9: Removing an entire row
        if (rows > 1) {
            list.remove(1); // removes entire row 1
            System.out.println("\nAfter removing entire row 1:");
            System.out.println(list);
        }
    }
}
