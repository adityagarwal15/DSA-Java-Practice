package Loops.GoodQuestions;
import java.util.*;

public class Prime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = sc.nextInt();

        if(number <= 1) {  //check for number = 1
            System.out.println("Number is not prime: " + number);
        }
        else if(number == 2){   //check for number = 2
            System.out.println("Number is prime: " + number);
        }
        else {    //check for other numbers
            boolean isPrime = true;

            for(int i = 2; i <= Math.sqrt(number); i++){
                if(number % i == 0){
                    isPrime = false;
                    break; //to come out if it composite
                }
            }

            if(isPrime){
                System.out.println("Number is prime: " + number);
            } else {
                System.out.println("Number is composite: " + number);
            }
        }

        sc.close(); 
    }
}
