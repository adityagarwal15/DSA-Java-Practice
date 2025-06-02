import java.util.*;

public class PrintPairs {

    // Method to print all pairs from the array
    public static void Print(int numbers[]) {
        int totalPairs = 0; // to count while printing

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int secondPair = numbers[j];
                System.out.print("(" + current + ", " + secondPair + ")");
                totalPairs++;
            }
            System.out.println();
        }

        System.out.println("Total pairs by counting: " + totalPairs);

        // Using n(n-1)/2 formula
        int n = numbers.length;
        int formulaPairs = (n * (n - 1)) / 2;
        System.out.println("Total pairs using formula: " + formulaPairs);
    }

    // we are printing everything in the method itself because this is eassier
    // if we want to store and return then we have to use Arrayslists

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        Print(numbers);
    }
}
