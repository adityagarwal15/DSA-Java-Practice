import java.util.*;

public class PrintXpowN {

    // Recursive function to calculate num^power
    public static int getpow(int num, int power) {
        if (power == 0) {
            return 1; // base case: anything raised to 0 is 1
        }
        return num * getpow(num, power - 1); // recursive case
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

        int result = getpow(num, power);
        System.out.println(num + " raised to the power " + power + " is: " + result);

        sc.close();
    }
}
