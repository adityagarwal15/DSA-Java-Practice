package Stuck;
import java.util.*;

public class ReverseNumber {

    public static int Rev(int num){
        int reversed = 0;
        while(num>0){
            int lastDigit = num%10;
            reversed = reversed * 10 + lastDigit;
            num = num/10;
        }
        return reversed;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the number: ");
        int num = sc.nextInt();

        int result = Rev(num);
        System.out.print("reversed number is: " + result);
        sc.close();

    }
}
