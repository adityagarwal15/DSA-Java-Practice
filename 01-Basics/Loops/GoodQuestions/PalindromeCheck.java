package Loops.GoodQuestions;

import java.util.*;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int original = num;
        int reversed = 0;

        // Reverse the number
        while (num > 0) {
            int digit = num % 10;        // get last digit
            reversed = reversed * 10 + digit; // append digit
            num = num / 10;              // remove last digit
        }

        // Check if original equals reversed
        if (original == reversed) {
            System.out.println("It's a palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }

        sc.close();
    }
}
