import java.util.*;

public class MaxLengthChainOfPairs {

    // Function to find the maximum number of pairs that can form a valid chain
    public static int maxChainLength(int[][] pairs) {
        // Step 1: Sort all pairs based on their end time (second element of each pair)
        // This ensures we always pick the pair that finishes earliest
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1; // At least one pair (the first one) can be picked
        int lastEnd = pairs[0][1]; // End time of the last selected pair

        // Step 2: Loop through remaining pairs
        // Select a pair only if its start time is greater than the end time of the last selected pair
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {
                count++;
                lastEnd = pairs[i][1]; // Update last selected end time
            }
        }

        // Return the total number of pairs in the longest chain
        return count;
    }

    public static void main(String[] args) {
        // Input array of pairs
        int[][] pairs = { {5, 24}, {15, 25}, {27, 40}, {50, 60} };

        // Call the function and print the result
        int result = maxChainLength(pairs);
        System.out.println("Maximum length of chain = " + result);
    }
}
