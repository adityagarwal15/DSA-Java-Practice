import java.util.*;

public class PrintPairs {

    // Method to print all pairs from the array
    public static void Print(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int secondPair = numbers[j];
                System.out.println("(" + current + ", " + secondPair + ")");
            }
        }
    }

    // we are printing everything in the method itself because this is eassier
    // if we want to store and return then we have to use Arrayslists

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        Print(numbers);
    }
}
