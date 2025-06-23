import java.util.*;

public class FriendPair {

    // Recursive function to count the number of ways to pair up friends
    public static int pairs(int n) {
        // 🔹 Base cases:
        if (n == 0 || n == 1) return 1;  // Only 1 way to arrange 0 or 1 friend
        if (n == 2) return 2;            // 2 ways: (1-2) or (1)(2)

        // 🔹 Recursive cases:

        // Option 1: Friend stays single → recursively pair (n - 1) friends
        int single = pairs(n - 1);

        // Option 2: Friend pairs with one of (n - 1) others → 
        //           (n - 1) choices * ways to pair the rest (n - 2) friends

        // current friend pairs with (n-1) others, and we recursively pair remaining (n-2) friends.
        int pair = (n - 1) * pairs(n - 2);

        // Total ways = ways of staying single + ways of pairing
        return single + pair;
    }

    /*
        🔁 Recursion Breakdown Example for n = 4

        pair(4)
        = pair(3) + 3 * pair(2)
        = (pair(2) + 2 * pair(1)) + 3 * pair(2)
        = ((2) + 2 * 1) + 3 * 2
        = (2 + 2) + 6
        = 4 + 6 = 10
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of friends (n): ");
        int n = sc.nextInt();

        int result = pairs(n);
        System.out.println("Total number of ways to pair " + n + " friends: " + result);

        sc.close();
    }
}
