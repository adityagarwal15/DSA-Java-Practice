import java.util.*;

public class Factorial {

    // Recursive function to find factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) {  // base case
            return 1;
        }
        return n * factorial(n - 1);  // recursive call once it hits base case then starts multiplying
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to find factorial: ");
        int n = sc.nextInt();

        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);

        sc.close();
    }
}
