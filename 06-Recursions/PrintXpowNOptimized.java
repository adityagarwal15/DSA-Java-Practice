import java.util.*;

public class PrintXpowNOptimized {

    // Optimized recursive power function using Exponentiation by Squaring
    public static long getpow(int num, int power) {
        if (power == 0) return 1;              // Base case: num^0 = 1
        if (power == 1) return num;            // Base case: num^1 = num

        long half = getpow(num, power / 2);    // Divide the power by 2 --> num^pow/2

        if (power % 2 == 0) {
            return half * half;               // Even power: x^n = (x^(n/2))^2
        } else {
            return half * half * num;         // Odd power: x^n = (x^(n/2))^2 * x
        }
    }

    
    /* VISUAL TRACE

    Let’s say: getpow(2, 5) → should return 32.

            getpow(2, 5)
        → half = getpow(2, 2)    // since 5/2 = 2
            → half = getpow(2, 1) → returns 2
            → half * half = 2 * 2 = 4
        → power is odd → return 4 * 4 * 2 = 32
     */


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base number: ");
        int num  = sc.nextInt();

        System.out.print("Enter power: ");
        int power = sc.nextInt();

        if (power < 0) {
            System.out.println("Negative powers are not supported in this version.");
        } else {
            long result = getpow(num, power);
            System.out.println(num + " raised to the power " + power + " is: " + result);
        }

        sc.close();
    }
}


