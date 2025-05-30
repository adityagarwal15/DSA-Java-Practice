package ConditionalStatements;

import java.util.*;

public class IfElse1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("enter your age: ");
        int age = sc.nextInt();

        if(age >= 18){
            System.out.println("let him drive and vote");
        } else {
            System.out.println("stay inside boi");
        }

        sc.close();
    }
}
