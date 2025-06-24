import java.util.*;

public class NumberToWords {

    // Array to map digits to words
    static String[] digitWords = {
        "zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine"
    };

    // Recursive function to print number in words
    public static void printWords(int num) {
        // Base case: if number becomes 0, stop
        if (num == 0) {
            return;
        }

        // Recursive call: process the left digits first, until it reaches base case
        printWords(num / 10);

        // Then print current (rightmost) digit, basically the last digit while unwinding stack
        int lastDigit = num % 10; //stores last digit when unwinding
        System.out.print(digitWords[lastDigit] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number (non-zero ending): ");
        int num = sc.nextInt();

        // Edge case: if number is 0
        if (num == 0) {
            System.out.println("zero");
        } else {
            System.out.print("Number in words: ");
            printWords(num);
        }

        sc.close();
    }
}
