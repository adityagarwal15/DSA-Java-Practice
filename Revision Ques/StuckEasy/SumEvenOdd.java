package StuckEasy;
import java.util.*;

public class SumEvenOdd {
    //wap that reads a set of integer and then prints the sum of even and odd integers

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int evenSum = 0;
        int oddSum = 0;

        System.out.println("Enter integers (type -1 to stop):");

        while (true) {
            int num = sc.nextInt();

            if (num == -1) {
                break; //value to come out of the loop
            }

            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }

        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);
        
        sc.close();
    }
}

