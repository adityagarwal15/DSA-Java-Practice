package Functions;
import java.util.*;

public class PrintPrimesRange {

    public static void printPrimesInRange(int a, int b) {
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) { //check if the prime is true or false
                System.out.println(i);  // here it prints if it is true
            }
        }
    }

    public static boolean isPrime(int n) {     //fnc to check if number is a prime
        if (n <= 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting number: ");
        int a = sc.nextInt();

        System.out.print("Enter ending number: ");
        int b = sc.nextInt();

        System.out.println("Prime numbers between " + a + " and " + b + " are:");
        printPrimesInRange(a, b);

        sc.close();
    }
}
