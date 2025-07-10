import java.util.*;

public class IndianCoins {

    // Function to find the minimum number of coins to make a given amount
    public static void minCoins(int[] coins, int amount) {
        // Step 1: Sort coins in descending order so we try bigger coins first
        Arrays.sort(coins);
        int n = coins.length;

        System.out.println("Coins used:");
        int count = 0;

        // Step 2: Traverse from largest coin to smallest
        for (int i = n - 1; i >= 0; i--) {
            int coin = coins[i];

            // Use this coin as many times as possible
            while (amount >= coin) {
                amount -= coin;
                count++;
                System.out.print(coin + " ");
            }

            // Stop if amount is fulfilled
            if (amount == 0) break;
        }

        System.out.println("\nTotal coins used = " + count);
    }

    public static void main(String[] args) {
        // List of Indian coin denominations
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // Amount to be formed
        int amount = 1210;

        // Call the function
        minCoins(coins, amount);
    }
}
