package Functions;
import java.util.*;

public class AverageThree {

    public static int avg(int a, int b, int c){
        int average = (a+b+c)/3;
        return average;
    }

    public static void main(String[]  args){

        Scanner sc = new Scanner(System.in);
        
        System.out.print("enter number 1: ");
        int a = sc.nextInt();

        System.out.print("enter number 2: ");
        int b = sc.nextInt();

        System.out.print("enter number 3: ");
        int c = sc.nextInt();

        int result = avg(a,b,c);
        System.out.print("the avergae of three numbers is: " + result);


        sc.close();
    }
    
}
