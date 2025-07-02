import java.util.*;

public class LonelyNum {

    // Function to find and return all lonely numbers in the list
    public static ArrayList<Integer> findLonely(ArrayList<Integer> list) {

        // Step 1: Sort the list so that all duplicates and neighbors are adjacent.
        // Sorting helps in checking both the uniqueness and adjacency conditions easily.
        Collections.sort(list);

        ArrayList<Integer> result = new ArrayList<>();
        int n = list.size();

        // Step 2: Traverse through the sorted list to check each number
        for (int i = 0; i < n; i++) {
            int curr = list.get(i); // current number to check

            // Step 3: Check if the current number is unique (i.e., appears only once)
            // For uniqueness, we check two things:
            // a) It's not equal to the previous number (if any)
            // b) It's not equal to the next number (if any)
            // If we're at the start (i == 0), no need to check left side
            // If we're at the end (i == n-1), no need to check right side
            boolean isUnique = 
                (i == 0 || !list.get(i - 1).equals(curr)) && 
                (i == n - 1 || !list.get(i + 1).equals(curr));

            // Step 4: Check if the current number has no neighbors (i.e., curr - 1 or curr + 1)
            // Again, use sorted list property to only check adjacent values
            // Example: If curr = 8, we don't want 7 or 9 to be next to it in sorted list
            boolean hasNoNeighbors = 
                (i == 0 || list.get(i - 1) != curr - 1) && 
                (i == n - 1 || list.get(i + 1) != curr + 1);

            // Step 5: If both conditions are true, add to result list
            if (isUnique && hasNoNeighbors) {
                result.add(curr);
            }
        }

        // Step 6: Return the list of all lonely numbers found
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of elements in the ArrayList
        System.out.print("Enter size: ");
        int n = sc.nextInt();

        // Input: Elements of the ArrayList
        System.out.print("Enter elements: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Call function and print the result
        ArrayList<Integer> lonely = findLonely(list);
        System.out.println("Lonely numbers: " + lonely);
    }
}
