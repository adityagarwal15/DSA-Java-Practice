package OneGo;
import java.util.*;

public class LargestThree {

    public static int Compare(int a, int b, int c){

        //remember to put all equal case
        if(a == b && b == c){
            System.out.print("all numbers are equal");
            return a;
        }
        else if(a>=b && a>=c){
            System.out.println("A is largest");
            return a;
        }
        else if(b>=a && b>=c){
            System.out.println("B is largest");
            return b;
        }
        else{
            System.out.println("C is largest");
            return c;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the number a: ");
        int a = sc.nextInt();

        System.out.print("enter the number b: ");
        int b = sc.nextInt();

        System.out.print("enter the number c: ");
        int c = sc.nextInt();

        System.out.print(Compare(a,b,c));

        sc.close();
    }
}
