package Functions.GoodQuestions;
import java.util.*;

public class BinaryToDecimal {

    public static int BinToDec(int num) {
        int dec = 0;
        int pow = 0;

        //great logic for while condition(num>0) --> leading zeroes are not considered and last digts are removed for 1 in initial position will always be there until its last.

        while (num > 0) {
            int lastDigit = num % 10;  // to get last digit of a number
            dec += lastDigit * Math.pow(2, pow);
            pow++;
            num = num / 10; // move to next digit //remove last digit 
        }

        return dec;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary number: ");
        int num = sc.nextInt();

        int result = BinToDec(num);
        System.out.println("Decimal: " + result);

        sc.close();
    }
}
