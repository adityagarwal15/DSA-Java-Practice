import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Integer list sorting
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter size of the list: ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("Original list: " + list);

        // Ascending order
        Collections.sort(list);
        System.out.println("Sorted list (ascending): " + list);

        // Descending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorted list (descending): " + list);

        // String list sorting
        ArrayList<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Ankit");
        names.add("Maya");

        System.out.println("\nOriginal names list: " + names);

        // Sort alphabetically
        Collections.sort(names);
        System.out.println("Sorted names (alphabetical): " + names);

        // Sort in reverse alphabetical order
        Collections.sort(names, Collections.reverseOrder());
        System.out.println("Sorted names (reverse alphabetical): " + names);
    }
}
