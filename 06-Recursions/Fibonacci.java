// Program to print the first 'n' Fibonacci numbers using recursion

import java.util.*;

public class Fibonacci {

    // Recursive function to print Fibonacci numbers
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

        // Input validation
        if (n < 2) {
            System.out.println("Invalid input, minimum 2 numbers should be there");
        } else {
            // Starting values of Fibonacci series
            System.out.print("0 1 ");
            printFibo(0, 1, 2, n);
        }

        sc.close();
    }
}
