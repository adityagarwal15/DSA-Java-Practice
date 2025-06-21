import java.util.*;

public class SumNnatural {

    // First Recursive Approach (Top-down)
    // Recursively calculates n + (n-1) + ... + 1
    public static int Nat(int n) {
        // Base case: sum of first 1 number is 1
        if (n == 1) {
            return 1;
        }

        // Recursive case: add current number and recurse on n-1
        return n + Nat(n - 1);
    }

    // Second Recursive Approach (Cleaner)
    // Starts from 1, goes till n and adds count + count+1 + ... + n
    public static int Natural(int count, int n) {
        // Base case: if count exceeds n, stop recursion and return 0
        if (count > n) {
            return 0;
        }

        // Recursive case: add current count and recurse with count+1
        return count + Natural(count + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🔸 Input
        System.out.print("Enter num to get sum of natural numbers: ");
        int num = sc.nextInt();

        // 🔹 Using first approach
        int result = Nat(num);
        System.out.println("Sum of first " + num + " natural numbers (Top-down): " + result);

        // 🔹 Using second approach (Clean and Intuitive)
        int res = Natural(1, num);  // Start from 1, go up to num
        System.out.println("Sum of first " + num + " natural numbers (Bottom-up): " + res);

        sc.close();
    }
}
