package Loops.MidQuestions;
import java.util.*;
public class PrintTillTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // while (true) {
        //     System.out.print("Enter a number: ");
        //     int n = sc.nextInt();

        //     if (n % 10 == 0) {
        //         System.out.println("Multiple of 10 entered. Exiting...");
        //         break;
        //     }

        //     System.out.println("You entered: " + n);
        // }


        //method2: using do while

        do{
            System.out.println("enter the number");
            int n =sc.nextInt();
            if(n%10==0){
                System.out.println("multiple of 10 entered, exiting..");
                break;
            }
            System.out.println(n);
        }while(true);

        sc.close();
    }
}



