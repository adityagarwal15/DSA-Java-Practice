package Functions.GoodQuestions;
import java.util.*;

public class PalindromeCheck {

    public static boolean isPalindrome(int num) {
        int original = num;
        int reverse = 0;

        while (num > 0) {        // same as reverse a number
            int lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            num = num / 10;
        }

        return original == reverse;  // check if original  = reverse
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome.");
        } else {
            System.out.println(num + " is not a palindrome.");
        }
        sc.close();
    }
}
