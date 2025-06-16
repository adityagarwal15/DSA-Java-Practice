import java.util.*;

public class Fibonacci {

    public static void printFibo(int first, int second, int count, int n) {
        if (count == n) {
            return; // base case
        }

        int sum = first + second;
        System.out.print(sum + " ");
        printFibo(second, sum, count + 1, n); // recursive call
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many Fibonacci numbers to print: ");
        int n = sc.nextInt();

        // Starting values of Fibonacci
        System.out.print("0 1 ");
        printFibo(0, 1, 2, n);

        sc.close();
    }
}
