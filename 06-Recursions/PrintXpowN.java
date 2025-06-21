import java.util.*;

public class PrintXpowN {

    // Recursive function to calculate num^power
    public static int getpow(int num, int power) {

         /* ---------- base cases ---------- */
        if (power == 0) {           // anything^0 = 1
            return 1; 
        }
        if (power == 1) {           // anything^1 = itself
            return num;
        }

          /* ---------- recursive step ---------- */
        return num * getpow(num, power - 1);   // keep reducing the exponent
    }

//     getpow(3, 4)
//      = 3 * getpow(3, 3)
//      = 3 * (3 * getpow(3, 2))
//      = 3 * (3 * (3 * getpow(3, 1)))
//      = 3 * (3 * (3 * (3 * getpow(3, 0))))
//      = 3 * (3 * (3 * (3 * 1))) ← base case
//      = 3 * (3 * (3 * 3))
//      = 3 * (3 * 9)
//      = 3 * 27
//      = 81


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base number: ");
        int num  = sc.nextInt();

        System.out.print("Enter power: ");
        int power = sc.nextInt();

         /* guard against negative exponents for this simple version */
        if (power < 0) {
            System.out.println("Negative powers not handled in this version.");
            sc.close();
            return;
        }
        
        int result = getpow(num, power);
        System.out.println(num + " raised to the power " + power + " is: " + result);

        sc.close();
    }
}
