package ConditionalStatements;
import java.util.*;


public class LargestTwoNo {
    public static void main(String[] args){
Scanner sc = new Scanner(System.in);

System.out.println("Enter the number a: ");
int a = sc.nextInt();

System.out.println("Enter the number b: ");
int b = sc.nextInt();

if(a>b){
    System.out.println("a is the largest");
}
else{
    System.out.println("b is the largest");
}


sc.close();
    }
}
