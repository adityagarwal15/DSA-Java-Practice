import java.util.*;

public class LonelyNum {

    public static ArrayList<Integer> findLonely(ArrayList<Integer> list) {
        Collections.sort(list); // Step 1: Sort the list

        ArrayList<Integer> result = new ArrayList<>();
        int n = list.size();

        for (int i = 0; i < n; i++) {
            int curr = list.get(i);

            // Check if curr appears only once
            boolean isUnique = 
                (i == 0 || !list.get(i - 1).equals(curr)) && 
                (i == n - 1 || !list.get(i + 1).equals(curr));

            // Check if curr-1 and curr+1 are not in the list (as neighbors)
            boolean hasNoNeighbors = 
                (i == 0 || list.get(i - 1) != curr - 1) && 
                (i == n - 1 || list.get(i + 1) != curr + 1);

            if (isUnique && hasNoNeighbors) {
                result.add(curr);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        System.out.print("Enter elements: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        ArrayList<Integer> lonely = findLonely(list);
        System.out.println("Lonely numbers: " + lonely);
    }
}
