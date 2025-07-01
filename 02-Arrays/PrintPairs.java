import java.util.*;

public class PrintPairs {

    // Method to print all unique pairs in the array
    public static void Print(int numbers[]) {
        int totalPairs = 0; // Keeps track of the number of pairs printed

        // Outer loop selects the first number in the pair
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];

            // Inner loop selects the second number in the pair (after current)
            for (int j = i + 1; j < numbers.length; j++) {
                int secondPair = numbers[j];

                // Print the pair
                System.out.print("(" + current + ", " + secondPair + ") ");
                totalPairs++;
            }
            // Move to the next line after each row of pairs
            System.out.println();
        }

        // Print total number of pairs counted during execution
        System.out.println("Total pairs by counting: " + totalPairs);

        // Calculate expected number of pairs using n(n-1)/2 formula
        int n = numbers.length;
        int formulaPairs = (n * (n - 1)) / 2;
        System.out.println("Total pairs using formula: " + formulaPairs);
    }

    // We are printing all pairs inside the method for simplicity.
    // If we wanted to return pairs instead of printing, we could use an ArrayList or array of arrays.
    
    public static void main(String[] args) {
        // Sample input array
        int numbers[] = {2, 4, 6, 8, 10};

        // Call the method to print all pairs
        Print(numbers);
    }
}
