package StuckBasic;
import java.util.*;

public class Palindrome {

    public static void checkPalindrome(int n){
        int original = n;
        int reverse = 0;
        while(n>0){
            int lastDigit = n%10;
            reverse = reverse * 10 + lastDigit;
            n = n/10;
        }

        if(original == reverse){
            System.out.print("palindrome");
        }
        else{
            System.out.print("not a palindrome");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number: ");
        int n = sc.nextInt();

        checkPalindrome(n);

        sc.close();
    }
}
