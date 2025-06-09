import java.util.*;

public class TwoSum {

    public static int Sum(int a, int b){
        return a+b;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number 1: ");
        int a = sc.nextInt();
        System.out.print("enter number 2: ");
        int b = sc.nextInt();

        int result = Sum(a,b);
        System.out.print("sum is: " + result);

        sc.close();
    }
}
