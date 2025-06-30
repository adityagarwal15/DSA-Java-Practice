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

        // Step 2: Initialize each row(list)
        for (int i = 0; i < rows; i++) {
            list.add(new ArrayList<>());  // add an empty row
        }

        // Step 3: Fill data row-wise
        System.out.println("Enter elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = sc.nextInt();
                list.get(i).add(val);  //.get() is to refer the row ith and .add is to add the val in each row
            }
        }

        // Step 4: Print the 2D ArrayList
        System.out.println("Your 2D ArrayList:");
        for (ArrayList<Integer> row : list) {
            System.out.println(row);
        }
    }
}
