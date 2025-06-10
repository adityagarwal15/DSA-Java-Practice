package StuckBasic;
import java.util.*;

public class Factorial {

    public static int getFactorial(int num){
        int fact = 1;
        for(int i=1;i<=num;i++){
            fact *= i;
        }
        return fact;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number: ");
        int num = sc.nextInt();

        int result = getFactorial(num);
        System.out.print("factorial of a number is: " + result);

        sc.close();
    }
}
