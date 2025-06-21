import java.util.*;

public class FibonacciIterative {

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0;
        int prev1 = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
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
