package Functions.GoodQuestions;
import java.util.*;

public class SumDigits {

    public static int SumDig(int num){
        int sum = 0;
        while(num>0){
            int lastDigit = num % 10;
            sum = sum + lastDigit;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number: ");
        int  num = sc.nextInt();

        int result = SumDig(num);
        System.out.println("Sum of the digits of " + num + " is: " + result);
        sc.close();
    }
}
