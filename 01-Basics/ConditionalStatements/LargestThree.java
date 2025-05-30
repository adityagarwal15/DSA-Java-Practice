package ConditionalStatements;
import java.util.*;

public class LargestThree {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your number1: ");
        int a = sc.nextInt();

        System.out.println("Enter your number2: ");
        int b = sc.nextInt();

        System.out.println("Enter your number3: ");
        int c = sc.nextInt();

        if (a >= b && a >= c) {
            System.out.println("number1 is greatest or equal to others");
        } else if (b >= a && b >= c) {
            System.out.println("number2 is greatest or equal to others");
        } else {
            System.out.println("number3 is greatest");
        }

        sc.close();
    }
}
