package StuckEasy;
import java.util.*;

public class LeapYear {

    public static void checkLeap(int year) {

        // the order is also important in this, first check 400-->100-->4
        if (year % 400 == 0) {
            //definitely a leap year
            System.out.println("It is a leap year: " + year);
        } else if (year % 100 == 0) {
            //definitely not a leap year
            System.out.println("It is not a leap year: " + year);
        } else if (year % 4 == 0) {
            //leap year
            System.out.println("It is a leap year: " + year);
        } else {
            System.out.println("It is not a leap year: " + year);
        }

        //another method
        // if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
        //    System.out.print("leap year");
        //}

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        checkLeap(year);

        sc.close();  // Good practice
    }
}
