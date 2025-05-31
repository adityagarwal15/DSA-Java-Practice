package Functions;
import java.util.*;


public class ProductTwo {
    public static int Product(int a, int b){
    int product = a * b;
    return product;
}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number1: ");
        int a =sc.nextInt();
         System.out.print("enter number2: ");
        int b = sc.nextInt();

        int result = Product(a,b);
        System.out.println("result of input numbers is: " + result);

        int res = Product(10,20);
         System.out.println("result of assigned numbers is: " + res);
            sc.close();
    }
}
