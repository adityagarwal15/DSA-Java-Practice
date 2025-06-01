package Functions;
import java.util.*;

public class CheckIsEven {

    // Method 1 (Commented out) - prints inside method (not recommended for MAANG)
    /*
    public static void isEven(int num) {
        if (num % 2 == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        isEven(num);

        sc.close();
    }
    */

    // Method 2 - returns boolean, better for MAANG and real-world use
    
    public static boolean isEven(int num) {
        return num % 2 == 0; //return true if divisible by 2
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        if (isEven(num)) { //check if number is true then print even
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }

        sc.close();
    }
}
