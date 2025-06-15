import java.util.*;

public class SumNnatural {

    public static int Nat(int n) {
        if (n == 1) {
            return 1; // base case because sum of 1 natural number will be 1 only
        }
        return n + Nat(n - 1); // recursive case till it hits base case and then sums while unwinding the call stack
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num to get sum of natural numbers: ");
        int num = sc.nextInt();

        int result = Nat(num);
        System.out.println("Sum of first " + num + " natural numbers is: " + result);

        sc.close();
    }
}
