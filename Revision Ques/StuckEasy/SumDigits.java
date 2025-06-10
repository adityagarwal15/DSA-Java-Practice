package StuckEasy;
import java.util.*;

public class SumDigits {

    public static int Sum(int n){
        int sum = 0;
        while(n > 0){
            int lastDigit = n % 10;
            sum = sum + lastDigit;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int result = Sum(n);
        System.out.print("result is: " + result);

        sc.close();
    }
}
