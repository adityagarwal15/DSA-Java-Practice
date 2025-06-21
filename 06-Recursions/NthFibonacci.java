import java.util.*;

public class NthFibonacci {

    // Function to return nth Fibonacci number
    public static int fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive case
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n to find nth Fibonacci number: ");
        int n = sc.nextInt();

        int result = fib(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);

        sc.close();
    }
}
