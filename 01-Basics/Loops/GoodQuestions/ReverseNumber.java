package Loops.GoodQuestions;
import java.util.*;

public class ReverseNumber {
    // Print reverse of a number using for loop
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        // System.out.print("Reversed digits: ");
        // for (; n > 0; n = n / 10) {
        //     System.out.print(n % 10);
        // }

         System.out.print("Reversed number: ");
        while (n > 0) {
            System.out.print(n % 10); // Print last digit
            n = n / 10;               // Remove last digit
        }

        sc.close();
    }
}
