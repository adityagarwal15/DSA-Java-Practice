import java.util.*;

public class FindMax {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter size of the ArrayList: ");
        int n = sc.nextInt();

        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // Method 1: Manual way
        int maxManual = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (list.get(i) > maxManual) {
                maxManual = list.get(i);
            }
        }
        System.out.println("Maximum (manual method): " + maxManual);

        // Method 2: Using Collections.max()
        int maxBuiltIn = Collections.max(list);
        System.out.println("Maximum (Collections.max method): " + maxBuiltIn);

        // Method 3: Using Math.max()
        int maxMath = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxMath = Math.max(maxMath, list.get(i));
        }
        System.out.println("Maximum (Math.max method): " + maxMath);
    }
}
