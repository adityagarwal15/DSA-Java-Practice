package OneGo;
import java.util.*;

public class SumNNatural {

    public static void Sum(int n){
        int sum=0;
        for(int i =1; i<=n; i++){
            sum += i;
        }
        System.out.print("sum is: " + sum);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter how many n natural numbers sum needed: ");
        int n = sc.nextInt();

        Sum(n);
        sc.close();
    }
}
