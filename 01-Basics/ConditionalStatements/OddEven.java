package ConditionalStatements;
import java.util.*;

public class OddEven {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number: ");
        int number = sc.nextInt();

        if(number%2 == 0){
            System.out.println("it is even");
        }
        else{
            System.out.println("it is odd");
        }

        sc.close();

    }
}
