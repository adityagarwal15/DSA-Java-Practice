package Loops.GoodQuestions;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any positive integer: ");
        int num = sc.nextInt();
        int fact = 1; // To hold factorial

        for (int i = 1; i <= num; i++) {
            fact *= i;
        }

        System.out.println("Factorial: " + fact);
        sc.close();
    }
}
