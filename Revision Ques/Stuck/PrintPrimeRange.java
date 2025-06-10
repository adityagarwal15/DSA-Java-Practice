package Stuck;
import java.util.*;

public class PrintPrimeRange {

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        //true is global, added conditions for false above
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting range: ");
        int n = sc.nextInt();

        System.out.print("Enter ending range: ");
        int m = sc.nextInt();

        if (n > m) {
            System.out.println("Invalid range. Starting value cannot be greater than ending value.");
        } else if (n == m) {
            System.out.println("Starting and ending range are the same. Nothing to display.");
        } else {
            System.out.println("Prime numbers between " + n + " and " + m + " are:");
            for (int i = n; i <= m; i++) {
                if (isPrime(i)) {
                    System.out.print(i + " ");
                }
            }
        }

        sc.close();
    }
}
