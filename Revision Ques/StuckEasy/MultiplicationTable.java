package StuckEasy;
import java.util.*;

public class MultiplicationTable {

    public static void table(int n){
        for(int i=1;i<=10;i++){
            int result = n * i;
            System.out.println(result + " "); //keep this inside loop 
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number to get table: ");
        int n = sc.nextInt();

       table(n);

        sc.close();
    }
}
