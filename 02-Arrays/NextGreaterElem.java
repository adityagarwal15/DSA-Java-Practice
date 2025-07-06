import java.util.*;

public class NextGreaterElem {

    // Version 1: Brute Force with boolean
    public static void greaterWithBoolean(int[] input, int[] output) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (input[j] > input[i]) {
                    output[i] = input[j];
                    found = true;
                    break;
                }
            }
            if (!found) {
                output[i] = -1;
            }
        }
    }

    // Version 2: Brute Force without boolean
    public static void greaterWithoutBoolean(int[] input, int[] output) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            output[i] = -1; // Default to -1

            for (int j = i + 1; j < n; j++) {
                if (input[j] > input[i]) {
                    output[i] = input[j];
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        int input[] = {4, 5, 2, 25};
        int n = input.length;
        int output[] = new int[n];

        // Uncomment one of the below to test

        greaterWithBoolean(input, output);        // Brute force using boolean
        // greaterWithoutBoolean(input, output);  // Brute force without boolean

        System.out.print("Next Greater Elements: ");
        for (int val : output) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
