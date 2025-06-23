import java.util.*;

public class TilingProb {

    // Amazon PYQ: Count the number of ways to tile a 2 x n floor using 2 x 1 tiles
    public static int getTile(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1; 
            // Explanation:
            // n = 0 → 1 way (do nothing)
            // n = 1 → 1 way (place 1 tile vertically)
        }

        // Recursive cases:

        // Option 1: Place tile vertically (2 x 1) → reduces problem to size (n-1)
        int vertical = getTile(n - 1);

        // Option 2: Place two tiles horizontally (occupying 2 units of length) → reduces to (n-2)
        int horizontal = getTile(n - 2);

        // Total ways = ways by placing vertical + ways by placing horizontal
        return vertical + horizontal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length (n) of the floor for (2 x n): ");
        int n = sc.nextInt();

        int result = getTile(n);  // Call the function with given input
        System.out.println("Number of ways to tile a 2 x " + n + " floor is: " + result);

        sc.close();
    }
}
