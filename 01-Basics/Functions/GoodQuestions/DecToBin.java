package Functions.GoodQuestions;
import java.util.*;

public class DecToBin {

    public static int Bin(int n){
        int pow = 0;
        int bin_result = 0;

        while(n > 0){
            int rem = n % 2;
            bin_result += rem * (int)Math.pow(10, pow);  // Cast to int
            pow++;
            n = n / 2;
        }

        return bin_result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the decimal number: ");
        int num = sc.nextInt();

        int result = Bin(num);
        System.out.println("The binary is: " + result);

        sc.close();
    }
}
