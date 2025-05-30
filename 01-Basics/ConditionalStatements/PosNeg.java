package ConditionalStatements;
import java.util.*;
public class PosNeg {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
System.out.println("Enter a number: ");
int number = sc.nextInt();

if(number>0){
    System.out.println("Positive: " + number);
}
else if(number == 0){
    System.out.println("Zero is neither positive nor negative" + number);
}
else{
    System.out.println("Negative: " + number);
}

        sc.close();
    }
}
