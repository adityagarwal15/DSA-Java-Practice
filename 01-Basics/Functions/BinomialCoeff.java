package Functions;
import java.util.*;

public class BinomialCoeff {

    public static int fact(int n){
        int f = 1;
        for(int i = 1; i <= n; i++){
            f = f * i;
        }
        return f;
    }

    public static int bio(int a, int r){   // a! / ( r! * (a-r)! )
        int a_fact = fact(a);
        int r_fact = fact(r);
        int ar_fact = fact(a - r);

        int result = a_fact / (r_fact * ar_fact);

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number a (n): ");
        int a = sc.nextInt();

        System.out.print("Enter the number r: ");
        int r = sc.nextInt();

        int result = bio(a, r);
        System.out.println("Binomial Coefficient C(" + a + ", " + r + ") = " + result);
        sc.close();
    }
}
