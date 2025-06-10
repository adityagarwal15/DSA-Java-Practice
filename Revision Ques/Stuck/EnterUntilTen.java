package Stuck;
import java.util.*;

public class EnterUntilTen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int count = 0;
        //while is true for infinite loop
        while(true){
            // learning  - input will also be inside the loop to take mutiple inputs
            System.out.print("enter numbers: ");
            int n = sc.nextInt();
            if(n%10 == 0){
                System.out.println("exiting...");
                break;
            }
            count++;
        }
        System.out.print("number of numbers printed: " + count);

        sc.close();
    }
}
