package ConditionalStatements;

import java.util.Scanner;

public class LeapYear {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a year: ");
        int year = sc.nextInt();

        // Leap year logic:
        // 1. If year is divisible by 400, then leap year
        // 2. Else if year is divisible by 100, then not leap year
        // 3. Else if year is divisible by 4, then leap year
        // 4. Else not a leap year

        if ((year % 400) == 0) {
            System.out.println(year + " is a leap year.");
        } else if ((year % 100) == 0) {
            System.out.println(year + " is not a leap year.");
        } else if ((year % 4) == 0) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        sc.close();
    }
}
