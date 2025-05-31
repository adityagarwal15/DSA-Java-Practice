package Loops.GoodQuestions;

import java.util.*;
//print the table of a given number
public class MultTable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to get the table: ");
        int num = sc.nextInt();

        System.out.println("Multiplication table of " + num + ":");

        for (int i = 1; i <= 10; i++) {
            int result = num * i;
            System.out.println(num + " x " + i + " = " + result);
        }

        sc.close();
    }
}
