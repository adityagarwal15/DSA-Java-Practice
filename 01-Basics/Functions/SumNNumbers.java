package Functions;
import java.util.*;

public class SumNNumbers {
    
    public static int Sum(int n){
        int sum = 0;
        for(int i = 0; i<=n; i++){
            sum = sum + i;  
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.print("enter number of natural numbers: ");
        int n = sc.nextInt();

        int result = Sum(n);
        System.out.print("sum: " + result);

        sc.close();
    }
}
