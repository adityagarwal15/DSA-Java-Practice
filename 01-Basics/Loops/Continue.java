package Loops;
import java.util.*;
public class Continue {
    public static void main(String[] args){

        //print number 1 - 5 , and skip 3
        // for(int i =1; i<=5; i++){
        //     if(i==3){
        //         continue;
        //     }
        //  System.out.println(i);
        // }


        //display alll number entered by user except multiple of 10 using continue

Scanner sc = new Scanner(System.in);

do{
    System.out.print("enter number: ");
    int n = sc.nextInt();
    if(n%10==0){
        continue;
    }
    
    System.out.println("number entered is:" + n);
}while(true);
           
    }
}
